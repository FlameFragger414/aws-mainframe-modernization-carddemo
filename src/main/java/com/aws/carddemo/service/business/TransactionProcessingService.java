package com.aws.carddemo.service.business;

import com.aws.carddemo.exception.ResourceNotFoundException;
import com.aws.carddemo.exception.ValidationException;
import com.aws.carddemo.model.dto.BatchResult;
import com.aws.carddemo.model.dto.TransactionDTO;
import com.aws.carddemo.model.entity.*;
import com.aws.carddemo.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionProcessingService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    private final CardRepository cardRepository;
    private final Cvact03YRepository xrefRepository;
    private final Cvtra01YRepository tcatBalRepository;

    @Transactional
    public Transaction addTransaction(TransactionDTO dto) {
        validateTransactionInput(dto);

        Account account = resolveAccount(dto);
        String cardNum = resolveCardNumber(dto, account.getAcctId());

        if (transactionRepository.existsById(dto.getTranId())) {
            throw new ValidationException("Transaction ID already exists: " + dto.getTranId());
        }

        Transaction transaction = Transaction.builder()
                .tranId(dto.getTranId())
                .tranTypeCd(dto.getTranTypeCd())
                .tranCatCd(dto.getTranCatCd())
                .tranSource(dto.getTranSource())
                .tranDesc(dto.getTranDesc())
                .tranAmt(dto.getTranAmt())
                .tranMerchantId(dto.getTranMerchantId())
                .tranMerchantName(dto.getTranMerchantName())
                .tranMerchantCity(dto.getTranMerchantCity())
                .tranMerchantZip(dto.getTranMerchantZip())
                .tranCardNum(cardNum)
                .tranOrigTs(dto.getTranOrigTs() != null ? dto.getTranOrigTs() : LocalDateTime.now())
                .tranProcTs(LocalDateTime.now())
                .account(account)
                .build();

        validateCreditLimit(account, transaction.getTranAmt());
        updateCategoryBalance(account.getAcctId(), transaction);
        updateAccountBalance(account, transaction.getTranAmt());
        return transactionRepository.save(transaction);
    }

    public List<Transaction> listTransactions() {
        return transactionRepository.findAll();
    }

    public List<Transaction> listTransactionsByAccount(Long accountId) {
        return transactionRepository.findByAccount_AcctId(accountId);
    }

    public Transaction getTransaction(String tranId) {
        return transactionRepository.findById(tranId)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found: " + tranId));
    }

    @Transactional
    public BatchResult postDailyTransactions(String inputFilePath) {
        List<String> rejections = new ArrayList<>();
        int processed = 0;
        int rejected = 0;

        try {
            List<String> lines = Files.readAllLines(Path.of(inputFilePath));
            for (String line : lines) {
                if (line.isBlank()) {
                    continue;
                }
                try {
                    TransactionDTO dto = parseDailyTransactionRecord(line);
                    addTransaction(dto);
                    processed++;
                } catch (ValidationException ex) {
                    rejected++;
                    rejections.add(ex.getMessage());
                }
            }
        } catch (Exception ex) {
            return BatchResult.builder()
                    .programName("CBTRN02C")
                    .recordsProcessed(processed)
                    .recordsRejected(rejected)
                    .success(false)
                    .message("Batch failed: " + ex.getMessage())
                    .build();
        }

        return BatchResult.builder()
                .programName("CBTRN02C")
                .recordsProcessed(processed)
                .recordsRejected(rejected)
                .success(rejected == 0)
                .message(rejected > 0
                        ? "Processed " + processed + " transactions with " + rejected + " rejections"
                        : "Processed " + processed + " transactions successfully")
                .build();
    }

    private void validateTransactionInput(TransactionDTO dto) {
        if (dto.getTranId() == null || dto.getTranId().isBlank()) {
            throw new ValidationException("Transaction ID can NOT be empty...");
        }
        if (dto.getTranAmt() == null) {
            throw new ValidationException("Transaction amount can NOT be empty...");
        }
        if (dto.getAccountId() == null && (dto.getTranCardNum() == null || dto.getTranCardNum().isBlank())) {
            throw new ValidationException("Account or Card Number must be entered...");
        }
    }

    private Account resolveAccount(TransactionDTO dto) {
        if (dto.getAccountId() != null) {
            return accountRepository.findById(dto.getAccountId())
                    .orElseThrow(() -> new ResourceNotFoundException("Account not found: " + dto.getAccountId()));
        }

        Cvact03Y xref = xrefRepository.findById(dto.getTranCardNum())
                .orElseThrow(() -> new ValidationException("INVALID CARD NUMBER FOUND"));

        return accountRepository.findById(xref.getXrefAcctId())
                .orElseThrow(() -> new ValidationException("ACCOUNT RECORD NOT FOUND"));
    }

    private String resolveCardNumber(TransactionDTO dto, Long accountId) {
        if (dto.getTranCardNum() != null && !dto.getTranCardNum().isBlank()) {
            return dto.getTranCardNum();
        }
        return xrefRepository.findByXrefAcctId(accountId)
                .map(Cvact03Y::getXrefCardNum)
                .orElseGet(() -> cardRepository.findByCardAcctId(accountId).stream()
                        .findFirst()
                        .map(Card::getCardNum)
                        .orElse(null));
    }

    private void validateCreditLimit(Account account, BigDecimal tranAmt) {
        BigDecimal credit = account.getAcctCurrCycCredit() != null ? account.getAcctCurrCycCredit() : BigDecimal.ZERO;
        BigDecimal debit = account.getAcctCurrCycDebit() != null ? account.getAcctCurrCycDebit() : BigDecimal.ZERO;
        BigDecimal limit = account.getAcctCreditLimit() != null ? account.getAcctCreditLimit() : BigDecimal.ZERO;
        BigDecimal projectedBalance = credit.subtract(debit).add(tranAmt);

        if (limit.compareTo(projectedBalance) < 0) {
            throw new ValidationException("OVERLIMIT TRANSACTION");
        }
    }

    private void updateCategoryBalance(Long accountId, Transaction transaction) {
        List<Cvtra01Y> balances = tcatBalRepository.findByTrancatAcctIdAndTrancatTypeCdAndTrancatCd(
                accountId, transaction.getTranTypeCd(), transaction.getTranCatCd());

        Cvtra01Y balance;
        if (balances.isEmpty()) {
            balance = Cvtra01Y.builder()
                    .trancatAcctId(accountId)
                    .trancatTypeCd(transaction.getTranTypeCd())
                    .trancatCd(transaction.getTranCatCd())
                    .tranCatBal(transaction.getTranAmt())
                    .build();
        } else {
            balance = balances.get(0);
            balance.setTranCatBal(balance.getTranCatBal().add(transaction.getTranAmt()));
        }
        tcatBalRepository.save(balance);
    }

    private void updateAccountBalance(Account account, BigDecimal tranAmt) {
        BigDecimal currentBal = account.getAcctCurrBal() != null ? account.getAcctCurrBal() : BigDecimal.ZERO;
        BigDecimal credit = account.getAcctCurrCycCredit() != null ? account.getAcctCurrCycCredit() : BigDecimal.ZERO;
        BigDecimal debit = account.getAcctCurrCycDebit() != null ? account.getAcctCurrCycDebit() : BigDecimal.ZERO;
        account.setAcctCurrBal(currentBal.add(tranAmt));
        if (tranAmt.compareTo(BigDecimal.ZERO) >= 0) {
            account.setAcctCurrCycCredit(credit.add(tranAmt));
        } else {
            account.setAcctCurrCycDebit(debit.add(tranAmt));
        }
        accountRepository.save(account);
    }

    private TransactionDTO parseDailyTransactionRecord(String line) {
        // CVTRA06Y / CVTRA05Y daily transaction layout (simplified fixed-width)
        return TransactionDTO.builder()
                .tranId(line.substring(0, Math.min(16, line.length())).trim())
                .tranTypeCd(safeSubstring(line, 16, 18))
                .tranCatCd(parseInteger(safeSubstring(line, 18, 22)))
                .tranSource(safeSubstring(line, 22, 32).trim())
                .tranDesc(safeSubstring(line, 32, 132).trim())
                .tranAmt(new BigDecimal(safeSubstring(line, 132, 143).trim()))
                .tranMerchantId(parseInteger(safeSubstring(line, 143, 152)))
                .tranMerchantName(safeSubstring(line, 152, 202).trim())
                .tranMerchantCity(safeSubstring(line, 202, 252).trim())
                .tranMerchantZip(safeSubstring(line, 252, 262).trim())
                .tranCardNum(safeSubstring(line, 262, 278).trim())
                .build();
    }

    private String safeSubstring(String line, int start, int end) {
        if (start >= line.length()) {
            return "";
        }
        return line.substring(start, Math.min(end, line.length()));
    }

    private Integer parseInteger(String value) {
        if (value == null || value.isBlank()) {
            return 0;
        }
        return Integer.parseInt(value.trim());
    }
}

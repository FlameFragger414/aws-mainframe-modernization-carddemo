package com.aws.carddemo.service.impl;

import com.aws.carddemo.exception.ResourceNotFoundException;
import com.aws.carddemo.model.dto.TransactionDTO;
import com.aws.carddemo.model.entity.Account;
import com.aws.carddemo.model.entity.Transaction;
import com.aws.carddemo.repository.AccountRepository;
import com.aws.carddemo.repository.TransactionRepository;
import com.aws.carddemo.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    @Override
    @Transactional
    public TransactionDTO processTransaction(TransactionDTO dto) {
        Account account = accountRepository.findById(dto.getAccountId())
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with ID: " + dto.getAccountId()));

        // Basic business logic from COBOL refactor requirements
        // If it's a debit, subtract from balance. If credit, add to balance.
        // Assuming type 'DB' for Debit and 'CR' for Credit based on common COBOL patterns
        if ("DB".equalsIgnoreCase(dto.getTranTypeCd())) {
            account.setAcctCurrBal(account.getAcctCurrBal().subtract(dto.getTranAmt()));
            account.setAcctCurrCycDebit(account.getAcctCurrCycDebit().add(dto.getTranAmt()));
        } else if ("CR".equalsIgnoreCase(dto.getTranTypeCd())) {
            account.setAcctCurrBal(account.getAcctCurrBal().add(dto.getTranAmt()));
            account.setAcctCurrCycCredit(account.getAcctCurrCycCredit().add(dto.getTranAmt()));
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
                .tranCardNum(dto.getTranCardNum())
                .tranOrigTs(dto.getTranOrigTs() != null ? dto.getTranOrigTs() : LocalDateTime.now())
                .tranProcTs(LocalDateTime.now())
                .account(account)
                .build();

        transactionRepository.save(transaction);
        accountRepository.save(account);

        return mapToDTO(transaction);
    }

    @Override
    public TransactionDTO getTransactionById(String id) {
        return transactionRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found with ID: " + id));
    }

    @Override
    public List<TransactionDTO> getTransactionsByAccountId(Long accountId) {
        // This would typically be a custom repository method, but for now we'll filter or assume a relationship
        return transactionRepository.findAll().stream()
                .filter(t -> t.getAccount().getAcctId().equals(accountId))
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private TransactionDTO mapToDTO(Transaction entity) {
        return TransactionDTO.builder()
                .tranId(entity.getTranId())
                .tranTypeCd(entity.getTranTypeCd())
                .tranCatCd(entity.getTranCatCd())
                .tranSource(entity.getTranSource())
                .tranDesc(entity.getTranDesc())
                .tranAmt(entity.getTranAmt())
                .tranMerchantId(entity.getTranMerchantId())
                .tranMerchantName(entity.getTranMerchantName())
                .tranMerchantCity(entity.getTranMerchantCity())
                .tranMerchantZip(entity.getTranMerchantZip())
                .tranCardNum(entity.getTranCardNum())
                .tranOrigTs(entity.getTranOrigTs())
                .tranProcTs(entity.getTranProcTs())
                .accountId(entity.getAccount().getAcctId())
                .build();
    }
}

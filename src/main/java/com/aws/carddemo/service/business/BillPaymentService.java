package com.aws.carddemo.service.business;

import com.aws.carddemo.exception.ResourceNotFoundException;
import com.aws.carddemo.exception.ValidationException;
import com.aws.carddemo.model.dto.BillPaymentRequest;
import com.aws.carddemo.model.dto.TransactionDTO;
import com.aws.carddemo.model.entity.Account;
import com.aws.carddemo.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BillPaymentService {

    private final AccountRepository accountRepository;
    private final TransactionProcessingService transactionProcessingService;

    @Transactional
    public Map<String, Object> processBillPayment(BillPaymentRequest request) {
        if (request.getAccountId() == null) {
            throw new ValidationException("Acct ID can NOT be empty...");
        }

        Account account = accountRepository.findById(request.getAccountId())
                .orElseThrow(() -> new ResourceNotFoundException("Account ID NOT found..."));

        BigDecimal balance = account.getAcctCurrBal();
        Map<String, Object> result = new HashMap<>();
        result.put("accountId", account.getAcctId());
        result.put("currentBalance", balance);

        if (balance.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValidationException("You have nothing to pay...");
        }

        if (!request.isConfirmed()) {
            result.put("confirmed", false);
            result.put("message", "Confirm to make a bill payment...");
            return result;
        }

        String nextTranId = generateNextTransactionId();

        TransactionDTO payment = TransactionDTO.builder()
                .tranId(nextTranId)
                .tranTypeCd("02")
                .tranCatCd(2)
                .tranSource("POS TERM")
                .tranDesc("BILL PAYMENT - ONLINE")
                .tranAmt(balance.negate())
                .tranMerchantId(999999999)
                .tranMerchantName("BILL PAYMENT")
                .tranMerchantCity("N/A")
                .tranMerchantZip("N/A")
                .accountId(account.getAcctId())
                .build();

        transactionProcessingService.addTransaction(payment);

        Account updated = accountRepository.findById(account.getAcctId()).orElse(account);
        result.put("confirmed", true);
        result.put("transactionId", nextTranId);
        result.put("paymentAmount", balance);
        result.put("newBalance", updated.getAcctCurrBal());
        result.put("message", "Bill payment processed successfully");
        return result;
    }

    private String generateNextTransactionId() {
        return "BP" + System.currentTimeMillis();
    }
}

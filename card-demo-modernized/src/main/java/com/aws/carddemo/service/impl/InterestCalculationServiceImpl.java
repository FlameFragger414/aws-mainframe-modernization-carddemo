package com.aws.carddemo.service.impl;

import com.aws.carddemo.model.entity.*;
import com.aws.carddemo.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;

/**
 * High-fidelity migration of CBACT04C.CBL interest calculation logic.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class InterestCalculationServiceImpl {

    private final Cvtra01YRepository tCatBalRepository;
    private final CardRepository cardRepository;
    private final Cvtra02YRepository discGrpRepository;
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    @Transactional
    public void calculateMonthlyInterest() {
        // Simulating the sequential read of TCATBAL-FILE
        List<Cvtra01Y> balances = tCatBalRepository.findAll();
        
        for (Cvtra01Y balance : balances) {
            Long acctId = balance.getTrancatAcctId();
            String typeCd = balance.getTrancatTypeCd();
            Integer catCd = balance.getTrancatCd();
            BigDecimal catBalance = balance.getTranCatBal();

            // 1. Get Disclosure Group (Interest Rate) - Parity with 1200-GET-INTEREST-RATE
            BigDecimal intRate = getInterestRate(acctId, typeCd, catCd);

            // 2. Compute Interest - Parity with 1300-COMPUTE-INTEREST
            // Formula: (Balance * Rate) / 1200
            BigDecimal monthlyInt = catBalance.multiply(intRate)
                    .divide(new BigDecimal("1200"), 2, RoundingMode.HALF_UP);

            if (monthlyInt.compareTo(BigDecimal.ZERO) > 0) {
                // 3. Create Interest Transaction - Parity with 1300-B-WRITE-TX
                postInterestTransaction(acctId, monthlyInt);
            }
        }
    }

    private BigDecimal getInterestRate(Long acctId, String typeCd, Integer catCd) {
        // Logic to find interest rate based on account group and transaction category
        // In COBOL, it reads DISCGRP-FILE with a composite key
        // Here we simulate the lookup:
        Account account = accountRepository.findById(acctId).orElse(null);
        String groupId = (account != null) ? account.getAcctGroupId() : "DEFAULT";

        return discGrpRepository.findAll().stream()
                .filter(dg -> dg.getDisAcctGroupId().equals(groupId) && 
                              dg.getDisTranTypeCd().equals(typeCd) && 
                              dg.getDisTranCatCd().equals(catCd))
                .map(Cvtra02Y::getDisIntRate)
                .findFirst()
                .orElse(new BigDecimal("12.00")); // Default fallback parity
    }

    private void postInterestTransaction(Long acctId, BigDecimal amount) {
        Card card = cardRepository.findAll().stream()
                .filter(c -> c.getCardAcctId().equals(acctId))
                .findFirst()
                .orElse(null);

        if (card == null) return;

        Transaction interestTx = Transaction.builder()
                .tranId("INT-" + System.currentTimeMillis())
                .tranTypeCd("01") // Parity with COBOL literal
                .tranCatCd(5)    // Parity with COBOL literal
                .tranSource("System")
                .tranDesc("Interest for a/c " + acctId)
                .tranAmt(amount)
                .tranCardNum(card.getCardNum())
                .tranOrigTs(LocalDateTime.now())
                .tranProcTs(LocalDateTime.now())
                .account(Account.builder().acctId(acctId).build())
                .build();

        transactionRepository.save(interestTx);
        
        // Update account balance
        Account account = accountRepository.findById(acctId).orElse(null);
        if (account != null) {
            account.setAcctCurrBal(account.getAcctCurrBal().add(amount));
            accountRepository.save(account);
        }
    }
}

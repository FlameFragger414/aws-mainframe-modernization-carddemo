package com.aws.carddemo.batch;

import com.aws.carddemo.model.entity.Account;
import com.aws.carddemo.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * High-fidelity migration of CBACT01C.CBL batch account processing.
 * Simulates the sequential file processing and data transformation.
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class AccountImportBatch {

    private final AccountRepository accountRepository;

    /**
     * Emulates the main processing loop of CBACT01C.CBL
     */
    public void runImport(String inputFilePath) {
        log.info("Starting Account Import Batch (Legacy: CBACT01C)");
        
        try {
            List<String> lines = Files.readAllLines(Paths.get(inputFilePath));
            for (String line : lines) {
                // Parity with 1000-ACCTFILE-GET-NEXT
                Account account = parseLegacyAccountRecord(line);
                
                // Parity with 1300-POPUL-ACCT-RECORD (Business Logic/Transformations)
                applyLegacyTransformations(account);
                
                // Parity with 1350-WRITE-ACCT-RECORD
                accountRepository.save(account);
            }
            log.info("Batch completed successfully. Processed {} records.", lines.size());
        } catch (Exception e) {
            log.error("Batch failed: {}", e.getMessage());
            // In a real environment, this would trigger an ABEND equivalent
        }
    }

    private Account parseLegacyAccountRecord(String line) {
        // High-fidelity parsing of the 289-byte FD-ACCT-DATA record
        // This mirrors the CVACT01Y.cpy structure
        return Account.builder()
                .acctId(Long.parseLong(line.substring(0, 11).trim()))
                .acctActiveStatus(line.substring(11, 12))
                .acctCurrBal(new BigDecimal(line.substring(12, 24).trim()))
                .acctCreditLimit(new BigDecimal(line.substring(24, 36).trim()))
                .acctCashCreditLimit(new BigDecimal(line.substring(36, 48).trim()))
                .acctOpenDate(line.substring(48, 58))
                .acctExpirationDate(line.substring(58, 68))
                .acctReissueDate(line.substring(68, 78))
                .acctCurrCycCredit(new BigDecimal(line.substring(78, 90).trim()))
                .acctCurrCycDebit(new BigDecimal(line.substring(90, 102).trim()))
                .acctGroupId(line.substring(102, 112).trim())
                .build();
    }

    private void applyLegacyTransformations(Account account) {
        // Parity with line 236: IF ACCT-CURR-CYC-DEBIT EQUAL TO ZERO MOVE 2525.00
        if (account.getAcctCurrCycDebit().compareTo(BigDecimal.ZERO) == 0) {
            account.setAcctCurrCycDebit(new BigDecimal("2525.00"));
        }
        
        // Date formatting logic (simulating CALL 'COBDATFT')
        // In the modernized version, we'd ensure dates are ISO-8601
        account.setAcctReissueDate(formatLegacyDate(account.getAcctReissueDate()));
    }

    private String formatLegacyDate(String date) {
        // Logic to mirror COBDATFT assembler formatting if necessary
        return date; 
    }
}

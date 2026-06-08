package com.aws.carddemo.batch;

import com.aws.carddemo.model.entity.Customer;
import com.aws.carddemo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * High-fidelity migration of CBCUS01C.CBL customer file processing.
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class CustomerImportBatch {

    private final CustomerRepository customerRepository;

    public int runImport(String inputFilePath) {
        log.info("Starting Customer Import Batch (Legacy: CBCUS01C)");
        try {
            List<String> lines = Files.readAllLines(Path.of(inputFilePath));
            for (String line : lines) {
                if (line.isBlank()) {
                    continue;
                }
                Customer customer = parseLegacyCustomerRecord(line);
                customerRepository.save(customer);
            }
            log.info("Customer batch completed. Processed {} records.", lines.size());
            return lines.size();
        } catch (Exception e) {
            log.error("Customer batch failed: {}", e.getMessage());
            throw new RuntimeException("Customer import failed: " + e.getMessage(), e);
        }
    }

    private Customer parseLegacyCustomerRecord(String line) {
        return Customer.builder()
                .custId(Long.parseLong(safeSubstring(line, 0, 9).trim()))
                .custFirstName(safeSubstring(line, 9, 34).trim())
                .custMiddleName(safeSubstring(line, 34, 59).trim())
                .custLastName(safeSubstring(line, 59, 84).trim())
                .custAddrLine1(safeSubstring(line, 84, 134).trim())
                .custAddrLine2(safeSubstring(line, 134, 184).trim())
                .custAddrLine3(safeSubstring(line, 184, 234).trim())
                .custAddrStateCd(safeSubstring(line, 234, 236).trim())
                .custAddrCountryCd(safeSubstring(line, 236, 239).trim())
                .custAddrZip(safeSubstring(line, 239, 249).trim())
                .custPhoneNum1(safeSubstring(line, 249, 264).trim())
                .custPhoneNum2(safeSubstring(line, 264, 279).trim())
                .custSsn(parseLong(safeSubstring(line, 279, 288)))
                .custGovtIssuedId(safeSubstring(line, 288, 308).trim())
                .custDobYyyymmdd(safeSubstring(line, 308, 318).trim())
                .custEftAccountId(safeSubstring(line, 318, 328).trim())
                .custPriCardHolderInd(safeSubstring(line, 328, 329).trim())
                .custFicoCreditScore(parseInteger(safeSubstring(line, 329, 332)))
                .build();
    }

    private String safeSubstring(String line, int start, int end) {
        if (start >= line.length()) {
            return "";
        }
        return line.substring(start, Math.min(end, line.length()));
    }

    private Long parseLong(String value) {
        if (value == null || value.isBlank()) {
            return 0L;
        }
        return Long.parseLong(value.trim());
    }

    private Integer parseInteger(String value) {
        if (value == null || value.isBlank()) {
            return 0;
        }
        return Integer.parseInt(value.trim());
    }
}

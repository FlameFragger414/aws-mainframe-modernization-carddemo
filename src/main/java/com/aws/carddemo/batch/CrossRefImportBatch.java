package com.aws.carddemo.batch;

import com.aws.carddemo.model.entity.Cvact03Y;
import com.aws.carddemo.repository.Cvact03YRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * High-fidelity migration of CBACT03C.CBL cross-reference file processing.
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class CrossRefImportBatch {

    private final Cvact03YRepository xrefRepository;

    public int runImport(String inputFilePath) {
        log.info("Starting Cross-Reference Import Batch (Legacy: CBACT03C)");
        try {
            List<String> lines = Files.readAllLines(Path.of(inputFilePath));
            for (String line : lines) {
                if (line.isBlank()) {
                    continue;
                }
                Cvact03Y xref = parseLegacyXrefRecord(line);
                xrefRepository.save(xref);
            }
            log.info("Cross-reference batch completed. Processed {} records.", lines.size());
            return lines.size();
        } catch (Exception e) {
            log.error("Cross-reference batch failed: {}", e.getMessage());
            throw new RuntimeException("Cross-reference import failed: " + e.getMessage(), e);
        }
    }

    private Cvact03Y parseLegacyXrefRecord(String line) {
        return Cvact03Y.builder()
                .xrefCardNum(line.substring(0, Math.min(16, line.length())).trim())
                .xrefCustId(Integer.parseInt(safeSubstring(line, 16, 25).trim()))
                .xrefAcctId(Long.parseLong(safeSubstring(line, 25, 36).trim()))
                .build();
    }

    private String safeSubstring(String line, int start, int end) {
        if (start >= line.length()) {
            return "0";
        }
        String value = line.substring(start, Math.min(end, line.length())).trim();
        return value.isEmpty() ? "0" : value;
    }
}

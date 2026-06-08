package com.aws.carddemo.batch;

import com.aws.carddemo.model.entity.Card;
import com.aws.carddemo.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * High-fidelity migration of CBACT02C.CBL card file processing.
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class CardImportBatch {

    private final CardRepository cardRepository;

    public int runImport(String inputFilePath) {
        log.info("Starting Card Import Batch (Legacy: CBACT02C)");
        try {
            List<String> lines = Files.readAllLines(Path.of(inputFilePath));
            for (String line : lines) {
                if (line.isBlank()) {
                    continue;
                }
                Card card = parseLegacyCardRecord(line);
                cardRepository.save(card);
            }
            log.info("Card batch completed. Processed {} records.", lines.size());
            return lines.size();
        } catch (Exception e) {
            log.error("Card batch failed: {}", e.getMessage());
            throw new RuntimeException("Card import failed: " + e.getMessage(), e);
        }
    }

    private Card parseLegacyCardRecord(String line) {
        return Card.builder()
                .cardNum(line.substring(0, Math.min(16, line.length())).trim())
                .cardAcctId(Long.parseLong(safeSubstring(line, 16, 27).trim()))
                .cardCvvCd(Integer.parseInt(safeSubstring(line, 27, 30).trim()))
                .cardEmbossedName(safeSubstring(line, 30, 80).trim())
                .cardExpirationDate(safeSubstring(line, 80, 90).trim())
                .cardActiveStatus(safeSubstring(line, 90, 91).trim())
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

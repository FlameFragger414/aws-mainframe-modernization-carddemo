package com.aws.carddemo.service.business;

import com.aws.carddemo.exception.ValidationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * Modernized CSUTLDTC date conversion utility.
 */
@Service
public class DateUtilityService {

    private static final DateTimeFormatter ISO = DateTimeFormatter.ISO_LOCAL_DATE;

    public Map<String, Object> convertDate(String inputDate, String targetFormat) {
        if (inputDate == null || inputDate.isBlank()) {
            throw new ValidationException("Date can NOT be empty...");
        }
        if (targetFormat == null || targetFormat.isBlank()) {
            targetFormat = "YYYY-MM-DD";
        }

        LocalDate parsed = parseFlexibleDate(inputDate.trim());
        String formatted = formatDate(parsed, targetFormat.trim().toUpperCase());

        Map<String, Object> result = new HashMap<>();
        result.put("inputDate", inputDate);
        result.put("targetFormat", targetFormat);
        result.put("formattedDate", formatted);
        result.put("severityCode", "0000");
        result.put("message", "Date converted successfully");
        return result;
    }

    private LocalDate parseFlexibleDate(String input) {
        String normalized = input.replace('/', '-');
        try {
            if (normalized.length() == 8 && !normalized.contains("-")) {
                return LocalDate.parse(normalized, DateTimeFormatter.BASIC_ISO_DATE);
            }
            return LocalDate.parse(normalized, ISO);
        } catch (DateTimeParseException ex) {
            throw new ValidationException("Invalid date format: " + input);
        }
    }

    private String formatDate(LocalDate date, String targetFormat) {
        return switch (targetFormat) {
            case "MM/DD/YY" -> date.format(DateTimeFormatter.ofPattern("MM/dd/yy"));
            case "MM-DD-YYYY" -> date.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
            case "YYYY-MM-DD", "YYYY/MM/DD" -> date.format(ISO);
            default -> date.format(ISO);
        };
    }
}

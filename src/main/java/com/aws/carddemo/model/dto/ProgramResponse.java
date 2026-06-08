package com.aws.carddemo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProgramResponse {
    private String programName;
    private boolean success;
    private String message;
    @Builder.Default
    private Map<String, Object> data = new HashMap<>();

    public static ProgramResponse success(String programName, String message) {
        return ProgramResponse.builder()
                .programName(programName)
                .success(true)
                .message(message)
                .build();
    }

    public static ProgramResponse success(String programName, String message, Map<String, Object> data) {
        return ProgramResponse.builder()
                .programName(programName)
                .success(true)
                .message(message)
                .data(data)
                .build();
    }

    public static ProgramResponse failure(String programName, String message) {
        return ProgramResponse.builder()
                .programName(programName)
                .success(false)
                .message(message)
                .build();
    }
}

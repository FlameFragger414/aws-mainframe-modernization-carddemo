package com.aws.carddemo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BatchResult {
    private String programName;
    private int recordsProcessed;
    private int recordsRejected;
    private String message;
    private boolean success;
}

package com.aws.carddemo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignOnResponse {
    private boolean authenticated;
    private String userId;
    private String userType;
    private String redirectProgram;
    private String message;
}

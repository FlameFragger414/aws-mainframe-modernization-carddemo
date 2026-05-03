package com.aws.carddemo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardUpdateDTO {
    private String cardEmbossedName;
    private String cardActiveStatus;
    private String expiryMonth;
    private String expiryYear;
}

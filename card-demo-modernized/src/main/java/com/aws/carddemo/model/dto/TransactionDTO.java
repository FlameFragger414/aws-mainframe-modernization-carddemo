package com.aws.carddemo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDTO {
    private String tranId;
    private String tranTypeCd;
    private Integer tranCatCd;
    private String tranSource;
    private String tranDesc;
    private BigDecimal tranAmt;
    private Integer tranMerchantId;
    private String tranMerchantName;
    private String tranMerchantCity;
    private String tranMerchantZip;
    private String tranCardNum;
    private LocalDateTime tranOrigTs;
    private LocalDateTime tranProcTs;
    private Long accountId;
}

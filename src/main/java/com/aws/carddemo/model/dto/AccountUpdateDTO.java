package com.aws.carddemo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountUpdateDTO {
    // Current Values for Update
    private String acctActiveStatus;
    private BigDecimal acctCurrBal;
    private BigDecimal acctCreditLimit;
    private BigDecimal acctCashCreditLimit;
    private String acctOpenDate;
    private String acctExpirationDate;
    private String acctGroupId;

    private Long custId;
    private String custFirstName;
    private String custMiddleName;
    private String custLastName;
    private String custAddrLine1;
    private String custAddrLine2;
    private String custAddrLine3;
    private String custAddrStateCd;
    private String custAddrZip;
    private String custPhoneNum1;
    private String custPhoneNum2;
    private Long custSsn;
    private Integer custFicoScore;

    // Old Values for Optimistic Locking (Parity with COBOL)
    private String oldActiveStatus;
    private BigDecimal oldCurrBal;
    private BigDecimal oldCreditLimit;
}

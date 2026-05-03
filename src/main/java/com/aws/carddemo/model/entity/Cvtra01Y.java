package com.aws.carddemo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cvtra01y")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cvtra01Y {

    @Id
    @Column(name = "trancat_acct_id")
    private Long trancatAcctId;

    @Column(name = "trancat_type_cd")
    private String trancatTypeCd;

    @Column(name = "trancat_cd")
    private Integer trancatCd;

    @Column(name = "tran_cat_bal")
    private BigDecimal tranCatBal;

}

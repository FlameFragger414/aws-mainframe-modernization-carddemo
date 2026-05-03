package com.aws.carddemo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cvtra02y")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cvtra02Y {

    @Id
    @Column(name = "dis_acct_group_id")
    private String disAcctGroupId;

    @Column(name = "dis_tran_type_cd")
    private String disTranTypeCd;

    @Column(name = "dis_tran_cat_cd")
    private Integer disTranCatCd;

    @Column(name = "dis_int_rate")
    private BigDecimal disIntRate;

}

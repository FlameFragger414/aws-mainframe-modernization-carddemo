package com.aws.carddemo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cvtra05y")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cvtra05Y {

    @Id
    @Column(name = "tran_id")
    private String tranId;

    @Column(name = "tran_type_cd")
    private String tranTypeCd;

    @Column(name = "tran_cat_cd")
    private Integer tranCatCd;

    @Column(name = "tran_source")
    private String tranSource;

    @Column(name = "tran_desc")
    private String tranDesc;

    @Column(name = "tran_amt")
    private BigDecimal tranAmt;

    @Column(name = "tran_merchant_id")
    private Integer tranMerchantId;

    @Column(name = "tran_merchant_name")
    private String tranMerchantName;

    @Column(name = "tran_merchant_city")
    private String tranMerchantCity;

    @Column(name = "tran_merchant_zip")
    private String tranMerchantZip;

    @Column(name = "tran_card_num")
    private String tranCardNum;

    @Column(name = "tran_orig_ts")
    private String tranOrigTs;

    @Column(name = "tran_proc_ts")
    private String tranProcTs;

}

package com.aws.carddemo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cvtra06y")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cvtra06Y {

    @Id
    @Column(name = "dalytran_id")
    private String dalytranId;

    @Column(name = "dalytran_type_cd")
    private String dalytranTypeCd;

    @Column(name = "dalytran_cat_cd")
    private Integer dalytranCatCd;

    @Column(name = "dalytran_source")
    private String dalytranSource;

    @Column(name = "dalytran_desc")
    private String dalytranDesc;

    @Column(name = "dalytran_amt")
    private BigDecimal dalytranAmt;

    @Column(name = "dalytran_merchant_id")
    private Integer dalytranMerchantId;

    @Column(name = "dalytran_merchant_name")
    private String dalytranMerchantName;

    @Column(name = "dalytran_merchant_city")
    private String dalytranMerchantCity;

    @Column(name = "dalytran_merchant_zip")
    private String dalytranMerchantZip;

    @Column(name = "dalytran_card_num")
    private String dalytranCardNum;

    @Column(name = "dalytran_orig_ts")
    private String dalytranOrigTs;

    @Column(name = "dalytran_proc_ts")
    private String dalytranProcTs;

}

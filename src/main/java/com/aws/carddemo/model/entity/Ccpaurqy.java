package com.aws.carddemo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ccpaurqy")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ccpaurqy {

    @Id
    @Column(name = "pa_rq_auth_date")
    private String paRqAuthDate;

    @Column(name = "pa_rq_auth_time")
    private String paRqAuthTime;

    @Column(name = "pa_rq_card_num")
    private String paRqCardNum;

    @Column(name = "pa_rq_auth_type")
    private String paRqAuthType;

    @Column(name = "pa_rq_card_expiry_date")
    private String paRqCardExpiryDate;

    @Column(name = "pa_rq_message_type")
    private String paRqMessageType;

    @Column(name = "pa_rq_message_source")
    private String paRqMessageSource;

    @Column(name = "pa_rq_processing_code")
    private Integer paRqProcessingCode;

    @Column(name = "pa_rq_merchant_catagory_code")
    private String paRqMerchantCatagoryCode;

    @Column(name = "pa_rq_acqr_country_code")
    private String paRqAcqrCountryCode;

    @Column(name = "pa_rq_pos_entry_mode")
    private Integer paRqPosEntryMode;

    @Column(name = "pa_rq_merchant_id")
    private String paRqMerchantId;

    @Column(name = "pa_rq_merchant_name")
    private String paRqMerchantName;

    @Column(name = "pa_rq_merchant_city")
    private String paRqMerchantCity;

    @Column(name = "pa_rq_merchant_state")
    private String paRqMerchantState;

    @Column(name = "pa_rq_merchant_zip")
    private Integer paRqMerchantZip;

    @Column(name = "pa_rq_transaction_id")
    private String paRqTransactionId;

}

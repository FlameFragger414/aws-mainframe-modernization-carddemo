package com.aws.carddemo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cipaudty")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cipaudty {

    @Id
    @Column(name = "pa_auth_date_9c")
    private Integer paAuthDate9C;

    @Column(name = "pa_auth_time_9c")
    private Integer paAuthTime9C;

    @Column(name = "pa_auth_orig_date")
    private String paAuthOrigDate;

    @Column(name = "pa_auth_orig_time")
    private String paAuthOrigTime;

    @Column(name = "pa_card_num")
    private String paCardNum;

    @Column(name = "pa_auth_type")
    private String paAuthType;

    @Column(name = "pa_card_expiry_date")
    private String paCardExpiryDate;

    @Column(name = "pa_message_type")
    private String paMessageType;

    @Column(name = "pa_message_source")
    private String paMessageSource;

    @Column(name = "pa_auth_id_code")
    private String paAuthIdCode;

    @Column(name = "pa_auth_resp_code")
    private String paAuthRespCode;

    @Column(name = "pa_auth_resp_reason")
    private String paAuthRespReason;

    @Column(name = "pa_processing_code")
    private Integer paProcessingCode;

    @Column(name = "pa_transaction_amt")
    private BigDecimal paTransactionAmt;

    @Column(name = "pa_approved_amt")
    private BigDecimal paApprovedAmt;

    @Column(name = "pa_merchant_catagory_code")
    private String paMerchantCatagoryCode;

    @Column(name = "pa_acqr_country_code")
    private String paAcqrCountryCode;

    @Column(name = "pa_pos_entry_mode")
    private Integer paPosEntryMode;

    @Column(name = "pa_merchant_id")
    private String paMerchantId;

    @Column(name = "pa_merchant_name")
    private String paMerchantName;

    @Column(name = "pa_merchant_city")
    private String paMerchantCity;

    @Column(name = "pa_merchant_state")
    private String paMerchantState;

    @Column(name = "pa_merchant_zip")
    private Integer paMerchantZip;

    @Column(name = "pa_transaction_id")
    private String paTransactionId;

    @Column(name = "pa_match_status")
    private String paMatchStatus;

    @Column(name = "pa_auth_fraud")
    private String paAuthFraud;

    @Column(name = "pa_fraud_rpt_date")
    private String paFraudRptDate;

}

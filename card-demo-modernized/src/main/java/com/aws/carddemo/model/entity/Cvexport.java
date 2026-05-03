package com.aws.carddemo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cvexport")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cvexport {

    @Id
    @Column(name = "export_rec_type")
    private String exportRecType;

    @Column(name = "export_timestamp")
    private String exportTimestamp;

    @Column(name = "export_date")
    private String exportDate;

    @Column(name = "export_date_time_sep")
    private String exportDateTimeSep;

    @Column(name = "export_time")
    private String exportTime;

    @Column(name = "export_sequence_num")
    private Integer exportSequenceNum;

    @Column(name = "export_branch_id")
    private String exportBranchId;

    @Column(name = "export_region_code")
    private String exportRegionCode;

    @Column(name = "export_record_data")
    private String exportRecordData;

    @Column(name = "exp_cust_id")
    private Integer expCustId;

    @Column(name = "exp_cust_first_name")
    private String expCustFirstName;

    @Column(name = "exp_cust_middle_name")
    private String expCustMiddleName;

    @Column(name = "exp_cust_last_name")
    private String expCustLastName;

    @Column(name = "exp_cust_addr_line")
    private String expCustAddrLine;

    @Column(name = "exp_cust_addr_state_cd")
    private String expCustAddrStateCd;

    @Column(name = "exp_cust_addr_country_cd")
    private String expCustAddrCountryCd;

    @Column(name = "exp_cust_addr_zip")
    private String expCustAddrZip;

    @Column(name = "exp_cust_phone_num")
    private String expCustPhoneNum;

    @Column(name = "exp_cust_ssn")
    private Integer expCustSsn;

    @Column(name = "exp_cust_govt_issued_id")
    private String expCustGovtIssuedId;

    @Column(name = "exp_cust_dob_yyyy_mm_dd")
    private String expCustDobYyyyMmDd;

    @Column(name = "exp_cust_eft_account_id")
    private String expCustEftAccountId;

    @Column(name = "exp_cust_pri_card_holder_ind")
    private String expCustPriCardHolderInd;

    @Column(name = "exp_cust_fico_credit_score")
    private Integer expCustFicoCreditScore;

    @Column(name = "exp_acct_id")
    private Long expAcctId;

    @Column(name = "exp_acct_active_status")
    private String expAcctActiveStatus;

    @Column(name = "exp_acct_curr_bal")
    private BigDecimal expAcctCurrBal;

    @Column(name = "exp_acct_credit_limit")
    private BigDecimal expAcctCreditLimit;

    @Column(name = "exp_acct_cash_credit_limit")
    private BigDecimal expAcctCashCreditLimit;

    @Column(name = "exp_acct_open_date")
    private String expAcctOpenDate;

    @Column(name = "exp_acct_expiraion_date")
    private String expAcctExpiraionDate;

    @Column(name = "exp_acct_reissue_date")
    private String expAcctReissueDate;

    @Column(name = "exp_acct_curr_cyc_credit")
    private BigDecimal expAcctCurrCycCredit;

    @Column(name = "exp_acct_curr_cyc_debit")
    private BigDecimal expAcctCurrCycDebit;

    @Column(name = "exp_acct_addr_zip")
    private String expAcctAddrZip;

    @Column(name = "exp_acct_group_id")
    private String expAcctGroupId;

    @Column(name = "exp_tran_id")
    private String expTranId;

    @Column(name = "exp_tran_type_cd")
    private String expTranTypeCd;

    @Column(name = "exp_tran_cat_cd")
    private Integer expTranCatCd;

    @Column(name = "exp_tran_source")
    private String expTranSource;

    @Column(name = "exp_tran_desc")
    private String expTranDesc;

    @Column(name = "exp_tran_amt")
    private BigDecimal expTranAmt;

    @Column(name = "exp_tran_merchant_id")
    private Integer expTranMerchantId;

    @Column(name = "exp_tran_merchant_name")
    private String expTranMerchantName;

    @Column(name = "exp_tran_merchant_city")
    private String expTranMerchantCity;

    @Column(name = "exp_tran_merchant_zip")
    private String expTranMerchantZip;

    @Column(name = "exp_tran_card_num")
    private String expTranCardNum;

    @Column(name = "exp_tran_orig_ts")
    private String expTranOrigTs;

    @Column(name = "exp_tran_proc_ts")
    private String expTranProcTs;

    @Column(name = "exp_xref_card_num")
    private String expXrefCardNum;

    @Column(name = "exp_xref_cust_id")
    private Integer expXrefCustId;

    @Column(name = "exp_xref_acct_id")
    private Long expXrefAcctId;

    @Column(name = "exp_card_num")
    private String expCardNum;

    @Column(name = "exp_card_acct_id")
    private Long expCardAcctId;

    @Column(name = "exp_card_cvv_cd")
    private Integer expCardCvvCd;

    @Column(name = "exp_card_embossed_name")
    private String expCardEmbossedName;

    @Column(name = "exp_card_expiraion_date")
    private String expCardExpiraionDate;

    @Column(name = "exp_card_active_status")
    private String expCardActiveStatus;

}

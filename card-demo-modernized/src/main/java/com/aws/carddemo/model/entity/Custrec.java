package com.aws.carddemo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "custrec")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Custrec {

    @Id
    @Column(name = "cust_id")
    private Integer custId;

    @Column(name = "cust_first_name")
    private String custFirstName;

    @Column(name = "cust_middle_name")
    private String custMiddleName;

    @Column(name = "cust_last_name")
    private String custLastName;

    @Column(name = "cust_addr_line_1")
    private String custAddrLine1;

    @Column(name = "cust_addr_line_2")
    private String custAddrLine2;

    @Column(name = "cust_addr_line_3")
    private String custAddrLine3;

    @Column(name = "cust_addr_state_cd")
    private String custAddrStateCd;

    @Column(name = "cust_addr_country_cd")
    private String custAddrCountryCd;

    @Column(name = "cust_addr_zip")
    private String custAddrZip;

    @Column(name = "cust_phone_num_1")
    private String custPhoneNum1;

    @Column(name = "cust_phone_num_2")
    private String custPhoneNum2;

    @Column(name = "cust_ssn")
    private Integer custSsn;

    @Column(name = "cust_govt_issued_id")
    private String custGovtIssuedId;

    @Column(name = "cust_dob_yyyymmdd")
    private String custDobYyyymmdd;

    @Column(name = "cust_eft_account_id")
    private String custEftAccountId;

    @Column(name = "cust_pri_card_holder_ind")
    private String custPriCardHolderInd;

    @Column(name = "cust_fico_credit_score")
    private Integer custFicoCreditScore;

}

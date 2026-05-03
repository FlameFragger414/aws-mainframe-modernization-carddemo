package com.aws.carddemo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cvact01y")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cvact01Y {

    @Id
    @Column(name = "acct_id")
    private Long acctId;

    @Column(name = "acct_active_status")
    private String acctActiveStatus;

    @Column(name = "acct_curr_bal")
    private BigDecimal acctCurrBal;

    @Column(name = "acct_credit_limit")
    private BigDecimal acctCreditLimit;

    @Column(name = "acct_cash_credit_limit")
    private BigDecimal acctCashCreditLimit;

    @Column(name = "acct_open_date")
    private String acctOpenDate;

    @Column(name = "acct_expiraion_date")
    private String acctExpiraionDate;

    @Column(name = "acct_reissue_date")
    private String acctReissueDate;

    @Column(name = "acct_curr_cyc_credit")
    private BigDecimal acctCurrCycCredit;

    @Column(name = "acct_curr_cyc_debit")
    private BigDecimal acctCurrCycDebit;

    @Column(name = "acct_addr_zip")
    private String acctAddrZip;

    @Column(name = "acct_group_id")
    private String acctGroupId;

}

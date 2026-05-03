package com.aws.carddemo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cipausmy")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cipausmy {

    @Id
    @Column(name = "pa_acct_id")
    private Long paAcctId;

    @Column(name = "pa_cust_id")
    private Integer paCustId;

    @Column(name = "pa_auth_status")
    private String paAuthStatus;

    @Column(name = "pa_account_status")
    private String paAccountStatus;

    @Column(name = "pa_credit_limit")
    private BigDecimal paCreditLimit;

    @Column(name = "pa_cash_limit")
    private BigDecimal paCashLimit;

    @Column(name = "pa_credit_balance")
    private BigDecimal paCreditBalance;

    @Column(name = "pa_cash_balance")
    private BigDecimal paCashBalance;

    @Column(name = "pa_approved_auth_cnt")
    private Integer paApprovedAuthCnt;

    @Column(name = "pa_declined_auth_cnt")
    private Integer paDeclinedAuthCnt;

    @Column(name = "pa_approved_auth_amt")
    private BigDecimal paApprovedAuthAmt;

    @Column(name = "pa_declined_auth_amt")
    private BigDecimal paDeclinedAuthAmt;

}

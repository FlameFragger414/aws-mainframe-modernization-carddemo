package com.aws.carddemo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ccpaurly")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ccpaurly {

    @Id
    @Column(name = "pa_rl_card_num")
    private String paRlCardNum;

    @Column(name = "pa_rl_transaction_id")
    private String paRlTransactionId;

    @Column(name = "pa_rl_auth_id_code")
    private String paRlAuthIdCode;

    @Column(name = "pa_rl_auth_resp_code")
    private String paRlAuthRespCode;

    @Column(name = "pa_rl_auth_resp_reason")
    private String paRlAuthRespReason;

}

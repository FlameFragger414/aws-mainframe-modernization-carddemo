package com.aws.carddemo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cvact02y")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cvact02Y {

    @Id
    @Column(name = "card_num")
    private String cardNum;

    @Column(name = "card_acct_id")
    private Long cardAcctId;

    @Column(name = "card_cvv_cd")
    private Integer cardCvvCd;

    @Column(name = "card_embossed_name")
    private String cardEmbossedName;

    @Column(name = "card_expiraion_date")
    private String cardExpiraionDate;

    @Column(name = "card_active_status")
    private String cardActiveStatus;

}

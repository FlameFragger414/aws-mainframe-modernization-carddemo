package com.aws.carddemo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cvact03y")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cvact03Y {

    @Id
    @Column(name = "xref_card_num")
    private String xrefCardNum;

    @Column(name = "xref_cust_id")
    private Integer xrefCustId;

    @Column(name = "xref_acct_id")
    private Long xrefAcctId;

}

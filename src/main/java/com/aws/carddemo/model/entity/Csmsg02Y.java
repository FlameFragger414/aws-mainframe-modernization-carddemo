package com.aws.carddemo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "csmsg02y")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Csmsg02Y {

    @Id
    @Column(name = "abend_code")
    private String abendCode;

    @Column(name = "abend_culprit")
    private String abendCulprit;

    @Column(name = "abend_reason")
    private String abendReason;

    @Column(name = "abend_msg")
    private String abendMsg;

}

package com.aws.carddemo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "codatecn")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Codatecn {

    @Id
    @Column(name = "codatecn_type")
    private String codatecnType;

    @Column(name = "codatecn_inp_date")
    private String codatecnInpDate;

    @Column(name = "codatecn_1yyyy")
    private String codatecn1Yyyy;

    @Column(name = "codatecn_1mm")
    private String codatecn1Mm;

    @Column(name = "codatecn_1dd")
    private String codatecn1Dd;

    @Column(name = "codatecn_1fil")
    private String codatecn1Fil;

    @Column(name = "codatecn_1o_yyyy")
    private String codatecn1OYyyy;

    @Column(name = "codatecn_1i_s1")
    private String codatecn1IS1;

    @Column(name = "codatecn_1mm")
    private String codatecn1Mm;

    @Column(name = "codatecn_1i_s2")
    private String codatecn1IS2;

    @Column(name = "codatecn_2yy")
    private String codatecn2Yy;

    @Column(name = "codatecn_2fil")
    private String codatecn2Fil;

    @Column(name = "codatecn_outtype")
    private String codatecnOuttype;

    @Column(name = "codatecn_0ut_date")
    private String codatecn0UtDate;

    @Column(name = "codatecn_1o_yyyy")
    private String codatecn1OYyyy;

    @Column(name = "codatecn_1o_s1")
    private String codatecn1OS1;

    @Column(name = "codatecn_1o_mm")
    private String codatecn1OMm;

    @Column(name = "codatecn_1o_s2")
    private String codatecn1OS2;

    @Column(name = "codatecn_1o_dd")
    private String codatecn1ODd;

    @Column(name = "codatecn_1ofil")
    private String codatecn1Ofil;

    @Column(name = "codatecn_2o_yyyy")
    private String codatecn2OYyyy;

    @Column(name = "codatecn_2o_mm")
    private String codatecn2OMm;

    @Column(name = "codatecn_2o_dd")
    private String codatecn2ODd;

    @Column(name = "codatecn_2ofil")
    private String codatecn2Ofil;

    @Column(name = "codatecn_error_msg")
    private String codatecnErrorMsg;

}

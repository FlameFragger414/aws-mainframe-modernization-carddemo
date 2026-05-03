package com.aws.carddemo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "imsfuncs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Imsfuncs {

    @Id
    @Column(name = "func_gu")
    private String funcGu;

    @Column(name = "func_ghu")
    private String funcGhu;

    @Column(name = "func_gn")
    private String funcGn;

    @Column(name = "func_ghn")
    private String funcGhn;

    @Column(name = "func_gnp")
    private String funcGnp;

    @Column(name = "func_ghnp")
    private String funcGhnp;

    @Column(name = "func_repl")
    private String funcRepl;

    @Column(name = "func_isrt")
    private String funcIsrt;

    @Column(name = "func_dlet")
    private String funcDlet;

    @Column(name = "parmcount")
    private Integer parmcount;

}

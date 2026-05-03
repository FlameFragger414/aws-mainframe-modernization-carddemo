package com.aws.carddemo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "coadm02y")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coadm02Y {

    @Id
    @Column(name = "cdemo_admin_opt_count")
    private Integer cdemoAdminOptCount;

    @Column(name = "cdemo_admin_opt_count")
    private Integer cdemoAdminOptCount;

    @Column(name = "cdemo_admin_opt_num")
    private Integer cdemoAdminOptNum;

    @Column(name = "cdemo_admin_opt_name")
    private String cdemoAdminOptName;

    @Column(name = "cdemo_admin_opt_pgmname")
    private String cdemoAdminOptPgmname;

}

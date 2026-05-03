package com.aws.carddemo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "comen02y")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comen02Y {

    @Id
    @Column(name = "cdemo_menu_opt_count")
    private Integer cdemoMenuOptCount;

    @Column(name = "cdemo_menu_opt_num")
    private Integer cdemoMenuOptNum;

    @Column(name = "cdemo_menu_opt_name")
    private String cdemoMenuOptName;

    @Column(name = "cdemo_menu_opt_pgmname")
    private String cdemoMenuOptPgmname;

    @Column(name = "cdemo_menu_opt_usrtype")
    private String cdemoMenuOptUsrtype;

}

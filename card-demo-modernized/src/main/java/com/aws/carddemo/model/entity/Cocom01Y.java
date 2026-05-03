package com.aws.carddemo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cocom01y")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cocom01Y {

    @Id
    @Column(name = "cdemo_from_tranid")
    private String cdemoFromTranid;

    @Column(name = "cdemo_from_program")
    private String cdemoFromProgram;

    @Column(name = "cdemo_to_tranid")
    private String cdemoToTranid;

    @Column(name = "cdemo_to_program")
    private String cdemoToProgram;

    @Column(name = "cdemo_user_id")
    private String cdemoUserId;

    @Column(name = "cdemo_user_type")
    private String cdemoUserType;

    @Column(name = "cdemo_pgm_context")
    private Integer cdemoPgmContext;

    @Column(name = "cdemo_cust_id")
    private Integer cdemoCustId;

    @Column(name = "cdemo_cust_fname")
    private String cdemoCustFname;

    @Column(name = "cdemo_cust_mname")
    private String cdemoCustMname;

    @Column(name = "cdemo_cust_lname")
    private String cdemoCustLname;

    @Column(name = "cdemo_acct_id")
    private Long cdemoAcctId;

    @Column(name = "cdemo_acct_status")
    private String cdemoAcctStatus;

    @Column(name = "cdemo_card_num")
    private Long cdemoCardNum;

    @Column(name = "cdemo_last_map")
    private String cdemoLastMap;

    @Column(name = "cdemo_last_mapset")
    private String cdemoLastMapset;

}

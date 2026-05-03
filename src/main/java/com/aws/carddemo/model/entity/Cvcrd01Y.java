package com.aws.carddemo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cvcrd01y")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cvcrd01Y {

    @Id
    @Column(name = "ccard_aid")
    private String ccardAid;

    @Column(name = "ccard_last_prog")
    private String ccardLastProg;

    @Column(name = "ccard_next_prog")
    private String ccardNextProg;

    @Column(name = "ccard_return_to_prog")
    private String ccardReturnToProg;

    @Column(name = "ccard_next_mapset")
    private String ccardNextMapset;

    @Column(name = "ccard_next_map")
    private String ccardNextMap;

    @Column(name = "ccard_return_flag")
    private String ccardReturnFlag;

    @Column(name = "ccard_error_msg")
    private String ccardErrorMsg;

    @Column(name = "ccard_return_msg")
    private String ccardReturnMsg;

    @Column(name = "ccard_function")
    private String ccardFunction;

    @Column(name = "cc_acct_id")
    private String ccAcctId;

    @Column(name = "cc_card_num")
    private String ccCardNum;

    @Column(name = "cc_cust_id")
    private Integer ccCustId;

}

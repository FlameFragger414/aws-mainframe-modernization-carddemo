package com.aws.carddemo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "csutldwy")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Csutldwy {

    @Id
    @Column(name = "ws_edit_date_cc")
    private String wsEditDateCc;

    @Column(name = "ws_edit_date_yy")
    private String wsEditDateYy;

    @Column(name = "ws_edit_date_mm")
    private String wsEditDateMm;

    @Column(name = "ws_edit_date_dd")
    private String wsEditDateDd;

    @Column(name = "ws_edit_date_binary")
    private Integer wsEditDateBinary;

    @Column(name = "ws_current_date_yyyymmdd")
    private String wsCurrentDateYyyymmdd;

    @Column(name = "ws_current_date_binary")
    private Integer wsCurrentDateBinary;

    @Column(name = "ws_edit_year_flg")
    private String wsEditYearFlg;

    @Column(name = "ws_edit_month")
    private String wsEditMonth;

    @Column(name = "ws_edit_day")
    private String wsEditDay;

    @Column(name = "ws_date_format")
    private String wsDateFormat;

    @Column(name = "ws_severity")
    private String wsSeverity;

    @Column(name = "ws_msg_no")
    private String wsMsgNo;

    @Column(name = "ws_result")
    private String wsResult;

    @Column(name = "ws_date")
    private String wsDate;

    @Column(name = "ws_date_fmt")
    private String wsDateFmt;

}

package com.aws.carddemo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cvtra07y")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cvtra07Y {

    @Id
    @Column(name = "rept_short_name")
    private String reptShortName;

    @Column(name = "rept_long_name")
    private String reptLongName;

    @Column(name = "rept_date_header")
    private String reptDateHeader;

    @Column(name = "rept_start_date")
    private String reptStartDate;

    @Column(name = "rept_end_date")
    private String reptEndDate;

    @Column(name = "tran_report_trans_id")
    private String tranReportTransId;

    @Column(name = "tran_report_account_id")
    private String tranReportAccountId;

    @Column(name = "tran_report_type_cd")
    private String tranReportTypeCd;

    @Column(name = "tran_report_type_desc")
    private String tranReportTypeDesc;

    @Column(name = "tran_report_cat_cd")
    private Integer tranReportCatCd;

    @Column(name = "tran_report_cat_desc")
    private Integer tranReportCatDesc;

    @Column(name = "tran_report_source")
    private String tranReportSource;

    @Column(name = "transaction_header_2")
    private String transactionHeader2;

}

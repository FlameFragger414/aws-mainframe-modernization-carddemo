package com.aws.carddemo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "csdat01y")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Csdat01Y {

    @Id
    @Column(name = "ws_curdate_year")
    private Integer wsCurdateYear;

    @Column(name = "ws_curdate_month")
    private Integer wsCurdateMonth;

    @Column(name = "ws_curdate_day")
    private Integer wsCurdateDay;

    @Column(name = "ws_curtime_hours")
    private Integer wsCurtimeHours;

    @Column(name = "ws_curtime_minute")
    private Integer wsCurtimeMinute;

    @Column(name = "ws_curtime_second")
    private Integer wsCurtimeSecond;

    @Column(name = "ws_curtime_milsec")
    private Integer wsCurtimeMilsec;

    @Column(name = "ws_curdate_mm")
    private Integer wsCurdateMm;

    @Column(name = "ws_curdate_dd")
    private Integer wsCurdateDd;

    @Column(name = "ws_curdate_yy")
    private Integer wsCurdateYy;

    @Column(name = "ws_curtime_hh")
    private Integer wsCurtimeHh;

    @Column(name = "ws_curtime_mm")
    private Integer wsCurtimeMm;

    @Column(name = "ws_curtime_ss")
    private Integer wsCurtimeSs;

    @Column(name = "ws_timestamp_dt_yyyy")
    private Integer wsTimestampDtYyyy;

    @Column(name = "ws_timestamp_dt_mm")
    private Integer wsTimestampDtMm;

    @Column(name = "ws_timestamp_dt_dd")
    private Integer wsTimestampDtDd;

    @Column(name = "ws_timestamp_tm_hh")
    private Integer wsTimestampTmHh;

    @Column(name = "ws_timestamp_tm_mm")
    private Integer wsTimestampTmMm;

    @Column(name = "ws_timestamp_tm_ss")
    private Integer wsTimestampTmSs;

    @Column(name = "ws_timestamp_tm_ms6")
    private Integer wsTimestampTmMs6;

}

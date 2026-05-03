package com.aws.carddemo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ccpauery")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ccpauery {

    @Id
    @Column(name = "err_date")
    private String errDate;

    @Column(name = "err_time")
    private String errTime;

    @Column(name = "err_application")
    private String errApplication;

    @Column(name = "err_program")
    private String errProgram;

    @Column(name = "err_location")
    private String errLocation;

    @Column(name = "err_level")
    private String errLevel;

    @Column(name = "err_subsystem")
    private String errSubsystem;

    @Column(name = "err_code_1")
    private Integer errCode1;

    @Column(name = "err_code_2")
    private Integer errCode2;

    @Column(name = "err_message")
    private String errMessage;

    @Column(name = "err_event_key")
    private String errEventKey;

}

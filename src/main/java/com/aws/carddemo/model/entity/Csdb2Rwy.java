package com.aws.carddemo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "csdb2rwy")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Csdb2Rwy {

    @Id
    @Column(name = "ws_dummy_db2_int")
    private Integer wsDummyDb2Int;

    @Column(name = "ws_db2_processing_flag")
    private String wsDb2ProcessingFlag;

    @Column(name = "ws_db2_current_action")
    private String wsDb2CurrentAction;

    @Column(name = "ws_dsntiac_mesg_len")
    private Integer wsDsntiacMesgLen;

    @Column(name = "ws_dsntiac_lrecl")
    private Integer wsDsntiacLrecl;

    @Column(name = "ws_dsntiac_err_msg")
    private String wsDsntiacErrMsg;

    @Column(name = "ws_dsntiac_err_cd_x")
    private String wsDsntiacErrCdX;

}

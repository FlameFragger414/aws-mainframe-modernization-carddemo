package com.aws.carddemo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "csusr01y")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Csusr01Y {

    @Id
    @Column(name = "sec_usr_id")
    private String secUsrId;

    @Column(name = "sec_usr_fname")
    private String secUsrFname;

    @Column(name = "sec_usr_lname")
    private String secUsrLname;

    @Column(name = "sec_usr_pwd")
    private String secUsrPwd;

    @Column(name = "sec_usr_type")
    private String secUsrType;

    @Column(name = "sec_usr_filler")
    private String secUsrFiller;

}

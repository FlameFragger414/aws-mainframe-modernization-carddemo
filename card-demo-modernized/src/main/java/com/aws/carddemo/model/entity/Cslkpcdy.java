package com.aws.carddemo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cslkpcdy")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cslkpcdy {

    @Id
    @Column(name = "ws_us_phone_area_code_to_edit")
    private String wsUsPhoneAreaCodeToEdit;

    @Column(name = "us_state_code_to_edit")
    private String usStateCodeToEdit;

    @Column(name = "us_state_and_first_zip2")
    private String usStateAndFirstZip2;

    @Column(name = "last_3_of_zip")
    private String last3OfZip;

}

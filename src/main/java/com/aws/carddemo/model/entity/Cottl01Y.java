package com.aws.carddemo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cottl01y")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cottl01Y {

    @Id
    @Column(name = "ccda_title01")
    private String ccdaTitle01;

    @Column(name = "ccda_title02")
    private String ccdaTitle02;

    @Column(name = "ccda_thank_you")
    private String ccdaThankYou;

}

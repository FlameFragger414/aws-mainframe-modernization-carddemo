package com.aws.carddemo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "csmsg01y")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Csmsg01Y {

    @Id
    @Column(name = "ccda_msg_thank_you")
    private String ccdaMsgThankYou;

    @Column(name = "ccda_msg_invalid_key")
    private String ccdaMsgInvalidKey;

}

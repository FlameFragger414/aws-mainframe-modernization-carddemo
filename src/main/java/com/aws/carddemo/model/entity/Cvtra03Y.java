package com.aws.carddemo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cvtra03y")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cvtra03Y {

    @Id
    @Column(name = "tran_type")
    private String tranType;

    @Column(name = "tran_type_desc")
    private String tranTypeDesc;

}

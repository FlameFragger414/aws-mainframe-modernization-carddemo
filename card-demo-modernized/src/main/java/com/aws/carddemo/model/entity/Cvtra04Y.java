package com.aws.carddemo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cvtra04y")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cvtra04Y {

    @Id
    @Column(name = "tran_type_cd")
    private String tranTypeCd;

    @Column(name = "tran_cat_cd")
    private Integer tranCatCd;

    @Column(name = "tran_cat_type_desc")
    private String tranCatTypeDesc;

}

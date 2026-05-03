package com.aws.carddemo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "unused1y")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Unused1Y {

    @Id
    @Column(name = "unused_id")
    private String unusedId;

    @Column(name = "unused_fname")
    private String unusedFname;

    @Column(name = "unused_lname")
    private String unusedLname;

    @Column(name = "unused_pwd")
    private String unusedPwd;

    @Column(name = "unused_type")
    private String unusedType;

    @Column(name = "unused_filler")
    private String unusedFiller;

}

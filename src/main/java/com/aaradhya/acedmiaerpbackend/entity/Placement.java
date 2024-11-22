package com.aaradhya.acedmiaerpbackend.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "placement")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Placement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "organization_fk", referencedColumnName = "id")
    private Organization organization; // Assuming Organization entity exists

    @Column(name = "profile", length = 100)
    private String profile;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "intake")
    private int intake;

    @Column(name = "minimum_grade", precision = 3, scale = 2)
    private BigDecimal minimumGrade;
}


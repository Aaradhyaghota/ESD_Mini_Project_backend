package com.aaradhya.acedmiaerpbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int studentId;

    @Column(name = "roll_number", unique = true, nullable = false, length = 20)
    private String rollNumber;

    @Column(name = "first_name", length = 100)
    private String firstName;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @Column(name = "email", unique = true, nullable = false, length = 255)
    private String email;

    @Column(name = "photograph_path", length = 255)
    private String photographPath;

    @Column(name = "cgpa", precision = 3, scale = 2)
    private BigDecimal cgpa;

    @Column(name = "total_credits")
    private int totalCredits;

    @Column(name = "graduation_year")
    private int graduationYear;

    @ManyToOne
    @JoinColumn(name = "domain_fk", referencedColumnName = "domain_id")
    private Domain domain; // Assuming a Domain entity exists

    @ManyToOne
    @JoinColumn(name = "specialization_fk", referencedColumnName = "specialization_id")
    private Specialization specialization; // Assuming a Specialization entity exists

    @ManyToOne
    @JoinColumn(name = "placement_fk", referencedColumnName = "id")
    private Placement placement; // Assuming a Placement entity exists
}


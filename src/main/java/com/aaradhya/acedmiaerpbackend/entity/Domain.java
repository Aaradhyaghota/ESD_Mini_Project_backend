package com.aaradhya.acedmiaerpbackend.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "domains")
public class Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "domain_id")
    private int domainId;

    @Column(name = "program", length = 100)
    private String program;

    @Column(name = "batch")
    private int batch;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "qualification", length = 255)
    private String qualification;
}


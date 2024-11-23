package com.aaradhya.acedmiaerpbackend.controller;

import com.aaradhya.acedmiaerpbackend.entity.Domain;
import com.aaradhya.acedmiaerpbackend.entity.Placement;
import com.aaradhya.acedmiaerpbackend.entity.Specialization;
import com.aaradhya.acedmiaerpbackend.entity.Students;
import com.aaradhya.acedmiaerpbackend.service.StudentServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class studentController {

    private final StudentServices studentServices;


    @PostMapping("/register")
    public ResponseEntity<String> registerStudent(
            @RequestParam("first_name") String firstname,
            @RequestParam("last_name") String lastname,
            @RequestParam("email") String email,
            @RequestParam("photograph") MultipartFile photograph,
            @RequestParam("cgpa") BigDecimal cgpa, // This will be used to generate roll number (e.g. iM.Tech, M.Tech etc.)
            @RequestParam("totalCredits") int totalCredits,
            @RequestParam("graduationYear") int graduationYear, // E.g., 2020
            @RequestParam("domain_id") int domain_fk,
            @RequestParam("specialization_id") int specialization_fk,
            @RequestParam("placement_id") int placement_fk
    ) {

        Domain domain = studentServices.getDomain(domain_fk);
        Specialization specialization = studentServices.getSpez(specialization_fk);
        Placement placement = studentServices.getPlacement(placement_fk);
        Students student = Students.builder()
                .firstName(firstname)
                .lastName(lastname)
                .email(email)
                .cgpa(cgpa)
                .totalCredits(totalCredits)
                .graduationYear(graduationYear)
                .domain(domain)
                .specialization(specialization)
                .placement(placement)
                .build();
        return ResponseEntity.ok(studentServices.registerStudent(student, photograph));
    }

    @GetMapping("/domains")
    public ResponseEntity<List<Domain>> getAllDomains() {
        return ResponseEntity.ok(studentServices.getAllDomains());
    }

    @GetMapping("/specialization")
    public ResponseEntity<List<Specialization>> getAllSpecializations() {
        return ResponseEntity.ok(studentServices.getAllSpecializations());
    }

    @GetMapping("/placement")
    public ResponseEntity<List<Placement>> getAllPlacements() {
        return ResponseEntity.ok(studentServices.getAllPlacement());
    }

}

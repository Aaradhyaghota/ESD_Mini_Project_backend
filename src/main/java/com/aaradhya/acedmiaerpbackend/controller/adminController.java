package com.aaradhya.acedmiaerpbackend.controller;

import com.aaradhya.acedmiaerpbackend.dto.AdminRequest;
import com.aaradhya.acedmiaerpbackend.service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class adminController {
    private final AdminService adminService;

    @RequestMapping("/")
    public String greet() {
        return "Hello World!";
    }

    @PostMapping("/add")
    public ResponseEntity<String> addAmin(@RequestBody @Valid AdminRequest request) {
        return ResponseEntity.ok(adminService.addAdmin(request));
    }

}

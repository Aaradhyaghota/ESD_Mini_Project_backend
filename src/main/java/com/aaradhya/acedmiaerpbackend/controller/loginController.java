package com.aaradhya.acedmiaerpbackend.controller;

import com.aaradhya.acedmiaerpbackend.dto.AdminRequest;
import com.aaradhya.acedmiaerpbackend.service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class loginController {
    private final adminController adminController;
    private final AdminService adminService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid AdminRequest request){
        String token = adminService.loginAdmin(request);
        return ResponseEntity.ok(token);
    }

}

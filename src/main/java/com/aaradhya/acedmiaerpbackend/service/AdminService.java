package com.aaradhya.acedmiaerpbackend.service;

import com.aaradhya.acedmiaerpbackend.dto.AdminRequest;
import com.aaradhya.acedmiaerpbackend.entity.Admin;
import com.aaradhya.acedmiaerpbackend.helper.EncryptionService;
import com.aaradhya.acedmiaerpbackend.helper.JwtHelper;
import com.aaradhya.acedmiaerpbackend.mapper.AdminMapper;
import com.aaradhya.acedmiaerpbackend.repo.AdminRepo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminMapper adminMapper;
    private final EncryptionService encryptionService;
    private final AdminRepo adminRepo;
    private final JwtHelper jwtHelper;

    public String addAdmin(@Valid AdminRequest request) {
        Admin admin = adminMapper.toEntity(request);
        admin.setPassword(encryptionService.encode(admin.getPassword()));
        adminRepo.save(admin);
        return "Created Admin";
    }

    public Admin getAdminEmail(String email) {
        return adminRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Admin not found") );
    }

    public String loginAdmin(@Valid AdminRequest request) {
        Admin admin = getAdminEmail(request.email());
        if(!encryptionService.validates(request.password(), admin.getPassword())) {
            throw new RuntimeException("Invalid password or Email");
        }
        return jwtHelper.generateToken(request.email());
    }
}


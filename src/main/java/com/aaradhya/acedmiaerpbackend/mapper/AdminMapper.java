package com.aaradhya.acedmiaerpbackend.mapper;

import com.aaradhya.acedmiaerpbackend.dto.AdminRequest;
import com.aaradhya.acedmiaerpbackend.entity.Admin;
import org.springframework.stereotype.Service;

@Service
public class AdminMapper {

    public Admin toEntity(AdminRequest request) {
        return Admin.builder()
                .email(request.email())
                .password(request.password())
                .build();
    }
}

package com.aaradhya.acedmiaerpbackend.helper;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EncryptionService {
    public String encode(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean validates(String password, String encodedPassword) {
        return BCrypt.checkpw(password, encodedPassword);
    }
}


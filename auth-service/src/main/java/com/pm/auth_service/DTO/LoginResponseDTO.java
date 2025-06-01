package com.pm.auth_service.DTO;

import lombok.Getter;

@Getter
public class LoginResponseDTO {
    // will be JWT token
    private final String token;

    public LoginResponseDTO(String token) {
        this.token = token;
    }
}

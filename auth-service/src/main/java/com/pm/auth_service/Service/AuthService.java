package com.pm.auth_service.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pm.auth_service.DTO.LoginRequestDTO;
import com.pm.auth_service.Model.User;
import com.pm.auth_service.Repo.AuthRepo;

@Service
public class AuthService {
    private final AuthRepo authRepo;

    public AuthService(AuthRepo authRepo) {
        this.authRepo = authRepo;
    }

    public Optional<String> authenticate(LoginRequestDTO loginRequest) {
        Optional<User> user = authRepo.findByEmail(loginRequest.getEmail())
                .filter(u -> passwordEncoder.matches(loginRequest.getPassword(),
                        u.getPassword())
                        .map(u -> jwtUtil.generateToken(u.getEmail(), u.getRole())));

    }

}

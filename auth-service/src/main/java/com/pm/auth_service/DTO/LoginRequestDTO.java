package com.pm.auth_service.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDTO {
    @NotBlank(message = "Email is required")
    @Email(message = "wrong format")
    private String email;

    @NotBlank(message = "passis required")
    @Size(min = 6, message = "Password must be 6 characters long")
    private String password;
}

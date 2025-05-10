package com.pm.patient_service.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientRequestDTO {
    @NotNull(message = "name is required")
    @Size(max = 100, message = "Name no more than 100 characters")
    private String name;

    @NotNull(message = "email is required")
    @Email
    private String email;

    @NotNull(message = "address is required")
    private String address;

    @NotNull(message = "Date of birth is required")
    private String dateOfBirth;

    @NotNull
    private String registeredDate;
}

package com.pm.patient_service.DTO;

import com.pm.patient_service.DTO.validators.CreatePatientValidationGroup;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientRequestDTO {
    @NotBlank(message = "name is required")
    @Size(max = 100, message = "Name no more than 100 characters")
    private String name;

    @NotBlank(message = "email is required")
    @Email
    private String email;

    @NotBlank(message = "address is required")
    private String address;

    @NotBlank(message = "Date of birth is required")
    private String dateOfBirth;

    // makes it so that its only checks for the creation of patients not editing
    @NotBlank(groups = CreatePatientValidationGroup.class)
    private String registeredDate;
}

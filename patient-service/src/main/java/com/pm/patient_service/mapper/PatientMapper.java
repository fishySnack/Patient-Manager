package com.pm.patient_service.mapper;

import java.time.LocalDate;

import com.pm.patient_service.DTO.PatientRequestDTO;
import com.pm.patient_service.DTO.PatientResponseDTO;
import com.pm.patient_service.model.Patient;

public class PatientMapper {
    /**
     * @return parse patient to patientDTO
     */
    public static PatientResponseDTO toDTO(Patient patient) {
        PatientResponseDTO patientDTO = new PatientResponseDTO();
        patientDTO.setId(patient.getId().toString());
        patientDTO.setEmail(patient.getEmail());
        patientDTO.setName(patient.getName());
        patientDTO.setAddress(patient.getAddress());
        patientDTO.setDateOfBirth(patient.getDateOfBirth().toString());
        return patientDTO;
    }

    /**
     * @return parse patientDTO to patient
     */
    public static Patient toModel(PatientRequestDTO patientDTO) {
        Patient patient = new Patient();
        patient.setName(patientDTO.getName());
        patient.setAddress(patientDTO.getAddress());
        patient.setEmail(patientDTO.getEmail());
        patient.setDateOfBirth(LocalDate.parse(patientDTO.getDateOfBirth()));
        patient.setRegisteredDate(LocalDate.parse(patientDTO.getRegisteredDate()));
        return patient;
    }
}

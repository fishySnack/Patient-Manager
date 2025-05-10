package com.pm.patient_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pm.patient_service.DTO.PatientRequestDTO;
import com.pm.patient_service.DTO.PatientResponseDTO;
import com.pm.patient_service.mapper.PatientMapper;
import com.pm.patient_service.model.Patient;
import com.pm.patient_service.repository.PatientRepo;

@Service
public class PatientService {
    private final PatientRepo repo;

    public PatientService(PatientRepo repo) {
        this.repo = repo;
    }

    public List<PatientResponseDTO> getPatients() {
        List<Patient> patients = repo.findAll();
        List<PatientResponseDTO> output = new ArrayList<>();
        for (Patient patient : patients) {
            output.add(PatientMapper.toDTO(patient));
        }
        return output;
    }

    public PatientResponseDTO createPatient(PatientRequestDTO patient) {
        Patient newPatient = repo.save(PatientMapper.toModel(patient));
        return PatientMapper.toDTO(newPatient);
    }

}

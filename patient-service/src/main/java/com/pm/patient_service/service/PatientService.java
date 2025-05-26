package com.pm.patient_service.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.pm.patient_service.BillServiceClient.BillServiceClient;
import com.pm.patient_service.DTO.PatientRequestDTO;
import com.pm.patient_service.DTO.PatientResponseDTO;
import com.pm.patient_service.exception.EmailAlreadyExistsException;
import com.pm.patient_service.exception.PatientNotFoundException;
import com.pm.patient_service.mapper.PatientMapper;
import com.pm.patient_service.model.Patient;
import com.pm.patient_service.repository.PatientRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PatientService {
    private final PatientRepo repo;
    private final BillServiceClient client;

    public PatientService(PatientRepo repo, BillServiceClient client) {
        this.repo = repo;
        this.client = client;
    }

    /**
     * 
     * @return all the patients
     */
    public List<PatientResponseDTO> getPatients() {
        List<Patient> patients = repo.findAll();
        List<PatientResponseDTO> output = new ArrayList<>();
        for (Patient patient : patients) {
            output.add(PatientMapper.toDTO(patient));
        }
        return output;
    }

    /**
     * parse into patient object and saves then return patientDTO
     * 
     * @return patientDTO
     */
    public PatientResponseDTO createPatient(PatientRequestDTO patient) {
        if (repo.existsByEmail(patient.getEmail()))
            throw new EmailAlreadyExistsException("Email already exist");

        Patient newPatient = repo.save(PatientMapper.toModel(patient));
        log.info("right before client call");
        client.createBillingAccount(newPatient.getId().toString(), newPatient.getName(), newPatient.getEmail());

        return PatientMapper.toDTO(newPatient);
    }

    public PatientResponseDTO updatePatient(UUID id, PatientRequestDTO patient) {
        Optional<Patient> newPatient = repo.findById(id);
        if (newPatient.isEmpty())
            throw new PatientNotFoundException("Patient not foound with id: " + id);

        if (repo.existsByEmailAndIdNot(patient.getEmail(), id)) {
            throw new EmailAlreadyExistsException("Email already exist");
        }

        Patient p = newPatient.get();

        p.setName(patient.getName());
        p.setAddress(patient.getAddress());
        p.setDateOfBirth(LocalDate.parse(patient.getDateOfBirth()));
        p.setEmail(patient.getEmail());

        return PatientMapper.toDTO(repo.save(p));
    }

    public void deleteById(UUID id) {
        repo.deleteById(id);
    }

}

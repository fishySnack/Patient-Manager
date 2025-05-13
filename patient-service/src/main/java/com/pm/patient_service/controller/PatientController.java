package com.pm.patient_service.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pm.patient_service.DTO.PatientRequestDTO;
import com.pm.patient_service.DTO.PatientResponseDTO;
import com.pm.patient_service.DTO.validators.CreatePatientValidationGroup;
import com.pm.patient_service.service.PatientService;

import jakarta.validation.Valid;
import jakarta.validation.groups.Default;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService service;

    public PatientController(PatientService service) {
        this.service = service;
    }

    /**
     * @return gets all the patients
     */
    @GetMapping("")
    public ResponseEntity<List<PatientResponseDTO>> getPatients() {
        return ResponseEntity.ok().body(service.getPatients());
    }

    /**
     * @param valid checks if the field matches the requirements
     * @return reponseEntity with patientDTO
     */

    @PostMapping("")
    public ResponseEntity<PatientResponseDTO> createPatient(
            @Validated({ Default.class, CreatePatientValidationGroup.class }) @RequestBody PatientRequestDTO patient) {

        PatientResponseDTO patientResponseDTO = service.createPatient(patient);
        return ResponseEntity.ok().body(patientResponseDTO);
    }

    /**
     * 
     * @param patient
     * @return patent response DTO
     */
    @PutMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> updatePatient(@Valid @PathVariable UUID id,
            @Valid @RequestBody PatientRequestDTO patient) {
        PatientResponseDTO patientResponseDTO = service.updatePatient(id, patient);
        return ResponseEntity.ok().body(patientResponseDTO);
    }
}

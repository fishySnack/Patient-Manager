package com.pm.patient_service.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;

@RestController
@RequestMapping("/patients")
@Tag(name = "Patient", description = "API for managing patients")
public class PatientController {
    private final PatientService service;

    public PatientController(PatientService service) {
        this.service = service;
    }

    @Operation(summary = "Get patients")
    @GetMapping("")
    public ResponseEntity<List<PatientResponseDTO>> getPatients() {
        return ResponseEntity.ok().body(service.getPatients());
    }

    @Operation(summary = "Add patient")
    @PostMapping("")
    public ResponseEntity<PatientResponseDTO> createPatient(
            @Validated({ Default.class, CreatePatientValidationGroup.class }) @RequestBody PatientRequestDTO patient) {

        PatientResponseDTO patientResponseDTO = service.createPatient(patient);
        return ResponseEntity.ok().body(patientResponseDTO);
    }

    @Operation(summary = "Edit patient by Id")
    @PutMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> updatePatient(@Valid @PathVariable UUID id,
            @Valid @RequestBody PatientRequestDTO patient) {
        PatientResponseDTO patientResponseDTO = service.updatePatient(id, patient);
        return ResponseEntity.ok().body(patientResponseDTO);
    }

    @Operation(summary = "Delete patient by Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@Valid @PathVariable UUID id) {
        service.deleteById(id);
        // return status code 204 which is a REST standard for delete
        return ResponseEntity.noContent().build();
    }
}

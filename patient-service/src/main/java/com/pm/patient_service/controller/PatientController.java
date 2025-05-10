package com.pm.patient_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pm.patient_service.DTO.PatientRequestDTO;
import com.pm.patient_service.DTO.PatientResponseDTO;
import com.pm.patient_service.service.PatientService;

import jakarta.validation.Valid;

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
    public ResponseEntity<PatientResponseDTO> createPatient(@RequestBody @Valid PatientRequestDTO patient) {

        PatientResponseDTO patientResponseDTO = service.createPatient(patient);
        return ResponseEntity.ok().body(patientResponseDTO);
    }
}

package com.pm.patient_service.PatientEvents;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PatientEvent {
    private String patientId;
    private String name;
    private String email;
    private String eventType;
}

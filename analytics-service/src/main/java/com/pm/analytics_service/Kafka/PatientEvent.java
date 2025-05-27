package com.pm.analytics_service.Kafka;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientEvent {
    private String patientId;
    private String name;
    private String email;
    private String eventType;
}

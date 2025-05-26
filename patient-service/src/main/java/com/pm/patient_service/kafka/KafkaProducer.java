package com.pm.patient_service.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pm.patient_service.PatientEvents.PatientEvent;
import com.pm.patient_service.model.Patient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KafkaProducer {
    private final KafkaTemplate<String, byte[]> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, byte[]> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEvent(Patient patient) {
        PatientEvent event = PatientEvent.builder().patientId(patient.getId().toString())
                .name(patient.getName()).email(patient.getEmail()).eventType("PATIENT_CREATED").build();

        ObjectMapper mapper = new ObjectMapper();
        try {
            kafkaTemplate.send("patient", mapper.writeValueAsBytes(event));
        } catch (Exception e) {
            log.error("Failed to send event Kafka", e);
        }
    }
}

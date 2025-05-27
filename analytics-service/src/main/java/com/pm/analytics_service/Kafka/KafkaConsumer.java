package com.pm.analytics_service.Kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "patient", groupId = "analytics-service")
    public void consumeEvent(byte[] event) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            PatientEvent patientE = objectMapper.readValue(event, PatientEvent.class);
            // preform any buiness related to analytics here ---
            log.info("successfully parse the object PatientEvent");
        } catch (Exception e) {
            log.error("error parsing object PatientE", e.getMessage());
        }
    }
}

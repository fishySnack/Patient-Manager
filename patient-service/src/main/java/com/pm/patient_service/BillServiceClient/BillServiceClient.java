package com.pm.patient_service.BillServiceClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pm.patient_service.DTO.BillDTO.BillRequest;
import com.pm.patient_service.DTO.BillDTO.BillResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BillServiceClient {
    private final int serverPort;
    private final String serverAddress;
    private final RestTemplate restTemplate;

    public BillServiceClient(@Value("${billing.service.address:localhost}") String serverAddress,
            @Value("${billing.service.port:8081}") int serverPort) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
        this.restTemplate = new RestTemplate();
        log.info("connecting to: " + getBaseUrl());

    }

    public String getBaseUrl() {
        return "http://" + serverAddress + ":" + serverPort;
    }

    public BillResponse createBillingAccount(String patientId, String name,
            String email) {
        BillRequest request = new BillRequest(patientId, name, email);

        String url = getBaseUrl() + "/billing";

        return null;// temp
    }
}

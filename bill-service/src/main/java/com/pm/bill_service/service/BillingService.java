package com.pm.bill_service.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pm.bill_service.request.BillRequest;
import com.pm.bill_service.response.BillResponse;

@Service
public class BillingService {
    private static final Logger log = LoggerFactory.getLogger(BillingService.class);

    public BillResponse createBillingAccount(BillRequest request) {
        log.info("createBillingAccount request recieved {}", request.toString());

        BillResponse response = BillResponse.builder()
                .status("PAID").accountId("123").build();

        return response;
    }
}

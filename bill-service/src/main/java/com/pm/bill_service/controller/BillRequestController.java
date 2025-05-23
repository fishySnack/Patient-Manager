package com.pm.bill_service.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pm.bill_service.request.BillRequest;
import com.pm.bill_service.response.BillResponse;

@RestController
@RequestMapping("/billing")
public class BillRequestController {

    @PostMapping("")
    public BillResponse createBillingAccount(@RequestBody BillRequest request) {

        return null;
    }
}

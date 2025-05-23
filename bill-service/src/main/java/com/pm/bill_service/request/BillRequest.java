package com.pm.bill_service.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BillRequest {
    private String accountId;
    private double amount;
}

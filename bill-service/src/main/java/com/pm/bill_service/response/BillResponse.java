package com.pm.bill_service.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class BillResponse {
    private String accountId;
    private String status;
}

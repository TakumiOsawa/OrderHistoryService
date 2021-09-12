package com.ftgo.OrderHistoryService.domain.order;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentInformation {
    private String paymentToken;
}

package com.ftgo.OrderHistoryService.domain.order;

import com.ftgo.OrderHistoryService.domain.AddressOnDB;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class DeliveryInformation {
    private LocalDateTime deliveryTime;
    private AddressOnDB deliveryAddress;
}

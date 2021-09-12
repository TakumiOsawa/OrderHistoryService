package com.ftgo.OrderHistoryService.domain.order;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
public class Order {
    private Long id;
    private OrderState state;
    private Long version;
    private Long consumerId;
    private Long restaurantId;
    private OrderLineItemsOnDB orderLineItems;
    private DeliveryInformation deliveryInformation;
    private PaymentInformation paymentInformation;
}

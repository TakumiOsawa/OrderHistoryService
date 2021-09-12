package com.ftgo.OrderHistoryService.event;

import com.ftgo.OrderHistoryService.domain.order.OrderDetails;

public class OrderCreated implements OrderDomainEvent {
    private final OrderDetails orderDetails;

    public OrderCreated(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }
}

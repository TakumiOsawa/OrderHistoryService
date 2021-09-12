package com.ftgo.OrderHistoryService.domain.order;

import com.ftgo.OrderHistoryService.domain.Money;

public class OrderDetails {
    private Long consumerId;
    private Long restaurantId;
    private OrderLineItems orderLineItems;
    private Money orderTotal;
}

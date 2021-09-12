package com.ftgo.OrderHistoryService.event;

import com.ftgo.OrderHistoryService.OrderHistoryService;
import io.eventuate.tram.events.subscriber.DomainEventEnvelope;
import io.eventuate.tram.events.subscriber.DomainEventHandlers;
import io.eventuate.tram.events.subscriber.DomainEventHandlersBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ViewEventConsumer {
    private final OrderHistoryService orderHistoryService;
    private static final Logger logger = LoggerFactory.getLogger("com.ftgo");

    public ViewEventConsumer(@Autowired OrderHistoryService orderHistoryService) {
        this.orderHistoryService = orderHistoryService;
    }

    public DomainEventHandlers orderEventHandlers() {
        logger.info("Preparing event handlers.");
        return DomainEventHandlersBuilder
                .forAggregateType("Order")
                .onEvent(OrderCreated.class, this::handleOrderCreated)
                .build();
    }

    public void handleOrderCreated(DomainEventEnvelope<OrderCreated> event) {
        logger.info("OrderCreated!!");
    }
}

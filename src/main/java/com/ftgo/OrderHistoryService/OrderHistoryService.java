package com.ftgo.OrderHistoryService;

import com.ftgo.OrderHistoryService.domain.view.entity.ViewItem;
import com.ftgo.OrderHistoryService.web.query.GetOrdersResponse;
import io.eventuate.tram.events.publisher.DomainEventPublisher;
import io.eventuate.tram.messaging.producer.MessageBuilder;
import io.eventuate.tram.messaging.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

public class OrderHistoryService {
    private final RestTemplate restTemplate;
    private final DomainEventPublisher eventPublisher;
    private final MessageProducer messageProducer;

    public OrderHistoryService(@Autowired RestTemplate restTemplate,
                               @Autowired DomainEventPublisher eventPublisher,
                               @Autowired MessageProducer messageProducer) {
        this.restTemplate = restTemplate;
        this.eventPublisher = eventPublisher;
        this.messageProducer = messageProducer;
    }

    public List<ViewItem> getViewByComposition(long consumerId) {
        /*
        Map<String, String> envProperties = System.getenv();
        String loadBalancerUrl = envProperties.get("LOAD_BALANCER_URL");
         */
        String loadBalancerUrl = "http://ma-ftgo-1872925899.ap-northeast-1.elb.amazonaws.com:8008";

        return Objects.requireNonNull(
                restTemplate.getForObject(loadBalancerUrl + "/orders/view/{consumerId}",
                        GetOrdersResponse.class, consumerId))
                .getOrders()
                .stream()
                .map(it -> new ViewItem(
                        it.getId(),
                        it.getState().name(),
                        it.getVersion(),
                        it.getRestaurantId(),
                        it.getOrderLineItems().getValue()))
                .collect(Collectors.toList());
    }

    public void testProduce() {
        messageProducer.send("Order", MessageBuilder.withPayload("Test").build());
        //eventPublisher.publish("Order", 0, );
    }
}

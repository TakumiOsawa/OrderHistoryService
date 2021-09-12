package com.ftgo.OrderHistoryService;

import com.ftgo.OrderHistoryService.domain.view.entity.ViewItem;
import com.ftgo.OrderHistoryService.web.query.GetOrdersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

public class OrderHistoryService {
    private final RestTemplate restTemplate;

    public OrderHistoryService(@Autowired RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<ViewItem> getViewByComposition(long consumerId) {
        Map<String, String> envProperties = System.getenv();
        String loadBalancerUrl = envProperties.get("LOAD_BALANCER_URL");

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
}

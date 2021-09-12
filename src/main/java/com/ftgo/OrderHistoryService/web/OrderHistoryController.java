package com.ftgo.OrderHistoryService.web;

import com.ftgo.OrderHistoryService.OrderHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderHistoryController {
    private static final Logger logger = LoggerFactory.getLogger("com.ftgo");
    private final OrderHistoryService orderHistoryService;

    public OrderHistoryController(@Autowired OrderHistoryService orderHistoryService) {
        this.orderHistoryService = orderHistoryService;
    }

    @GetMapping("/hcheck")
    @ResponseStatus(HttpStatus.OK)
    public HealthCheckResponse healthCheck() {
        return new HealthCheckResponse();
    }

    @GetMapping("/view/{consumerId}")
    public GetOrdersResponse getViewItems(@PathVariable long consumerId) {
        return new GetOrdersResponse(orderHistoryService.getViewByComposition(consumerId));
    }
}

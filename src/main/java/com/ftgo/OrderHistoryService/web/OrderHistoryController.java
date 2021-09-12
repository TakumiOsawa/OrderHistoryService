package com.ftgo.OrderHistoryService.web;

import com.ftgo.OrderHistoryService.OrderHistoryService;
import com.ftgo.OrderHistoryService.domain.view.entity.ViewItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        List<ViewItem> result = orderHistoryService.getViewByComposition(consumerId);
        logger.info("Get Information.");
        return new GetOrdersResponse(result);
    }
}

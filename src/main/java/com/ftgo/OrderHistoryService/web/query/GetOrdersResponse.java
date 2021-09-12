package com.ftgo.OrderHistoryService.web.query;

import com.ftgo.OrderHistoryService.domain.order.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOrdersResponse {
    private List<Order> orders;
}

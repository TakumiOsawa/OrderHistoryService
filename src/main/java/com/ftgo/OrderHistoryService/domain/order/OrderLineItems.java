package com.ftgo.OrderHistoryService.domain.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItems {
    private List<OrderLineItem> value;
}

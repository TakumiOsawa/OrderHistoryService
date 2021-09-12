package com.ftgo.OrderHistoryService.domain.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItems {
    private final List<OrderLineItem> value = new ArrayList<>();
}

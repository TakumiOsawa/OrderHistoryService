package com.ftgo.OrderHistoryService.domain.order;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OrderLineItemsOnDB {
    private List<OrderLineItemOnDB> value;
}

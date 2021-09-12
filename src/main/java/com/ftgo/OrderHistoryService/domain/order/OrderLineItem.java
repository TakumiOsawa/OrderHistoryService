package com.ftgo.OrderHistoryService.domain.order;

import com.ftgo.OrderHistoryService.domain.Money;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItem {
    private int quantity;
    private String menuItemId;
    private String name;
    private Money price;
}

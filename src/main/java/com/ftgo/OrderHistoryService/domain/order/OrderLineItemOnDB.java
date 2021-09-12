package com.ftgo.OrderHistoryService.domain.order;

import com.ftgo.OrderHistoryService.domain.MoneyOnDB;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItemOnDB {
    @Column(name = "quantity")
    private int quantity;

    @Column(name = "menu_item_id")
    private String menuItemId;

    @Column(name = "menu_item_name")
    private String name;

    @Embedded
    private MoneyOnDB price;
}

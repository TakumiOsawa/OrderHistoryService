package com.ftgo.OrderHistoryService.domain.view.entity;

import com.ftgo.OrderHistoryService.domain.order.OrderLineItemOnDB;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "views")
public class ViewItem {
    @Id
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "order_state")
    private String state;

    @Column(name = "order_version")
    private Long version;

    @Column(name = "restaurant_name")
    private Long restaurantName;

    @ElementCollection
    @CollectionTable(name = "order_line_items")
    private List<OrderLineItemOnDB> orderLineItems;
}

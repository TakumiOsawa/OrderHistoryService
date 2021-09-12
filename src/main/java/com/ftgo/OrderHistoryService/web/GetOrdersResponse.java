package com.ftgo.OrderHistoryService.web;

import com.ftgo.OrderHistoryService.domain.view.entity.ViewItem;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GetOrdersResponse {
    private List<ViewItem> items;
}

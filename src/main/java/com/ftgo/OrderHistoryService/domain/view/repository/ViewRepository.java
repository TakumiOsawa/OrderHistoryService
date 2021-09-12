package com.ftgo.OrderHistoryService.domain.view.repository;

import com.ftgo.OrderHistoryService.domain.view.entity.ViewItem;
import org.springframework.data.repository.CrudRepository;

public interface ViewRepository extends CrudRepository<ViewItem, Long> {
}

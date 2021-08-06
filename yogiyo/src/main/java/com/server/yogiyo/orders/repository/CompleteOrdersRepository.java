package com.server.yogiyo.orders.repository;

import com.server.yogiyo.orders.entity.CompleteOrders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompleteOrdersRepository extends JpaRepository<CompleteOrders, Long> {
}

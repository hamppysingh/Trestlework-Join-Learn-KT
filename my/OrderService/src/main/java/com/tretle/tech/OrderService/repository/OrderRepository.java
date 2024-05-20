package com.tretle.tech.OrderService.repository;

import com.tretle.tech.OrderService.pojo.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}

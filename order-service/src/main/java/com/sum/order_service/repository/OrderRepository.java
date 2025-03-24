package com.sum.order_service.repository;

import com.sum.order_service.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,String> {
    List<Order> findByOrderNumber(String orderNumber);
}

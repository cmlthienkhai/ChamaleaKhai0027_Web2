package com.khai.backend.service;

import com.khai.backend.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> getOrdersByUserId(Long userId);
    Optional<Order> getOrderById(Long orderId);
    Order saveOrder(Order order);
    Order updateOrder(Order order);
    void deleteOrder(Long orderId);
}

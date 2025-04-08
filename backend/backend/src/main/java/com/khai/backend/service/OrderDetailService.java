package com.khai.backend.service;

import com.khai.backend.entity.OrderDetail;

import java.util.List;
import java.util.Optional;

public interface OrderDetailService {
    List<OrderDetail> getOrderDetailsByOrderId(Long orderId);
    OrderDetail saveOrderDetail(OrderDetail orderDetail);
    void deleteOrderDetail(Long id);
}

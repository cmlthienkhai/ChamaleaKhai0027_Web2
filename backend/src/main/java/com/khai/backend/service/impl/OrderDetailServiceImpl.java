package com.khai.backend.service.impl;

import com.khai.backend.entity.OrderDetail;
import com.khai.backend.repository.OrderDetailRepository;
import com.khai.backend.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public List<OrderDetail> getOrderDetailsByOrderId(Long orderId) {
        return orderDetailRepository.findByOrderId(orderId);
    }

    @Override
    public OrderDetail saveOrderDetail(OrderDetail orderDetail) {
        orderDetail.setTotalPrice(orderDetail.getFinalPrice() * orderDetail.getQuantity());
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public void deleteOrderDetail(Long id) {
        orderDetailRepository.deleteById(id);
    }
}

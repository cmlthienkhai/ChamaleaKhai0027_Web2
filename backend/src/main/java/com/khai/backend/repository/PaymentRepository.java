package com.khai.backend.repository;

import com.khai.backend.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByOrderId(Long orderId); // Lấy danh sách thanh toán theo ID đơn hàng
}

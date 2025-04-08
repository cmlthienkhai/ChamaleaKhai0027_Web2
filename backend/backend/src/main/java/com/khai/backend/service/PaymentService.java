package com.khai.backend.service;

import com.khai.backend.entity.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    Payment savePayment(Payment payment); // Lưu thông tin thanh toán
    List<Payment> getPaymentsByOrderId(Long orderId); // Lấy danh sách thanh toán theo ID đơn hàng
    Optional<Payment> getPaymentById(Long id); // Lấy thông tin thanh toán theo ID
    void deletePayment(Long id); // Xóa thanh toán theo ID
}

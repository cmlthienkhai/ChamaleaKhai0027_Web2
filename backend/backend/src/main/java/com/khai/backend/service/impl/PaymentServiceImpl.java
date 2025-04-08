package com.khai.backend.service.impl;

import com.khai.backend.entity.Payment;
import com.khai.backend.repository.PaymentRepository;
import com.khai.backend.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment); // Lưu thanh toán
    }

    @Override
    public List<Payment> getPaymentsByOrderId(Long orderId) {
        return paymentRepository.findByOrderId(orderId); // Lấy thanh toán theo ID đơn hàng
    }

    @Override
    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id); // Lấy thanh toán theo ID
    }

    @Override
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id); // Xóa thanh toán theo ID
    }
}

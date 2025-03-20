package com.khai.backend.controller;

import com.khai.backend.entity.Payment;
import com.khai.backend.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // Lấy danh sách thanh toán theo ID đơn hàng
    @GetMapping("/order/{orderId}")
    public List<Payment> getPaymentsByOrderId(@PathVariable Long orderId) {
        return paymentService.getPaymentsByOrderId(orderId);
    }

    // Lấy thông tin thanh toán theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
        Optional<Payment> payment = paymentService.getPaymentById(id);
        if (payment.isPresent()) {
            return ResponseEntity.ok(payment.get()); // Trả về thông tin thanh toán
        } else {
            return ResponseEntity.notFound().build(); // Không tìm thấy thanh toán
        }
    }

    // Thêm thanh toán mới
    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentService.savePayment(payment); // Lưu thanh toán mới
    }

    // Xóa thanh toán theo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        Optional<Payment> payment = paymentService.getPaymentById(id);
        if (payment.isPresent()) {
            paymentService.deletePayment(id); // Xóa thanh toán
            return ResponseEntity.noContent().build(); // Xóa thành công
        } else {
            return ResponseEntity.notFound().build(); // Không tìm thấy thanh toán
        }
    }
}

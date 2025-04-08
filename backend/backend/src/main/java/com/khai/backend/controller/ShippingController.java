package com.khai.backend.controller;

import com.khai.backend.entity.Shipping;
import com.khai.backend.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/shippings")
public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    // Lấy tất cả thông tin giao hàng
    @GetMapping
    public List<Shipping> getAllShippings() {
        return shippingService.getAllShippings();
    }

    // Lấy thông tin giao hàng theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Shipping> getShippingById(@PathVariable Long id) {
        Optional<Shipping> shipping = shippingService.getShippingById(id);
        return shipping.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Lấy giao hàng theo trạng thái
    @GetMapping("/status/{status}")
    public List<Shipping> getShippingsByStatus(@PathVariable String status) {
        return shippingService.getShippingsByStatus(status);
    }

    // Lấy giao hàng theo số theo dõi
    @GetMapping("/tracking/{trackingNumber}")
    public ResponseEntity<Shipping> getShippingByTrackingNumber(@PathVariable String trackingNumber) {
        Optional<Shipping> shipping = shippingService.getShippingByTrackingNumber(trackingNumber);
        return shipping.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Thêm giao hàng mới
    @PostMapping
    public Shipping createShipping(@RequestBody Shipping shipping) {
        return shippingService.saveShipping(shipping);
    }

    // Xóa giao hàng theo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShipping(@PathVariable Long id) {
        Optional<Shipping> shipping = shippingService.getShippingById(id);
        if (shipping.isPresent()) {
            shippingService.deleteShipping(id);
            return ResponseEntity.noContent().build(); // Xóa thành công
        } else {
            return ResponseEntity.notFound().build(); // Không tìm thấy giao hàng
        }
    }
}

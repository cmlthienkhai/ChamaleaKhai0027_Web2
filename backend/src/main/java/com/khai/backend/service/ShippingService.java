package com.khai.backend.service;

import com.khai.backend.entity.Shipping;

import java.util.List;
import java.util.Optional;

public interface ShippingService {
    Shipping saveShipping(Shipping shipping); // Lưu thông tin giao hàng
    List<Shipping> getAllShippings(); // Lấy tất cả thông tin giao hàng
    Optional<Shipping> getShippingById(Long id); // Lấy thông tin giao hàng theo ID
    List<Shipping> getShippingsByStatus(String status); // Lấy giao hàng theo trạng thái
    Optional<Shipping> getShippingByTrackingNumber(String trackingNumber); // Lấy giao hàng theo số theo dõi
    void deleteShipping(Long id); // Xóa thông tin giao hàng
}

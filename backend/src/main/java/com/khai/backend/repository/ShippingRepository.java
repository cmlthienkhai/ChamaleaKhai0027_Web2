package com.khai.backend.repository;

import com.khai.backend.entity.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShippingRepository extends JpaRepository<Shipping, Long> {
    List<Shipping> findByStatus(String status); // Tìm các giao hàng theo trạng thái
    Optional<Shipping> findByTrackingNumber(String trackingNumber); // Tìm giao hàng theo số theo dõi
}

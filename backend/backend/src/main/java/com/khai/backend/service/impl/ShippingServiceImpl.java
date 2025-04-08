package com.khai.backend.service.impl;

import com.khai.backend.entity.Shipping;
import com.khai.backend.repository.ShippingRepository;
import com.khai.backend.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShippingServiceImpl implements ShippingService {

    @Autowired
    private ShippingRepository shippingRepository;

    @Override
    public Shipping saveShipping(Shipping shipping) {
        return shippingRepository.save(shipping); // Lưu thông tin giao hàng
    }

    @Override
    public List<Shipping> getAllShippings() {
        return shippingRepository.findAll(); // Lấy tất cả thông tin giao hàng
    }

    @Override
    public Optional<Shipping> getShippingById(Long id) {
        return shippingRepository.findById(id); // Lấy thông tin giao hàng theo ID
    }

    @Override
    public List<Shipping> getShippingsByStatus(String status) {
        return shippingRepository.findByStatus(status); // Lấy giao hàng theo trạng thái
    }

    @Override
    public Optional<Shipping> getShippingByTrackingNumber(String trackingNumber) {
        return shippingRepository.findByTrackingNumber(trackingNumber); // Lấy giao hàng theo số theo dõi
    }

    @Override
    public void deleteShipping(Long id) {
        shippingRepository.deleteById(id); // Xóa thông tin giao hàng theo ID
    }
}

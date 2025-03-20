package com.khai.backend.repository;

import com.khai.backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByProductCode(String productCode);  // Tìm sản phẩm theo mã sản phẩm
}

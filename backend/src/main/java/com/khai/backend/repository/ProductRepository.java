package com.khai.backend.repository;

import com.khai.backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByProductCode(String productCode);  // Tìm sản phẩm theo mã sản phẩm

    @Modifying
    @Transactional
    @Query("DELETE FROM Product p WHERE p.category.id = :id")
    void deleteByCategoryId(Long id);
}

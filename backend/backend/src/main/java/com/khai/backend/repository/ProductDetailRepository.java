package com.khai.backend.repository;

import com.khai.backend.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {
    // Tìm chi tiết sản phẩm theo product_id
    List<ProductDetail> findByProductId(Long productId);

    // Tìm chi tiết sản phẩm theo kích thước
    List<ProductDetail> findBySize(String size);

    // Tìm chi tiết sản phẩm theo màu sắc
    List<ProductDetail> findByColor(String color);

    // Tìm chi tiết sản phẩm theo kích thước và màu sắc
    List<ProductDetail> findBySizeAndColor(String size, String color);

}

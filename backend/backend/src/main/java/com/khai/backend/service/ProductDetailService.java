package com.khai.backend.service;

import com.khai.backend.entity.ProductDetail;

import java.util.List;
import java.util.Optional;

public interface ProductDetailService {
    List<ProductDetail> getAllProductDetails();
    Optional<ProductDetail> getProductDetailById(Long id);
    ProductDetail saveProductDetail(ProductDetail productDetail);
    ProductDetail updateProductDetail(ProductDetail productDetail);
    void deleteProductDetail(Long id);

    List<ProductDetail> getProductDetailsByProductId(Long productId);
    List<ProductDetail> getProductDetailsBySize(String size);
    List<ProductDetail> getProductDetailsByColor(String color);
    List<ProductDetail> getProductDetailsBySizeAndColor(String size, String color);
}

package com.khai.backend.service;

import com.khai.backend.entity.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);  // Lưu sản phẩm
    List<Product> getAllProducts();  // Lấy tất cả sản phẩm
    Product getProductByProductCode(String productCode);  // Lấy sản phẩm theo mã sản phẩm
    Product updateProduct(Product product);  // Cập nhật sản phẩm
    void deleteProduct(Long id);  // Xóa sản phẩm
    Product getProductById(Long id);
}

package com.khai.backend.service;

import com.khai.backend.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product saveProduct(Product product);
    List<Product> getAllProducts();
    Optional<Product> getProductById(Long id); // Sửa chỗ này trả về Optional<Product>
    Product updateProduct(Product product);
    void deleteProduct(Long id);
    Product getProductByProductCode(String productCode);
}

package com.khai.backend.service.impl;

import com.khai.backend.entity.Product;
import com.khai.backend.repository.ProductRepository;
import com.khai.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);  // Lưu sản phẩm vào cơ sở dữ liệu
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();  // Lấy tất cả sản phẩm từ cơ sở dữ liệu
    }

    @Override
    public Product getProductByProductCode(String productCode) {
        return productRepository.findByProductCode(productCode);  // Tìm sản phẩm theo mã sản phẩm
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);  // Cập nhật sản phẩm
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);  // Xóa sản phẩm theo id
    }
    @Override
    public Product getProductById(Long id) {
        // Tìm sản phẩm theo ID
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null); // Trả về sản phẩm nếu tìm thấy, ngược lại trả về null
    }
}

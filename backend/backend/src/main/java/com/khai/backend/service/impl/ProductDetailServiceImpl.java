package com.khai.backend.service.impl;

import com.khai.backend.entity.ProductDetail;
import com.khai.backend.repository.ProductDetailRepository;
import com.khai.backend.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Override
    public List<ProductDetail> getAllProductDetails() {
        return productDetailRepository.findAll();
    }

    @Override
    public Optional<ProductDetail> getProductDetailById(Long id) {
        return productDetailRepository.findById(id);
    }

    @Override
    public ProductDetail saveProductDetail(ProductDetail productDetail) {
        return productDetailRepository.save(productDetail);
    }

    @Override
    public ProductDetail updateProductDetail(ProductDetail productDetail) {
        return productDetailRepository.save(productDetail);
    }

    @Override
    public void deleteProductDetail(Long id) {
        productDetailRepository.deleteById(id);
    }

    @Override
    public List<ProductDetail> getProductDetailsByProductId(Long productId) {
        return productDetailRepository.findByProductId(productId);
    }

    @Override
    public List<ProductDetail> getProductDetailsBySize(String size) {
        return productDetailRepository.findBySize(size);
    }

    @Override
    public List<ProductDetail> getProductDetailsByColor(String color) {
        return productDetailRepository.findByColor(color);
    }

    @Override
    public List<ProductDetail> getProductDetailsBySizeAndColor(String size, String color) {
        return productDetailRepository.findBySizeAndColor(size, color);
    }
}

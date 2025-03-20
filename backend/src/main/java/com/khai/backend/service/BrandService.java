package com.khai.backend.service;

import com.khai.backend.entity.Brand;

import java.util.List;

public interface BrandService {

    List<Brand> getAllBrands();

    Brand getBrandById(Long id);

    Brand saveBrand(Brand brand);

    Brand updateBrand(Brand brand);

    void deleteBrand(Long id);

    List<Brand> searchBrandsByName(String name);
}

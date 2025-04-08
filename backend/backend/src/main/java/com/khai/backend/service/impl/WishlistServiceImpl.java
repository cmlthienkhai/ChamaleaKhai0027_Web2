package com.khai.backend.service.impl;

import com.khai.backend.entity.Wishlist;
import com.khai.backend.repository.WishlistRepository;
import com.khai.backend.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistServiceImpl implements WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    @Override
    public Wishlist saveWishlist(Wishlist wishlist) {
        return wishlistRepository.save(wishlist); // Thêm sản phẩm vào danh sách yêu thích
    }

    @Override
    public List<Wishlist> getAllWishlists() {
        return wishlistRepository.findAll(); // Lấy tất cả danh sách yêu thích
    }

    @Override
    public List<Wishlist> getWishlistsByUserId(Long userId) {
        return wishlistRepository.findByUserId(userId); // Lấy danh sách yêu thích theo người dùng
    }

    @Override
    public void deleteWishlist(Long id) {
        wishlistRepository.deleteById(id); // Xóa sản phẩm khỏi danh sách yêu thích
    }
}

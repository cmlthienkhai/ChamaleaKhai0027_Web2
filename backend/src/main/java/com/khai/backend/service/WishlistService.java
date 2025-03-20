package com.khai.backend.service;

import com.khai.backend.entity.Wishlist;

import java.util.List;

public interface WishlistService {
    Wishlist saveWishlist(Wishlist wishlist); // Thêm sản phẩm vào danh sách yêu thích
    List<Wishlist> getAllWishlists(); // Lấy tất cả danh sách yêu thích
    List<Wishlist> getWishlistsByUserId(Long userId); // Lấy danh sách yêu thích của người dùng
    void deleteWishlist(Long id); // Xóa một sản phẩm khỏi danh sách yêu thích
}

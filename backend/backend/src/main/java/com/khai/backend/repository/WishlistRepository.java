package com.khai.backend.repository;

import com.khai.backend.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
    List<Wishlist> findByUserId(Long userId); // Lấy danh sách wishlist của người dùng
    Wishlist findByUserIdAndProductId(Long userId, Long productId); // Lấy wishlist theo người dùng và sản phẩm
}

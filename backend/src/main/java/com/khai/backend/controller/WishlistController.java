package com.khai.backend.controller;

import com.khai.backend.entity.Wishlist;
import com.khai.backend.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/wishlists")
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    // Lấy tất cả danh sách yêu thích
    @GetMapping
    public List<Wishlist> getAllWishlists() {
        return wishlistService.getAllWishlists();
    }

    // Lấy danh sách yêu thích của người dùng theo userId
    @GetMapping("/user/{userId}")
    public List<Wishlist> getWishlistsByUserId(@PathVariable Long userId) {
        return wishlistService.getWishlistsByUserId(userId);
    }

    // Thêm sản phẩm vào danh sách yêu thích
    @PostMapping
    public Wishlist createWishlist(@RequestBody Wishlist wishlist) {
        return wishlistService.saveWishlist(wishlist);
    }

    // Xóa sản phẩm khỏi danh sách yêu thích
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWishlist(@PathVariable Long id) {
        Optional<Wishlist> wishlist = wishlistService.getWishlistsByUserId(id).stream().findFirst();
        if (wishlist.isPresent()) {
            wishlistService.deleteWishlist(id);
            return ResponseEntity.noContent().build(); // Xóa thành công
        } else {
            return ResponseEntity.notFound().build(); // Không tìm thấy sản phẩm trong danh sách yêu thích
        }
    }
}

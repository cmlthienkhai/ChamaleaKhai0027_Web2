package com.khai.backend.controller;

import com.khai.backend.entity.Cart;
import com.khai.backend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    // Lấy giỏ hàng của người dùng
    @GetMapping("/user/{userId}")
    public List<Cart> getCartByUserId(@PathVariable Long userId) {
        return cartService.getCartByUserId(userId);
    }

    // Lấy giỏ hàng của người dùng với sản phẩm chi tiết
    @GetMapping("/user/{userId}/product/{productDetailId}")
    public ResponseEntity<Cart> getCartByUserIdAndProductDetailId(@PathVariable Long userId, @PathVariable Long productDetailId) {
        Optional<Cart> cart = cartService.getCartByUserIdAndProductDetailId(userId, productDetailId);
        return cart.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Thêm sản phẩm vào giỏ hàng
    @PostMapping
    public Cart addToCart(@RequestBody Cart cart) {
        return cartService.addToCart(cart);
    }

    // Cập nhật giỏ hàng (thay đổi số lượng sản phẩm)
    @PutMapping("/{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable Long id, @RequestBody Cart cart) {
        Optional<Cart> existingCart = cartService.getCartByUserIdAndProductDetailId(cart.getUser().getId(), cart.getProductDetail().getId());
        if (existingCart.isPresent()) {
            cart.setId(id);
            return ResponseEntity.ok(cartService.updateCart(cart));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Xóa sản phẩm khỏi giỏ hàng
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeFromCart(@PathVariable Long id) {
        cartService.removeFromCart(id);
        return ResponseEntity.noContent().build();
    }

    // Xóa tất cả sản phẩm trong giỏ hàng của người dùng
    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Void> clearCart(@PathVariable Long userId) {
        cartService.clearCart(userId);
        return ResponseEntity.noContent().build();
    }
}

package com.khai.backend.service;

import com.khai.backend.entity.Cart;

import java.util.List;
import java.util.Optional;

public interface CartService {
    List<Cart> getCartByUserId(Long userId);
    Optional<Cart> getCartByUserIdAndProductDetailId(Long userId, Long productDetailId);
    Cart addToCart(Cart cart);
    Cart updateCart(Cart cart);
    void removeFromCart(Long id);
    void clearCart(Long userId);
}

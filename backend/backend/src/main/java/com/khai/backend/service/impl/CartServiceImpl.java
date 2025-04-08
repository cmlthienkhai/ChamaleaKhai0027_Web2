package com.khai.backend.service.impl;

import com.khai.backend.entity.Cart;
import com.khai.backend.repository.CartRepository;
import com.khai.backend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Cart> getCartByUserId(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    @Override
    public Optional<Cart> getCartByUserIdAndProductDetailId(Long userId, Long productDetailId) {
        return cartRepository.findByUserIdAndProductDetailId(userId, productDetailId);
    }

    @Override
    public Cart addToCart(Cart cart) {
        Optional<Cart> existingCart = cartRepository.findByUserIdAndProductDetailId(cart.getUser().getId(), cart.getProductDetail().getId());
        if (existingCart.isPresent()) {
            Cart updatedCart = existingCart.get();
            updatedCart.setQuantity(updatedCart.getQuantity() + cart.getQuantity());
            updatedCart.setTotalPrice(updatedCart.getFinalPrice() * updatedCart.getQuantity());
            return cartRepository.save(updatedCart);
        } else {
            cart.setTotalPrice(cart.getFinalPrice() * cart.getQuantity());
            return cartRepository.save(cart);
        }
    }

    @Override
    public Cart updateCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public void removeFromCart(Long id) {
        cartRepository.deleteById(id);
    }

    @Override
    public void clearCart(Long userId) {
        List<Cart> cartItems = cartRepository.findByUserId(userId);
        cartRepository.deleteAll(cartItems);
    }
}

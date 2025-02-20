package onmyownn.service;

import onmyownn.model.entity.CartEntity;

public interface CartService {
    CartEntity findByAccountId(Long accountId);
    CartEntity save(CartEntity cart);
    void clearCart(Long cartId);
}

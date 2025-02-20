package onmyownn.service.impl;

import onmyownn.model.entity.CartEntity;
import onmyownn.repository.CartRepository;
import onmyownn.service.CartService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public CartEntity findByAccountId(Long accountId) {
        return cartRepository.findByAccountId(accountId).orElse(null);
    }

    @Override
    public CartEntity save(CartEntity cart) {
        return cartRepository.save(cart);
    }

    @Override
    public void clearCart(Long cartId) {
        cartRepository.deleteById(cartId);
    }
}

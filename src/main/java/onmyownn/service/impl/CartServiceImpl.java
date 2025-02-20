package onmyownn.service.impl;

import onmyownn.model.entity.CartEntity;
import onmyownn.repository.CartRepository;
import onmyownn.service.CartService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public List<CartEntity> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public CartEntity save(CartEntity cart) {
        return cartRepository.save(cart);
    }

    @Override
    public void deleteById(Long id) {
        cartRepository.deleteById(id);
    }
}

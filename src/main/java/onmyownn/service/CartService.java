package onmyownn.service;

import onmyownn.model.entity.CartEntity;
import java.util.List;

public interface CartService {
    List<CartEntity> findAll();
    CartEntity save(CartEntity cart);
    void deleteById(Long id);
}

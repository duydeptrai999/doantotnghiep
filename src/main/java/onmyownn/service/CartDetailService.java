package onmyownn.service;

import onmyownn.model.entity.CartDetailEntity;
import java.util.List;

public interface CartDetailService {
    List<CartDetailEntity> findByCartId(Long cartId);
    CartDetailEntity save(CartDetailEntity cartDetail);
    void deleteById(Long id);
    void deleteByCartId(Long cartId);
}

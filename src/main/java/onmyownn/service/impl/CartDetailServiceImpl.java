package onmyownn.service.impl;

import onmyownn.model.entity.CartDetailEntity;
import onmyownn.repository.CartDetailRepository;
import onmyownn.service.CartDetailService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class CartDetailServiceImpl implements CartDetailService {
    private final CartDetailRepository cartDetailRepository;

    public CartDetailServiceImpl(CartDetailRepository cartDetailRepository) {
        this.cartDetailRepository = cartDetailRepository;
    }

    @Override
    public List<CartDetailEntity> findAll() {
        return cartDetailRepository.findAll();
    }

    @Override
    public CartDetailEntity save(CartDetailEntity cartDetail) {
        return cartDetailRepository.save(cartDetail);
    }

    @Override
    public void deleteById(Long id) {
        cartDetailRepository.deleteById(id);
    }
}

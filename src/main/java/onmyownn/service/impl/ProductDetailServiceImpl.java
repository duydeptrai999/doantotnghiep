package onmyownn.service.impl;

import onmyownn.model.entity.ProductDetailEntity;
import onmyownn.repository.ProductDetailRepository;
import onmyownn.service.ProductDetailService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductDetailServiceImpl implements ProductDetailService {
    private final ProductDetailRepository productDetailRepository;

    public ProductDetailServiceImpl(ProductDetailRepository productDetailRepository) {
        this.productDetailRepository = productDetailRepository;
    }

    @Override
    public List<ProductDetailEntity> findAll() {
        return productDetailRepository.findAll();
    }

    @Override
    public ProductDetailEntity save(ProductDetailEntity productDetail) {
        return productDetailRepository.save(productDetail);
    }

    @Override
    public void deleteById(Long id) {
        productDetailRepository.deleteById(id);
    }
}

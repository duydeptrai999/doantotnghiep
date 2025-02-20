package onmyownn.service;

import onmyownn.model.entity.ProductDetailEntity;
import java.util.List;

public interface ProductDetailService {
    List<ProductDetailEntity> findAll();
    ProductDetailEntity save(ProductDetailEntity productDetail);
    void deleteById(Long id);
}

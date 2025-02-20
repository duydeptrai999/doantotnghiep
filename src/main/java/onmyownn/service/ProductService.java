package onmyownn.service;

import onmyownn.model.entity.ProductEntity;
import java.util.List;

public interface ProductService {
    List<ProductEntity> findAll();
    ProductEntity save(ProductEntity product);
    void deleteById(Long id);
}

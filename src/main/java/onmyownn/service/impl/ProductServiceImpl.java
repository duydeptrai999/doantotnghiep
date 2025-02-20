package onmyownn.service.impl;

import onmyownn.model.entity.ProductEntity;
import onmyownn.repository.ProductRepository;
import onmyownn.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Page<ProductEntity> findAll(Pageable pageable) {
        return productRepository.findAll(pageable); // ✅ Thêm phân trang
    }

    @Override
    public List<ProductEntity> findActiveProducts() {
        return productRepository.findByStatus(1); // Lọc sản phẩm còn bán
    }

    @Override
    public Page<ProductEntity> findActiveProducts(Pageable pageable) {
        return productRepository.findByStatus(1, pageable); // ✅ Phân trang sản phẩm còn bán
    }

    @Override
    public ProductEntity findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public ProductEntity save(ProductEntity product) {
        return productRepository.save(product);
    }

    @Override
    public void changeStatus(Long id, int status) {
        ProductEntity product = productRepository.findById(id).orElse(null);
        if (product != null) {
            product.setStatus(status);
            productRepository.save(product);
        }
    }
}

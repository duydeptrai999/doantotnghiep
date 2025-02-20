package onmyownn.service.impl;

import onmyownn.model.entity.ProductDetailEntity;
import onmyownn.repository.ProductDetailRepository;
import onmyownn.service.ProductDetailService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductDetailServiceImpl implements ProductDetailService {

    private final ProductDetailRepository productDetailRepository;

    public ProductDetailServiceImpl(ProductDetailRepository productDetailRepository) {
        this.productDetailRepository = productDetailRepository;
    }

    // ✅ Lấy tất cả sản phẩm chi tiết (không phân trang)
    @Override
    public List<ProductDetailEntity> findAll() {
        return productDetailRepository.findAll();
    }

    // ✅ Lấy danh sách sản phẩm chi tiết theo trạng thái (không phân trang)
    @Override
    public List<ProductDetailEntity> findByStatus(int status) {
        return productDetailRepository.findByStatus(status);
    }

    // ✅ Lấy danh sách sản phẩm chi tiết (có phân trang)
    @Override
    public Page<ProductDetailEntity> findAll(Pageable pageable) {
        return productDetailRepository.findAll(pageable);
    }

    // ✅ Lấy danh sách sản phẩm chi tiết theo trạng thái (có phân trang)
    @Override
    public Page<ProductDetailEntity> findByStatus(int status, Pageable pageable) {
        return productDetailRepository.findByStatus(status, pageable);
    }

    // ✅ Tìm sản phẩm chi tiết theo ID
    @Override
    public ProductDetailEntity findById(Long id) {
        return productDetailRepository.findById(id).orElse(null);
    }

    // ✅ Cập nhật sản phẩm chi tiết (không thêm mới)
    @Override
    public ProductDetailEntity update(ProductDetailEntity productDetail) {
        Optional<ProductDetailEntity> existingDetail = productDetailRepository.findById(productDetail.getId());
        if (existingDetail.isPresent()) {
            return productDetailRepository.save(productDetail);
        }
        return null; // Không cập nhật nếu không tồn tại
    }

    // ✅ Xóa mềm sản phẩm chi tiết (đổi status)
    @Override
    public void changeStatus(Long id, int status) {
        Optional<ProductDetailEntity> productDetail = productDetailRepository.findById(id);
        productDetail.ifPresent(detail -> {
            detail.setStatus(status);
            productDetailRepository.save(detail);
        });
    }
}

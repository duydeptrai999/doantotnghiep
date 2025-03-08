package onmyownn.service;

import onmyownn.model.entity.ProductDetailEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductDetailService {

    // ✅ Lấy tất cả sản phẩm chi tiết (không phân trang)
    List<ProductDetailEntity> findAll();

    // ✅ Lấy tất cả sản phẩm chi tiết theo trạng thái (không phân trang)
    List<ProductDetailEntity> findByStatus(int status);

    // ✅ Lấy tất cả sản phẩm chi tiết (có phân trang)
    Page<ProductDetailEntity> findAll(Pageable pageable);

    // ✅ Lấy tất cả sản phẩm chi tiết theo trạng thái (có phân trang)
    Page<ProductDetailEntity> findByStatus(int status, Pageable pageable);

    // ✅ Tìm sản phẩm chi tiết theo ID
    ProductDetailEntity findById(Long id);

    // ✅ Cập nhật sản phẩm chi tiết (không thêm mới)
    ProductDetailEntity update(ProductDetailEntity productDetail);

    // ✅ Xóa mềm sản phẩm chi tiết (đổi status)
    void changeStatus(Long id, int status);

    // ✅ Tìm sản phẩm chi tiết theo sản phẩm, màu sắc và kích thước
    Optional<ProductDetailEntity> findByProductAndColorAndSize(Long productId, Long colorId, Long sizeId);

    List<ProductDetailEntity> findByProductId(Long productId);
}

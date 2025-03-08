package onmyownn.repository;

import onmyownn.model.entity.ProductDetailEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetailEntity, Long> {

    // ✅ Lấy danh sách sản phẩm chi tiết theo trạng thái (không phân trang)
    List<ProductDetailEntity> findByStatus(int status);

    // ✅ Lấy danh sách sản phẩm chi tiết theo trạng thái (có phân trang)
    Page<ProductDetailEntity> findByStatus(int status, Pageable pageable);

    // ✅ Tìm sản phẩm chi tiết theo sản phẩm, màu sắc và kích thước
    Optional<ProductDetailEntity> findByProductIdAndColorIdAndSizeId(Long productId, Long colorId, Long sizeId);

    List<ProductDetailEntity> findByProductId(Long productId);
}

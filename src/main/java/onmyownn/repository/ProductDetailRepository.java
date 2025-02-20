package onmyownn.repository;

import onmyownn.model.entity.ProductDetailEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDetailRepository extends JpaRepository<ProductDetailEntity, Long> {

    // ✅ Lấy danh sách sản phẩm chi tiết theo trạng thái (không phân trang)
    List<ProductDetailEntity> findByStatus(int status);

    // ✅ Lấy danh sách sản phẩm chi tiết theo trạng thái (có phân trang)
    Page<ProductDetailEntity> findByStatus(int status, Pageable pageable);
}

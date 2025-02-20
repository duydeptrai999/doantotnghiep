package onmyownn.repository;

import onmyownn.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    // Lấy danh sách sản phẩm theo status
    List<ProductEntity> findByStatus(int status);

    // Lấy danh sách sản phẩm theo status + phân trang
    Page<ProductEntity> findByStatus(int status, Pageable pageable);
}

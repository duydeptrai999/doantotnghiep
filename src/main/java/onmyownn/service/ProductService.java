package onmyownn.service;

import onmyownn.model.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ProductService {

    // Lấy toàn bộ danh sách sản phẩm (không phân trang)
    List<ProductEntity> findAll();

    // Lấy danh sách sản phẩm có phân trang
    Page<ProductEntity> findAll(Pageable pageable);

    // Lấy danh sách sản phẩm còn bán (không phân trang)
    List<ProductEntity> findActiveProducts();

    // Lấy danh sách sản phẩm còn bán (có phân trang)
    Page<ProductEntity> findActiveProducts(Pageable pageable);

    // Tìm sản phẩm theo ID
    ProductEntity findById(Long id);

    // Thêm hoặc cập nhật sản phẩm
    ProductEntity save(ProductEntity product);

    // Thay đổi trạng thái của sản phẩm (VD: Xóa mềm bằng cách đổi status)
    void changeStatus(Long id, int status);

    // Xóa sản phẩm theo ID
    void deleteById(Long id);
}

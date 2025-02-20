package onmyownn.service;

import onmyownn.model.entity.BrandEntity;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BrandService {
    List<BrandEntity> findAll();
    Page<BrandEntity> findAll(Pageable pageable);
    BrandEntity save(BrandEntity brand);
    void deleteById(Long id);
    BrandEntity findById(Long id);
    List<BrandEntity> findAllActive();

}

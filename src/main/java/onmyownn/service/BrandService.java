package onmyownn.service;

import onmyownn.model.entity.BrandEntity;
import java.util.List;

public interface BrandService {
    List<BrandEntity> findAll();
    BrandEntity save(BrandEntity brand);
    void deleteById(Long id);
}

package onmyownn.service;

import onmyownn.model.entity.MaterialEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MaterialService {
    List<MaterialEntity> findAll();
    Page<MaterialEntity> findAll(Pageable pageable);
    MaterialEntity save(MaterialEntity material);
    void deleteById(Long id);
    MaterialEntity findById(Long id);
    List<MaterialEntity> findAllActive();
}

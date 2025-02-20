package onmyownn.service;

import onmyownn.model.entity.MaterialEntity;
import java.util.List;

public interface MaterialService {
    List<MaterialEntity> findAll();
    MaterialEntity save(MaterialEntity material);
    void deleteById(Long id);
}

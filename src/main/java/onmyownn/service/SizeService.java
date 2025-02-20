package onmyownn.service;

import onmyownn.model.entity.SizeEntity;
import java.util.List;

public interface SizeService {
    List<SizeEntity> findAll();
    SizeEntity save(SizeEntity size);
    void deleteById(Long id);
}

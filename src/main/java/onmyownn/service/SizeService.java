package onmyownn.service;

import onmyownn.model.entity.SizeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SizeService {
    List<SizeEntity> findAll();
    Page<SizeEntity> findAll(Pageable pageable);
    SizeEntity save(SizeEntity size);
    void deleteById(Long id);
    SizeEntity findById(Long id);
}

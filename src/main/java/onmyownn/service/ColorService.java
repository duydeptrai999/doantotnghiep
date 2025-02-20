package onmyownn.service;

import onmyownn.model.entity.ColorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ColorService {
    List<ColorEntity> findAll();
    Page<ColorEntity> findAll(Pageable pageable);
    ColorEntity save(ColorEntity color);
    void deleteById(Long id);
    ColorEntity findById(Long id);
}

package onmyownn.service;

import onmyownn.model.entity.ColorEntity;
import java.util.List;

public interface ColorService {
    List<ColorEntity> findAll();
    ColorEntity save(ColorEntity color);
    void deleteById(Long id);
}

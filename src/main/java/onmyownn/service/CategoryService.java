package onmyownn.service;

import onmyownn.model.entity.CategoryEntity;
import java.util.List;

public interface CategoryService {
    List<CategoryEntity> findAll();
    CategoryEntity save(CategoryEntity category);
    void deleteById(Long id);
}

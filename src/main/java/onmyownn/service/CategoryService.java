package onmyownn.service;

import onmyownn.model.entity.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    List<CategoryEntity> findAll();
    Page<CategoryEntity> findAll(Pageable pageable);
    CategoryEntity save(CategoryEntity category);
    void deleteById(Long id);
    CategoryEntity findById(Long id);
    List<CategoryEntity> findAllActive();

}

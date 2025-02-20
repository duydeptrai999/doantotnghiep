package onmyownn.service;

import onmyownn.model.entity.ImageEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ImageService {
    List<ImageEntity> findAll();
    Page<ImageEntity> findAll(Pageable pageable);
    ImageEntity save(ImageEntity image);
    void deleteById(Long id);
    ImageEntity findById(Long id);
}

package onmyownn.service;

import onmyownn.model.entity.ImageEntity;
import java.util.List;

public interface ImageService {
    List<ImageEntity> findAll();
    ImageEntity save(ImageEntity image);
    void deleteById(Long id);
}

package onmyownn.service.impl;

import onmyownn.model.entity.ImageEntity;
import onmyownn.repository.ImageRepository;
import onmyownn.service.ImageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public List<ImageEntity> findAll() {
        return imageRepository.findAll();
    }

    @Override
    public Page<ImageEntity> findAll(Pageable pageable) {
        return imageRepository.findAll(pageable);
    }

    @Override
    public ImageEntity save(ImageEntity image) {
        return imageRepository.save(image);
    }

    @Override
    public void deleteById(Long id) {
        imageRepository.deleteById(id);
    }

    @Override
    public ImageEntity findById(Long id) {
        return imageRepository.findById(id).orElse(null);
    }
}

package onmyownn.service.impl;

import onmyownn.model.entity.MaterialEntity;
import onmyownn.repository.MaterialRepository;
import onmyownn.service.MaterialService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository materialRepository;

    public MaterialServiceImpl(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @Override
    public List<MaterialEntity> findAll() {
        return materialRepository.findAll();
    }

    @Override
    public Page<MaterialEntity> findAll(Pageable pageable) {
        return materialRepository.findAll(pageable);
    }

    @Override
    public MaterialEntity save(MaterialEntity material) {
        return materialRepository.save(material);
    }

    @Override
    public void deleteById(Long id) {
        materialRepository.deleteById(id);
    }

    @Override
    public MaterialEntity findById(Long id) {
        return materialRepository.findById(id).orElse(null);
    }

    @Override
    public List<MaterialEntity> findAllActive() {
        return materialRepository.findByStatus(1);
    }
}

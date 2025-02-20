package onmyownn.service.impl;

import onmyownn.model.entity.BrandEntity;
import onmyownn.repository.BrandRepository;
import onmyownn.service.BrandService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
@Transactional
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<BrandEntity> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public Page<BrandEntity> findAll(Pageable pageable) {
        return brandRepository.findAll(pageable); // Thêm dòng này
    }

    @Override
    public BrandEntity save(BrandEntity brand) {
        return brandRepository.save(brand);
    }

    @Override
    public void deleteById(Long id) {
        brandRepository.deleteById(id);
    }

    @Override
    public BrandEntity findById(Long id) {
        return brandRepository.findById(id).orElse(null);
    }

    @Override
    public List<BrandEntity> findAllActive() {
        return brandRepository.findByStatus(1);
    }
}

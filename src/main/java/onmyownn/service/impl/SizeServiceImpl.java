package onmyownn.service.impl;

import onmyownn.model.entity.SizeEntity;
import onmyownn.repository.SizeRepository;
import onmyownn.service.SizeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SizeServiceImpl implements SizeService {

    private final SizeRepository sizeRepository;

    public SizeServiceImpl(SizeRepository sizeRepository) {
        this.sizeRepository = sizeRepository;
    }

    @Override
    public List<SizeEntity> findAll() {
        return sizeRepository.findAll();
    }

    @Override
    public Page<SizeEntity> findAll(Pageable pageable) {
        return sizeRepository.findAll(pageable);
    }

    @Override
    public SizeEntity save(SizeEntity size) {
        return sizeRepository.save(size);
    }

    @Override
    public void deleteById(Long id) {
        sizeRepository.deleteById(id);
    }

    @Override
    public SizeEntity findById(Long id) {
        return sizeRepository.findById(id).orElse(null);
    }
}

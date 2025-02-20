package onmyownn.service.impl;

import onmyownn.model.entity.ColorEntity;
import onmyownn.repository.ColorRepository;
import onmyownn.service.ColorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ColorServiceImpl implements ColorService {

    private final ColorRepository colorRepository;

    public ColorServiceImpl(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    @Override
    public List<ColorEntity> findAll() {
        return colorRepository.findAll();
    }

    @Override
    public Page<ColorEntity> findAll(Pageable pageable) {
        return colorRepository.findAll(pageable);
    }

    @Override
    public ColorEntity save(ColorEntity color) {
        return colorRepository.save(color);
    }

    @Override
    public void deleteById(Long id) {
        colorRepository.deleteById(id);
    }

    @Override
    public ColorEntity findById(Long id) {
        return colorRepository.findById(id).orElse(null);
    }
}

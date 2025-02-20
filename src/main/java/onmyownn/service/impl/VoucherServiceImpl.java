package onmyownn.service.impl;

import onmyownn.model.entity.VoucherEntity;
import onmyownn.repository.VoucherRepository;
import onmyownn.service.VoucherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class VoucherServiceImpl implements VoucherService {
    private final VoucherRepository voucherRepository;

    public VoucherServiceImpl(VoucherRepository voucherRepository) {
        this.voucherRepository = voucherRepository;
    }

    @Override
    public List<VoucherEntity> findAll() {
        return voucherRepository.findAll();
    }

    @Override
    public VoucherEntity save(VoucherEntity voucher) {
        return voucherRepository.save(voucher);
    }

    @Override
    public void deleteById(Long id) {
        voucherRepository.deleteById(id);
    }
}

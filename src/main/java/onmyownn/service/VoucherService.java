package onmyownn.service;

import onmyownn.model.entity.VoucherEntity;
import java.util.List;

public interface VoucherService {
    List<VoucherEntity> findAll();
    VoucherEntity save(VoucherEntity voucher);
    void deleteById(Long id);
}

package onmyownn.service;

import onmyownn.model.entity.VoucherEntity;
import java.util.List;

public interface VoucherService {
    List<VoucherEntity> findAll();
    
    VoucherEntity findByCode(String code);
    
    VoucherEntity save(VoucherEntity voucher);
    
    void deleteById(Long id);
    
    void updateVoucherQuantity(VoucherEntity voucher);
}

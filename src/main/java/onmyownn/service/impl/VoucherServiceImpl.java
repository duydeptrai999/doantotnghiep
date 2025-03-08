package onmyownn.service.impl;

import lombok.RequiredArgsConstructor;
import onmyownn.model.entity.VoucherEntity;
import onmyownn.repository.VoucherRepository;
import onmyownn.service.VoucherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class VoucherServiceImpl implements VoucherService {
    private final VoucherRepository voucherRepository;

    @Override
    public List<VoucherEntity> findAll() {
        return voucherRepository.findAll();
    }

    @Override
    public VoucherEntity findByCode(String code) {
        VoucherEntity voucher = voucherRepository.findByCode(code)
                .orElseThrow(() -> new RuntimeException("Mã giảm giá không tồn tại"));

        LocalDateTime now = LocalDateTime.now();
        
        // Kiểm tra thời gian hiệu lực
        if (now.isBefore(voucher.getStartAt()) || now.isAfter(voucher.getEndAt())) {
            throw new RuntimeException("Mã giảm giá đã hết hạn hoặc chưa đến thời gian sử dụng");
        }

        // Kiểm tra số lượng còn lại
        if (voucher.getQuantity() <= 0) {
            throw new RuntimeException("Mã giảm giá đã hết lượt sử dụng");
        }

        return voucher;
    }

    @Override
    public VoucherEntity save(VoucherEntity voucher) {
        return voucherRepository.save(voucher);
    }

    @Override
    public void deleteById(Long id) {
        voucherRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateVoucherQuantity(VoucherEntity voucher) {
        voucher.setQuantity(voucher.getQuantity() - 1);
        voucherRepository.save(voucher);
    }
}

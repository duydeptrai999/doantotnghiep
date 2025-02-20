package onmyownn.service;

import onmyownn.model.entity.OrderDetailEntity;
import java.util.List;

public interface OrderDetailService {
    List<OrderDetailEntity> findAll();
    OrderDetailEntity save(OrderDetailEntity orderDetail);
    void deleteById(Long id);
}

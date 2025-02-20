package onmyownn.service;

import onmyownn.model.entity.OrderEntity;
import java.util.List;

public interface OrderService {
    List<OrderEntity> findAll();
    OrderEntity save(OrderEntity order);
    void deleteById(Long id);
}

package onmyownn.repository;

import onmyownn.model.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    List<OrderEntity> findByCustomerIdOrderByIdDesc(Long customerId);
    Optional<OrderEntity> findByCode(String code);
    Optional<OrderEntity> findByPaymentTransactionNo(String transactionNo);
}

package onmyownn.repository;

import onmyownn.model.entity.CartDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetailEntity, Long> {
    List<CartDetailEntity> findByCartId(Long cartId);
    void deleteByCartId(Long cartId);
}

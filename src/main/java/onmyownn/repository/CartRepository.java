package onmyownn.repository;

import onmyownn.model.entity.CartEntity;
import onmyownn.model.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long> {
    Optional<CartEntity> findByAccountId(Long accountId);
    Optional<CartEntity> findByAccount(AccountEntity account);
}

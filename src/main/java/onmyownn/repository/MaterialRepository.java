package onmyownn.repository;

import onmyownn.model.entity.BrandEntity;
import onmyownn.model.entity.MaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialRepository extends JpaRepository<MaterialEntity, Long> {
    List<MaterialEntity> findByStatus(int status);
}

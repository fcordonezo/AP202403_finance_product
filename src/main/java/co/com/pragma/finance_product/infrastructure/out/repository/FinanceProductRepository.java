package co.com.pragma.finance_product.infrastructure.out.repository;

import co.com.pragma.finance_product.infrastructure.out.entity.FinanceProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinanceProductRepository extends JpaRepository<FinanceProductEntity, Long> {
}

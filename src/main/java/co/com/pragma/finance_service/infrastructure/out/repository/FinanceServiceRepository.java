package co.com.pragma.finance_service.infrastructure.out.repository;

import co.com.pragma.finance_service.infrastructure.out.entity.FinanceServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinanceServiceRepository extends JpaRepository<FinanceServiceEntity, Long> {
}

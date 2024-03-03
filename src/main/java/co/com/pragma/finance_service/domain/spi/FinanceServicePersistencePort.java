package co.com.pragma.finance_service.domain.spi;

import co.com.pragma.finance_service.domain.model.FinanceService;

import java.util.List;

public interface FinanceServicePersistencePort {
  List<FinanceService> findAll();
  FinanceService findById(Long idCustomer);
  FinanceService save(FinanceService financeService);
  void delete(FinanceService financeService);
}

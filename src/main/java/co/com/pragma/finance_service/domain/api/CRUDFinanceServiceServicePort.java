package co.com.pragma.finance_service.domain.api;

import co.com.pragma.finance_service.domain.model.FinanceService;

import java.util.List;

public interface CRUDFinanceServiceServicePort {
  List<FinanceService> readAll();
  FinanceService readById(Long financeServiceId);
  FinanceService create(FinanceService financeService);
  FinanceService update(FinanceService financeService, Long financeServiceId);
  void delete(Long financeServiceId);
}

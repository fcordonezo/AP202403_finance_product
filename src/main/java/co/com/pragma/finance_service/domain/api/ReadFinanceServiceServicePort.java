package co.com.pragma.finance_service.domain.api;

import co.com.pragma.finance_service.domain.model.FinanceService;

import java.util.List;

public interface ReadFinanceServiceServicePort {
  List<FinanceService> readAll();
  FinanceService readById(Long financeServiceId);
}

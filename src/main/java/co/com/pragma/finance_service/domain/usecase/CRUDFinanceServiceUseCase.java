package co.com.pragma.finance_service.domain.usecase;

import co.com.pragma.finance_service.domain.api.CRUDFinanceServiceServicePort;
import co.com.pragma.finance_service.domain.model.FinanceService;
import co.com.pragma.finance_service.domain.spi.FinanceServicePersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CRUDFinanceServiceUseCase implements CRUDFinanceServiceServicePort {

  private final FinanceServicePersistencePort financeServicePersistencePort;

  @Autowired
  public CRUDFinanceServiceUseCase(FinanceServicePersistencePort financeServicePersistencePort) {
    this.financeServicePersistencePort = financeServicePersistencePort;
  }

  @Override
  public List<FinanceService> readAll() {
    return financeServicePersistencePort.findAll();
  }

  @Override
  public FinanceService readById(Long financeServiceId) {
    return financeServicePersistencePort.findById(financeServiceId);
  }

  @Override
  public FinanceService create(FinanceService financeService) {
    return financeServicePersistencePort.create(financeService);
  }

  @Override
  public FinanceService update(FinanceService financeService, Long financeServiceId) {
    return financeServicePersistencePort.update(financeService, financeServiceId);
  }

  @Override
  public void delete(Long financeServiceId) {
    financeServicePersistencePort.delete(financeServiceId);
  }
}

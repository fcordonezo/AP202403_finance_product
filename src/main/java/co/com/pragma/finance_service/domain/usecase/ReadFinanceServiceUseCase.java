package co.com.pragma.finance_service.domain.usecase;

import co.com.pragma.finance_service.domain.api.ReadFinanceServiceServicePort;
import co.com.pragma.finance_service.domain.model.FinanceService;
import co.com.pragma.finance_service.domain.spi.FinanceServicePersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadFinanceServiceUseCase implements ReadFinanceServiceServicePort {

  private final FinanceServicePersistencePort financeServicePersistencePort;

  @Autowired
  public ReadFinanceServiceUseCase(FinanceServicePersistencePort financeServicePersistencePort) {
    this.financeServicePersistencePort = financeServicePersistencePort;
  }

  @Override
  public List<FinanceService> readAll() {
    return financeServicePersistencePort.findAll();
  }

  @Override
  public FinanceService readById(Long customerId) {
    return financeServicePersistencePort.findById(customerId);
  }
}

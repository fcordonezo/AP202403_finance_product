package co.com.pragma.finance_product.domain.usecase;

import co.com.pragma.finance_product.domain.api.CRUDFinanceProductServicePort;
import co.com.pragma.finance_product.domain.model.FinanceProduct;
import co.com.pragma.finance_product.domain.spi.FinanceProductPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CRUDFinanceProductUseCase implements CRUDFinanceProductServicePort {

  private final FinanceProductPersistencePort financeProductPersistencePort;

  @Autowired
  public CRUDFinanceProductUseCase(FinanceProductPersistencePort financeProductPersistencePort) {
    this.financeProductPersistencePort = financeProductPersistencePort;
  }

  @Override
  public List<FinanceProduct> readAll() {
    return financeProductPersistencePort.findAll();
  }

  @Override
  public FinanceProduct readById(Long financeProductId) {
    return financeProductPersistencePort.findById(financeProductId);
  }

  @Override
  public FinanceProduct create(FinanceProduct financeProduct) {
    return financeProductPersistencePort.create(financeProduct);
  }

  @Override
  public FinanceProduct update(FinanceProduct financeProduct, Long financeProductId) {
    return financeProductPersistencePort.update(financeProduct, financeProductId);
  }

  @Override
  public void delete(Long financeProductId) {
    financeProductPersistencePort.delete(financeProductId);
  }
}

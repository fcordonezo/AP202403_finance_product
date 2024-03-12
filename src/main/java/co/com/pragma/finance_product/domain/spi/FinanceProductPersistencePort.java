package co.com.pragma.finance_product.domain.spi;

import co.com.pragma.finance_product.domain.model.FinanceProduct;

import java.util.List;

public interface FinanceProductPersistencePort {
  List<FinanceProduct> findAll();
  FinanceProduct findById(Long idCustomer);
  FinanceProduct create(FinanceProduct financeProduct);
  FinanceProduct update(FinanceProduct financeProduct, Long financeProductId);
  void delete(Long financeProductId);
}

package co.com.pragma.finance_product.domain.api;

import co.com.pragma.finance_product.domain.model.FinanceProduct;

import java.util.List;

public interface CRUDFinanceProductServicePort {
  List<FinanceProduct> readAll();
  FinanceProduct readById(Long financeProductId);
  FinanceProduct create(FinanceProduct financeProduct);
  FinanceProduct update(FinanceProduct financeProduct, Long financeProductId);
  void delete(Long financeProductId);
}

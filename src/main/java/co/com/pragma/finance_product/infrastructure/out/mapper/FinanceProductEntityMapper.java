package co.com.pragma.finance_product.infrastructure.out.mapper;

import co.com.pragma.finance_product.domain.model.FinanceProduct;
import co.com.pragma.finance_product.infrastructure.out.entity.FinanceProductEntity;
import org.springframework.stereotype.Component;

@Component
public class FinanceProductEntityMapper {

  public FinanceProduct toFinanceProduct(FinanceProductEntity entity) {
    return FinanceProduct.builder()
      .financeProductId(entity.getFinanceProductId())
      .code(entity.getCode())
      .description(entity.getDescription())
      .ruleSet(entity.getRuleSet())
      .build();
  }
  public FinanceProductEntity toFinanceProductEntity(FinanceProduct financeProduct) {
    return FinanceProductEntity.builder()
      .financeProductId(financeProduct.financeProductId())
      .code(financeProduct.code())
      .description(financeProduct.description())
      .ruleSet(financeProduct.ruleSet())
      .build();
  }

  public FinanceProduct addFinanceProductId(FinanceProduct financeProduct, Long FinanceProductId) {
    return FinanceProduct.builder()
      .financeProductId(FinanceProductId)
      .code(financeProduct.code())
      .description(financeProduct.description())
      .ruleSet(financeProduct.ruleSet())
      .build();
  }
}

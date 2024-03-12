package co.com.pragma.finance_product.domain.model;

import lombok.Builder;

@Builder
public record FinanceProduct(
  Long financeProductId,
  String code,
  String description,
  String ruleSet
) {
}

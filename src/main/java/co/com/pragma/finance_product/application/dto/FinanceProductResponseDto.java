package co.com.pragma.finance_product.application.dto;

import lombok.Builder;

@Builder
public record FinanceProductResponseDto(
  Long financeProductId,
  String code,
  String description,
  String ruleSet
) {
}

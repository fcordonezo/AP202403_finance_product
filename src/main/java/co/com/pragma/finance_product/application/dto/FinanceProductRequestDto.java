package co.com.pragma.finance_product.application.dto;

import lombok.Builder;

@Builder
public record FinanceProductRequestDto(
  String code,
  String description,
  String ruleSet
) {
}

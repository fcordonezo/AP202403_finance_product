package co.com.pragma.finance_service.application.dto;

import lombok.Builder;

@Builder
public record FinanceServiceRequestDto(
  String code,
  String description,
  String ruleSet
) {
}

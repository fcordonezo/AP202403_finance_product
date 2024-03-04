package co.com.pragma.finance_service.domain.model;

import lombok.Builder;

@Builder
public record FinanceService(
  Long financeServiceId,
  String code,
  String description,
  String ruleSet
) {
}

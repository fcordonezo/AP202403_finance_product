package co.com.pragma.finance_service.infrastructure.out.mapper;

import co.com.pragma.finance_service.domain.model.FinanceService;
import co.com.pragma.finance_service.infrastructure.out.entity.FinanceServiceEntity;
import org.springframework.stereotype.Component;

@Component
public class FinanceServiceEntityMapper {

  public FinanceService toFinanceService(FinanceServiceEntity entity) {
    return FinanceService.builder()
      .financeServiceId(entity.getFinanceServiceId())
      .code(entity.getCode())
      .description(entity.getDescription())
      .ruleSet(entity.getRuleSet())
      .build();
  }
  public FinanceServiceEntity toFinanceServiceEntity(FinanceService financeService) {
    return FinanceServiceEntity.builder()
      .financeServiceId(financeService.financeServiceId())
      .code(financeService.code())
      .description(financeService.description())
      .ruleSet(financeService.ruleSet())
      .build();
  }
}

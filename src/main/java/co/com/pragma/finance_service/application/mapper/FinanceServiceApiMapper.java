package co.com.pragma.finance_service.application.mapper;

import co.com.pragma.finance_service.application.dto.FinanceServiceRequestDto;
import co.com.pragma.finance_service.application.dto.FinanceServiceResponseDto;
import co.com.pragma.finance_service.domain.model.FinanceService;
import org.mapstruct.Mapper;

@Mapper
public interface FinanceServiceApiMapper {

  FinanceService toFinanceService(FinanceServiceRequestDto dto);
  FinanceServiceResponseDto toFinanceServiceResponseDto(FinanceService financeService);
}

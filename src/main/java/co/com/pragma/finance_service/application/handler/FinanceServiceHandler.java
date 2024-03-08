package co.com.pragma.finance_service.application.handler;

import co.com.pragma.finance_service.application.dto.FinanceServiceRequestDto;
import co.com.pragma.finance_service.application.dto.FinanceServiceResponseDto;

import java.util.List;

public interface FinanceServiceHandler {
  FinanceServiceResponseDto getById(Long id);
  List<FinanceServiceResponseDto> getAll();
  FinanceServiceResponseDto post(FinanceServiceRequestDto dto);
  FinanceServiceResponseDto put(FinanceServiceRequestDto dto, Long financeServiceId);
  void delete(Long id);
}

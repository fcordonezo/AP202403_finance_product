package co.com.pragma.finance_product.application.handler;

import co.com.pragma.finance_product.application.dto.FinanceProductRequestDto;
import co.com.pragma.finance_product.application.dto.FinanceProductResponseDto;

import java.util.List;

public interface FinanceProductHandler {
  FinanceProductResponseDto getById(Long id);
  List<FinanceProductResponseDto> getAll();
  FinanceProductResponseDto post(FinanceProductRequestDto dto);
  FinanceProductResponseDto put(FinanceProductRequestDto dto, Long financeProductId);
  void delete(Long id);
}

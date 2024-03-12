package co.com.pragma.finance_product.application.mapper;

import co.com.pragma.finance_product.domain.model.FinanceProduct;
import co.com.pragma.finance_product.application.dto.FinanceProductRequestDto;
import co.com.pragma.finance_product.application.dto.FinanceProductResponseDto;
import org.mapstruct.Mapper;

@Mapper
public interface FinanceProductApiMapper {

  FinanceProduct toFinanceProduct(FinanceProductRequestDto dto);
  FinanceProductResponseDto toFinanceProductResponseDto(FinanceProduct financeProduct);
}

package co.com.pragma.finance_product.application.handler;

import co.com.pragma.finance_product.application.dto.FinanceProductRequestDto;
import co.com.pragma.finance_product.application.dto.FinanceProductResponseDto;
import co.com.pragma.finance_product.application.mapper.FinanceProductApiMapper;
import co.com.pragma.finance_product.domain.api.CRUDFinanceProductServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FinanceProductHandlerImpl implements FinanceProductHandler{

  private final CRUDFinanceProductServicePort crudFinanceProductServicePort;
  private final FinanceProductApiMapper financeProductApiMapper;

  @Autowired
  public FinanceProductHandlerImpl(
    CRUDFinanceProductServicePort crudFinanceProductServicePort,
    FinanceProductApiMapper financeProductApiMapper
  ) {
    this.crudFinanceProductServicePort = crudFinanceProductServicePort;
    this.financeProductApiMapper = financeProductApiMapper;
  }

  @Override
  public FinanceProductResponseDto getById(Long financeProductId) {
    return financeProductApiMapper.toFinanceProductResponseDto(crudFinanceProductServicePort.readById(financeProductId));
  }

  @Override
  public List<FinanceProductResponseDto> getAll() {
    return crudFinanceProductServicePort.readAll().stream()
      .map(financeProductApiMapper::toFinanceProductResponseDto)
      .collect(Collectors.toList());
  }

  @Override
  public FinanceProductResponseDto post(FinanceProductRequestDto dto) {
    return financeProductApiMapper.toFinanceProductResponseDto(crudFinanceProductServicePort.create(financeProductApiMapper.toFinanceProduct(dto)));
  }

  @Override
  public FinanceProductResponseDto put(FinanceProductRequestDto dto, Long financeProductId) {
    return financeProductApiMapper.toFinanceProductResponseDto(crudFinanceProductServicePort.update(financeProductApiMapper.toFinanceProduct(dto), financeProductId));
  }

  @Override
  public void delete(Long id) {
    crudFinanceProductServicePort.delete(id);
  }
}

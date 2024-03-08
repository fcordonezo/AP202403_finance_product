package co.com.pragma.finance_service.application.handler;

import co.com.pragma.finance_service.application.dto.FinanceServiceRequestDto;
import co.com.pragma.finance_service.application.dto.FinanceServiceResponseDto;
import co.com.pragma.finance_service.application.mapper.FinanceServiceApiMapper;
import co.com.pragma.finance_service.domain.api.CRUDFinanceServiceServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FinanceServiceHandlerImpl implements FinanceServiceHandler{

  private final CRUDFinanceServiceServicePort crudFinanceServiceServicePort;
  private final FinanceServiceApiMapper financeServiceApiMapper;

  @Autowired
  public FinanceServiceHandlerImpl(
    CRUDFinanceServiceServicePort crudFinanceServiceServicePort,
    FinanceServiceApiMapper financeServiceApiMapper
  ) {
    this.crudFinanceServiceServicePort = crudFinanceServiceServicePort;
    this.financeServiceApiMapper = financeServiceApiMapper;
  }

  @Override
  public FinanceServiceResponseDto getById(Long financeServiceId) {
    return financeServiceApiMapper.toFinanceServiceResponseDto(crudFinanceServiceServicePort.readById(financeServiceId));
  }

  @Override
  public List<FinanceServiceResponseDto> getAll() {
    return crudFinanceServiceServicePort.readAll().stream()
      .map(financeServiceApiMapper::toFinanceServiceResponseDto)
      .collect(Collectors.toList());
  }

  @Override
  public FinanceServiceResponseDto post(FinanceServiceRequestDto dto) {
    return financeServiceApiMapper.toFinanceServiceResponseDto(crudFinanceServiceServicePort.create(financeServiceApiMapper.toFinanceService(dto)));
  }

  @Override
  public FinanceServiceResponseDto put(FinanceServiceRequestDto dto, Long financeServiceId) {
    return financeServiceApiMapper.toFinanceServiceResponseDto(crudFinanceServiceServicePort.update(financeServiceApiMapper.toFinanceService(dto), financeServiceId));
  }

  @Override
  public void delete(Long id) {
    crudFinanceServiceServicePort.delete(id);
  }
}

package co.com.pragma.finance_service.application.handler;

import co.com.pragma.finance_service.application.dto.FinanceServiceResponseDto;
import co.com.pragma.finance_service.application.mapper.FinanceServiceApiMapper;
import co.com.pragma.finance_service.domain.api.ReadFinanceServiceServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FinanceServiceHandlerImpl implements FinanceServiceHandler{

  private final ReadFinanceServiceServicePort readFinanceServiceServicePort;
  private final FinanceServiceApiMapper financeServiceApiMapper;

  @Autowired
  public FinanceServiceHandlerImpl(
    ReadFinanceServiceServicePort readFinanceServiceServicePort,
    FinanceServiceApiMapper financeServiceApiMapper
  ) {
    this.readFinanceServiceServicePort = readFinanceServiceServicePort;
    this.financeServiceApiMapper = financeServiceApiMapper;
  }

  @Override
  public FinanceServiceResponseDto getById(Long customerId) {
    return financeServiceApiMapper.toFinanceServiceResponseDto(readFinanceServiceServicePort.readById(customerId));
  }

  @Override
  public List<FinanceServiceResponseDto> getAll() {
    return readFinanceServiceServicePort.readAll().stream()
      .map(financeServiceApiMapper::toFinanceServiceResponseDto)
      .collect(Collectors.toList());
  }
}

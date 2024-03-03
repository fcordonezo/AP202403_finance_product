package co.com.pragma.finance_service.infrastructure.out;

import co.com.pragma.finance_service.domain.model.FinanceService;
import co.com.pragma.finance_service.domain.spi.FinanceServicePersistencePort;
import co.com.pragma.finance_service.infrastructure.out.entity.FinanceServiceEntity;
import co.com.pragma.finance_service.infrastructure.out.mapper.FinanceServiceEntityMapper;
import co.com.pragma.finance_service.infrastructure.out.repository.FinanceServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FinanceServiceJpaAdapter implements FinanceServicePersistencePort {

  private final FinanceServiceRepository financeServiceRepository;
  private final FinanceServiceEntityMapper financeServiceEntityMapper;

  @Autowired
  public FinanceServiceJpaAdapter(
    FinanceServiceRepository financeServiceRepository,
    FinanceServiceEntityMapper financeServiceEntityMapper
  ) {
    this.financeServiceRepository = financeServiceRepository;
    this.financeServiceEntityMapper = financeServiceEntityMapper;
  }

  @Override
  public List<FinanceService> findAll() {
    List<FinanceServiceEntity> financeServiceEntities = financeServiceRepository.findAll();
    return financeServiceEntities.stream()
      .map(financeServiceEntityMapper::toFinanceService)
      .collect(Collectors.toList());
  }

  @Override
  public FinanceService findById(Long idFinanceService) {
    FinanceServiceEntity financeService = financeServiceRepository.findById(idFinanceService).orElseThrow();
    return financeServiceEntityMapper.toFinanceService(financeService);
  }

  @Override
  public FinanceService save(FinanceService financeService) {
    return null;
  }

  @Override
  public void delete(FinanceService financeService) {

  }
}

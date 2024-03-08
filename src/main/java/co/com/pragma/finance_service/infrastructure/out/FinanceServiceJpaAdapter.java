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
  public FinanceService create(FinanceService financeService) {
    return financeServiceEntityMapper.toFinanceService(financeServiceRepository.save(financeServiceEntityMapper.toFinanceServiceEntity(financeService)));
  }

  @Override
  public FinanceService update(FinanceService financeService, Long financeServiceId) {
    return this.financeServiceEntityMapper.toFinanceService(
      financeServiceRepository.save(
        financeServiceEntityMapper.toFinanceServiceEntity(
          financeServiceEntityMapper.addFinanceServiceId(financeService, financeServiceId)
        )
      )
    );
  }

  @Override
  public void delete(Long financeServiceId) {
    financeServiceRepository.deleteById(financeServiceId);
  }
}

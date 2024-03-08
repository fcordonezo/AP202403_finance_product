package co.com.pragma.finance_product.infrastructure.out;

import co.com.pragma.finance_product.domain.model.FinanceProduct;
import co.com.pragma.finance_product.domain.spi.FinanceProductPersistencePort;
import co.com.pragma.finance_product.infrastructure.out.entity.FinanceProductEntity;
import co.com.pragma.finance_product.infrastructure.out.mapper.FinanceProductEntityMapper;
import co.com.pragma.finance_product.infrastructure.out.repository.FinanceProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FinanceProductJpaAdapter implements FinanceProductPersistencePort {

  private final FinanceProductRepository financeProductRepository;
  private final FinanceProductEntityMapper financeProductEntityMapper;

  @Autowired
  public FinanceProductJpaAdapter(
    FinanceProductRepository financeProductRepository,
    FinanceProductEntityMapper financeProductEntityMapper
  ) {
    this.financeProductRepository = financeProductRepository;
    this.financeProductEntityMapper = financeProductEntityMapper;
  }

  @Override
  public List<FinanceProduct> findAll() {
    List<FinanceProductEntity> financeProductEntities = financeProductRepository.findAll();
    return financeProductEntities.stream()
      .map(financeProductEntityMapper::toFinanceProduct)
      .collect(Collectors.toList());
  }

  @Override
  public FinanceProduct findById(Long idFinanceProduct) {
    FinanceProductEntity financeProduct = financeProductRepository.findById(idFinanceProduct).orElseThrow();
    return financeProductEntityMapper.toFinanceProduct(financeProduct);
  }

  @Override
  public FinanceProduct create(FinanceProduct financeProduct) {
    return financeProductEntityMapper.toFinanceProduct(financeProductRepository.save(financeProductEntityMapper.toFinanceProductEntity(financeProduct)));
  }

  @Override
  public FinanceProduct update(FinanceProduct financeProduct, Long financeProductId) {
    return this.financeProductEntityMapper.toFinanceProduct(
      financeProductRepository.save(
        financeProductEntityMapper.toFinanceProductEntity(
          financeProductEntityMapper.addFinanceProductId(financeProduct, financeProductId)
        )
      )
    );
  }

  @Override
  public void delete(Long financeProductId) {
    financeProductRepository.deleteById(financeProductId);
  }
}

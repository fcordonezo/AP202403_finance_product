package co.com.pragma.finance_product.infrastructure.out.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "finance_product")
public class FinanceProductEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "finance_product_id", nullable = false)
  private Long financeProductId;

  @Column(name = "code", nullable = false, length = 3)
  private String code;

  @Column(name = "description")
  private String description;

  @Column(name = "rule_set")
  private String ruleSet;

}

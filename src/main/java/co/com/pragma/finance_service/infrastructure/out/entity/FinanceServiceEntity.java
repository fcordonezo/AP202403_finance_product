package co.com.pragma.finance_service.infrastructure.out.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "finance_service")
public class FinanceServiceEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "finance_service_id", nullable = false)
  private Long financeServiceId;

  @Column(name = "code", nullable = false, length = 3)
  private String code;

  @Column(name = "description")
  private String description;

  @Column(name = "rule_set")
  private String ruleSet;

}

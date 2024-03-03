package co.com.pragma.finance_service.infrastructure.in.rest;

import co.com.pragma.finance_service.application.dto.FinanceServiceResponseDto;
import co.com.pragma.finance_service.application.handler.FinanceServiceHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "finance-services")
public class FinanceServiceController {
  private final FinanceServiceHandler financeServiceHandler;

  @Autowired
  public FinanceServiceController(FinanceServiceHandler financeServiceHandler) {
    this.financeServiceHandler = financeServiceHandler;
  }

  @GetMapping(path = "/{financeServiceId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<FinanceServiceResponseDto> getById(@PathVariable("financeServiceId") Long financeServiceId) {
    FinanceServiceResponseDto financeServiceResponseDto = financeServiceHandler.getById(financeServiceId);
    return ResponseEntity.ok(financeServiceResponseDto);
  }

  @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<FinanceServiceResponseDto>> getAll() {
    List<FinanceServiceResponseDto> financeServiceResponseDto = financeServiceHandler.getAll();
    return ResponseEntity.ok(financeServiceResponseDto);
  }
}

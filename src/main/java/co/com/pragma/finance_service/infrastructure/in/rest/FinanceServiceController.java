package co.com.pragma.finance_service.infrastructure.in.rest;

import co.com.pragma.finance_service.application.dto.FinanceServiceRequestDto;
import co.com.pragma.finance_service.application.dto.FinanceServiceResponseDto;
import co.com.pragma.finance_service.application.handler.FinanceServiceHandler;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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

  @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<FinanceServiceResponseDto> post(@RequestBody FinanceServiceRequestDto dto) {
    FinanceServiceResponseDto financeServiceResponseDto = financeServiceHandler.post(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(financeServiceResponseDto);
  }

  @PutMapping(path = "/{financeServiceId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<FinanceServiceResponseDto> put(@RequestBody FinanceServiceRequestDto dto, @PathVariable("financeServiceId") Long financeServiceId) {
    FinanceServiceResponseDto financeServiceResponseDto = financeServiceHandler.put(dto, financeServiceId);
    return ResponseEntity.ok(financeServiceResponseDto);
  }

  @DeleteMapping(path = "/{financeServiceId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> delete(@PathVariable("financeServiceId") Long financeServiceId) {
    financeServiceHandler.delete(financeServiceId);
    return ResponseEntity.ok().build();
  }
}

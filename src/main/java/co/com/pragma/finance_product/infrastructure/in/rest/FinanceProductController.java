package co.com.pragma.finance_product.infrastructure.in.rest;

import co.com.pragma.finance_product.application.handler.FinanceProductHandler;
import co.com.pragma.finance_product.application.dto.FinanceProductRequestDto;
import co.com.pragma.finance_product.application.dto.FinanceProductResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SecurityRequirement(name = "BearerAuthentication")
public class FinanceProductController {
  private final FinanceProductHandler financeProductHandler;

  @Autowired
  public FinanceProductController(FinanceProductHandler financeProductHandler) {
    this.financeProductHandler = financeProductHandler;
  }

  @Operation(summary = "Obtener producto financiero por ID")
  @GetMapping(path = "/{financeProductId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<FinanceProductResponseDto> getById(@PathVariable("financeProductId") Long financeProductId) {
    FinanceProductResponseDto financeProductResponseDto = financeProductHandler.getById(financeProductId);
    return ResponseEntity.ok(financeProductResponseDto);
  }

  @Operation(summary = "Obtener todos los productos financieros")
  @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<FinanceProductResponseDto>> getAll() {
    List<FinanceProductResponseDto> financeProductResponseDto = financeProductHandler.getAll();
    return ResponseEntity.ok(financeProductResponseDto);
  }

  @Operation(summary = "Agregar un producto financiero")
  @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<FinanceProductResponseDto> post(@RequestBody FinanceProductRequestDto dto) {
    FinanceProductResponseDto financeProductResponseDto = financeProductHandler.post(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(financeProductResponseDto);
  }

  @Operation(summary = "Actualizar un producto financiero")
  @PutMapping(path = "/{financeProductId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<FinanceProductResponseDto> put(@RequestBody FinanceProductRequestDto dto, @PathVariable("financeProductId") Long financeProductId) {
    FinanceProductResponseDto financeProductResponseDto = financeProductHandler.put(dto, financeProductId);
    return ResponseEntity.ok(financeProductResponseDto);
  }

  @Operation(summary = "Eliminar un producto financiero por ID")
  @DeleteMapping(path = "/{financeProductId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> delete(@PathVariable("financeProductId") Long financeProductId) {
    financeProductHandler.delete(financeProductId);
    return ResponseEntity.ok().build();
  }
}

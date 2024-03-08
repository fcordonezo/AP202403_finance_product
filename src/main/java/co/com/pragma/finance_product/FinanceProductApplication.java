package co.com.pragma.finance_product;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info=@Info(title="Producto Financiero"))
@SpringBootApplication
public class FinanceProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinanceProductApplication.class, args);
	}

}

package co.com.pragma.finance_product;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info=@Info(title="Producto financiero", version = "1.0.0"))
@SecurityScheme(name = "BearerAuthentication", type = SecuritySchemeType.HTTP, bearerFormat = "JWT", scheme = "bearer")
@SpringBootApplication
public class FinanceProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinanceProductApplication.class, args);
	}

}

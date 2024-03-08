package co.com.pragma.finance_service;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info=@Info(title="Finance Service"))
@SpringBootApplication
public class FinanceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinanceServiceApplication.class, args);
	}

}

package com.bank.banking_solution;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = "com.bank.banking_solution.Models")
@ComponentScan(basePackages = "com.bank.banking_solution")
public class BankingSolutionApplication {

	
	public static void main(String[] args) {
		
		SpringApplication.run(BankingSolutionApplication.class, args);
	}

}

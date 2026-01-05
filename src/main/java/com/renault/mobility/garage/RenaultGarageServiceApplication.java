package com.renault.mobility.garage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RenaultGarageServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RenaultGarageServiceApplication.class, args);
	}

}

package com.colak.springoutboxtutorial;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableKafka
@EnableScheduling
@OpenAPIDefinition
public class SpringOutboxTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringOutboxTutorialApplication.class, args);
	}

}

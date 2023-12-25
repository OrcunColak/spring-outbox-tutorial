package com.colak.springoutboxtutorial;


import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableKafka
@EnableScheduling
//@OpenAPIDefinition(
//        info = @Info(title = "Book Order API", version = "1.0", description = "Transactional Outbox Tutorial"),
//        externalDocs = @ExternalDocumentation(url = "https://dip-mazumder.medium.com/consistency-in-microservices-transactional-outbox-pattern-bcd9d3b08676")
//)
public class SpringOutboxTutorialApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringOutboxTutorialApplication.class, args);
    }

    @Bean
    public OpenAPI customOpenAPI(@Value("${application-description}") String appDesciption,
                                 @Value("${application-version}") String appVersion) {

        License license = new License().name("Apache 2.0").url("http://springdoc.org");

        Info info = new Info()
                .title("Book Order API")
                .version(appVersion)
                .description(appDesciption)
                .termsOfService("http://swagger.io/terms/")
                .license(license);

        ExternalDocumentation externalDocumentation = new ExternalDocumentation()
                .description("Original idea is from here")
                .url("https://dip-mazumder.medium.com/consistency-in-microservices-transactional-outbox-pattern-bcd9d3b08676");

        return new OpenAPI()
                .info(info)
                .externalDocs(externalDocumentation);
    }

}

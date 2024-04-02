package com.practicecoding.springboot;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Spring Boot REST API documentation",
                description = "Spring Boot REST API documentation",
                version = "v1.0",
                contact = @Contact(
                        name = "Pratik",
                        email = "practicecoding@yahoo.com",
                        url = "http://practicecoding.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://practicecoding.com/license"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Rest API User Management Documentation",
                url = "http://practicecoding.com/user_management.html"
        )
)
public class SpringbootRestfulWebservicesApplication {

    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfulWebservicesApplication.class, args);
	}

}

package com.example.FusionPersona;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "PERSONA FUSION SYSTEM API", version = "0.1"))
@SpringBootApplication
public class FusionPersonaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FusionPersonaApplication.class, args);
	}

}

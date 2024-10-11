package com.ticketmanagement.SwaggerApi;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI myCustomConfig() {
		return new OpenAPI().info(new Info().title("Tourist API ")
				.version("1.0")
                .description("This is a sample Spring Boot RESTful service using OpenAPI 3.")
                .termsOfService("https://example.com/terms")
                .contact(new Contact()
                        .name("John Doe")
                        .email("john.doe@example.com")
                        .url("https://example.com"))
                .license(new License()
                        .name("Apache 2.0")
                        .url("http://springdoc.org")))
        .servers(Arrays.asList(
                new Server().url("https://api.example.com").description("Production Server"),
                new Server().url("https://dev-api.example.com").description("Development Server")));
	}
}

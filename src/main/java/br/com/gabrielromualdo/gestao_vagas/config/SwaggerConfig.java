package br.com.gabrielromualdo.gestao_vagas.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.security.SecurityScheme;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title("Gestão Vagas").description("API responsável pela gestão de vagas")
                        .version("1"))
                        .schemaRequirement("jwt_auth", createSercurityScheme());
    }

    private SecurityScheme createSercurityScheme() {
        return new io.swagger.v3.oas.models.security.SecurityScheme()
                .name("jwt_auth")
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT");

    }
}
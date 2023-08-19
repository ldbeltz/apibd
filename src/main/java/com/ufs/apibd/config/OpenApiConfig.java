package com.ufs.apibd.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI().components(new Components())
                .info(new Info().title("API de cadastro de usuário")
                .description("API simples para cadastrar um usuário no banco de dados"));
    }
}

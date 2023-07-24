package com.haryridart.libraryapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {
    private ApiInfo apiInfo(){
        return new ApiInfo(
                "Spring Boot Library Management App REST APIs",
                "Spring Boot Library Management App REST API Documentation",
                "1",
                "Terms of service",
                new Contact("Hary Ridart", "", "hary.teguh@ui.ac.id"),
                "License of API",
                "API license URL",
                Collections.emptyList()
        );
    }
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}

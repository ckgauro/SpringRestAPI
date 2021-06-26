package com.gauro.config;

import com.gauro.data.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * @author Chandra
 */
@Configuration
//@EnableWebMvc
@EnableSwagger2
public class SwaggerConfig {

//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2).select()
//                .apis(RequestHandlerSelectors.basePackage(Person.class.getPackage().getName()))
//                .paths(PathSelectors.any()).build();
//    }
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.erudio"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "RESTful API With Spring Boot 2.1.3",
                "Some description about your API.",
                "v1",
                "Terms Of Service Url",
                new Contact("Leandro Costa", "www.erudio.com.br", "your_email@gmail.com"),
                "License of API", "License of URL", Collections.emptyList());
    }

}

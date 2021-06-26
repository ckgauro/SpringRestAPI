package com.gauro.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Chandra
 */
@Slf4j
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    //private static final MediaType MEDIA_TYPE_YML = MediaType.valueOf("application/x-yaml");
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        // Via EXTENSION. localhost:8080/persons.x-yaml
        log.info("WebConfig========> Called");
//        configurer.favorParameter(false).ignoreAcceptHeader(false)
//                .defaultContentType(MediaType.APPLICATION_JSON)
//                .mediaType("json", MediaType.APPLICATION_JSON)
//                .mediaType("xml", MediaType.APPLICATION_XML)       ;

        // Via QUERY PARAM. localhost:8080/person?mediaType=xml

//          configurer.favorPathExtension(false) .favorParameter(true)
//          .parameterName("mediaType") .ignoreAcceptHeader(true)
//          .useRegisteredExtensionsOnly(false)
//          .defaultContentType(MediaType.APPLICATION_JSON) .mediaType("json",
//          MediaType.APPLICATION_JSON) .mediaType("xml", MediaType.APPLICATION_XML);

        configurer.favorPathExtension(false)
                .favorParameter(false)
                .ignoreAcceptHeader(false)
                .useRegisteredExtensionsOnly(false)
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_XML)
                .mediaType("json", MediaType.APPLICATION_JSON);
               // .mediaType("x-yaml", MEDIA_TYPE_YML);

        // WebMvcConfigurer.super.configureContentNegotiation(configurer);
    }
}

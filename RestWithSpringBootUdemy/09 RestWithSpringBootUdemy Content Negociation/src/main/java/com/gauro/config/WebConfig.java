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
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    //    configurer.defaultContentType(MediaType.APPLICATION_JSON);
//                configurer.favorParameter(false).ignoreAcceptHeader(false)
//                .defaultContentType(MediaType.APPLICATION_JSON)
//                .mediaType("json", MediaType.APPLICATION_JSON)
//                .mediaType("xml", MediaType.APPLICATION_XML)       ;

                  configurer.favorPathExtension(false) .favorParameter(true)
          .parameterName("mediaType") .ignoreAcceptHeader(true)
          .useRegisteredExtensionsOnly(false)
          .defaultContentType(MediaType.APPLICATION_JSON) .mediaType("json",
          MediaType.APPLICATION_JSON) .mediaType("xml", MediaType.APPLICATION_XML);

    }
}


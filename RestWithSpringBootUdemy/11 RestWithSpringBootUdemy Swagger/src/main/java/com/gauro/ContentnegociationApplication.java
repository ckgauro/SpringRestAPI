package com.gauro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
public class ContentnegociationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentnegociationApplication.class, args);
	}

}

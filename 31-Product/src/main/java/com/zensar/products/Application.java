package com.zensar.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableWebMvc
@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = "com.zensar.products")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

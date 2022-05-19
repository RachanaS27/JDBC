package com.zensar;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;


@SpringBootApplication
@Component
@EnableWebMvc
@EnableAutoConfiguration
@ComponentScan("com.zensar")
public class Application1 {

	public static void main(String[] args) {
		SpringApplication.run(Application1.class, args);
	}

	@Bean
	public  AcceptHeaderLocaleResolver localeResolver()
	{
	AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
	localeResolver.setDefaultLocale(Locale.US);
	return localeResolver;
	}
}

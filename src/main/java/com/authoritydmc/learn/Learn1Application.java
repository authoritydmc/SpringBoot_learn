package com.authoritydmc.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays;

@EnableWebMvc
@SpringBootApplication
public class Learn1Application {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(Learn1Application.class, args);
//		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
	}

}

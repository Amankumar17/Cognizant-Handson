package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan("com.*")
public class RestCrudAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestCrudAppApplication.class, args);
	}

}

package com.example.springtasksplanning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.springtasksplanning.repository")
public class SpringtasksplanningApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringtasksplanningApplication.class, args);
	}

}

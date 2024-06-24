package com.example.VishalSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})

public class VishalSpringApplication {

	public static void main(String[] args) {
		System.out.println("VISHAL JAIN");
//http://localhost:8080/swagger-ui.html
		SpringApplication.run(VishalSpringApplication.class);
	}

}

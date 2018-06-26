package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = {"com.revature"})
public class QuizServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(QuizServiceApplication.class, args);
	}
}

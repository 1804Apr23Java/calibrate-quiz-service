package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.revature"})
public class QuizServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(QuizServiceApplication.class, args);
	}
}

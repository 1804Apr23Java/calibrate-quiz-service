package com.revature;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.revature.beans.Answer;
import com.revature.beans.Question;
import com.revature.beans.Quiz;
import com.revature.service.AnswerService;
import com.revature.service.QuestionService;
import com.revature.service.QuizService;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = {"com.revature"})
public class QuizServiceApplication implements CommandLineRunner {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private AnswerService answerService;
	
	@Autowired
	private QuizService quizService;
	
	public static void main(String[] args) {
		SpringApplication.run(QuizServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
	}
}

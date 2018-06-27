package com.revature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.revature.beans.Answer;
import com.revature.beans.Question;
import com.revature.service.AnswerService;
import com.revature.service.QuestionService;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = {"com.revature"})
public class QuizServiceApplication implements CommandLineRunner {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private AnswerService answerService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(QuizServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Question a = questionService.saveQuestion(new Question("What is the capital of Canada?", 1, 56));
		Question b = questionService.saveQuestion(new Question("What is the capital of the USA?", 1, 56));
		Question c = questionService.saveQuestion(new Question("What is the capital of China?", 1, 56));
		Question d = questionService.saveQuestion(new Question("What is the capital of Australia?", 1, 56));
		
		Answer aA = answerService.saveAnswer(new Answer("Ottawa", true, a));
		Answer aB = answerService.saveAnswer(new Answer("Toronto", false, a));
		Answer aC = answerService.saveAnswer(new Answer("Montreal", false, a));
		Answer aD = answerService.saveAnswer(new Answer("Vancouver", false, a));
		
		Answer bA = answerService.saveAnswer(new Answer("Washington", true, b));
		Answer bB = answerService.saveAnswer(new Answer("New York", false, b));
		Answer bC = answerService.saveAnswer(new Answer("Philadephia", false, b));
		Answer bD = answerService.saveAnswer(new Answer("Boston", false, b));
		
		Answer cA = answerService.saveAnswer(new Answer("Beijing", true, c));
		Answer cB = answerService.saveAnswer(new Answer("Shanghai", false, c));
		Answer cC = answerService.saveAnswer(new Answer("Hong Kong", false, c));
		Answer cD = answerService.saveAnswer(new Answer("Guangzhou", false, c));
		
		Answer dA = answerService.saveAnswer(new Answer("Canberra", true, d));
		Answer dB = answerService.saveAnswer(new Answer("Sydney", false, d));
		Answer dC = answerService.saveAnswer(new Answer("Melbourne", false, d));
		Answer dD = answerService.saveAnswer(new Answer("Perth", false, d));
	}
}

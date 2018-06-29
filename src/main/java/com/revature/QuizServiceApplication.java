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
		Question a = questionService.saveQuestion(new Question("What does HTML stand for?", 1, 1));
		Question b = questionService.saveQuestion(new Question("What does CSS stand for?", 1, 1));
		Question c = questionService.saveQuestion(new Question("What HTML element is represent a paragraph?", 1, 1));
		Question d = questionService.saveQuestion(new Question("What is the root element for an HTML document?", 1, 1));
		Question e = questionService.saveQuestion(new Question("What is CSS used for?", 1, 1));
	
		Answer aA = answerService.saveAnswer(new Answer("Hypertext Markup Language", true, a));
		Answer aB = answerService.saveAnswer(new Answer("Hypersonic Markup Language", false, a));
		Answer aC = answerService.saveAnswer(new Answer("HighlyReadable Markup Language", false, a));
		Answer aD = answerService.saveAnswer(new Answer("HyperScript Markup Language", false, a));
		
		Answer bA = answerService.saveAnswer(new Answer("Cascading Scripted Sheets", false, b));
		Answer bB = answerService.saveAnswer(new Answer("Cascading Style Sheets", true, b));
		Answer bC = answerService.saveAnswer(new Answer("Cascading Style Specification", false, b));
		Answer bD = answerService.saveAnswer(new Answer("Cascading Style Scripts", false, b));
		
		Answer cA = answerService.saveAnswer(new Answer("<h1>", false, c));
		Answer cB = answerService.saveAnswer(new Answer("<para>", false, c));
		Answer cC = answerService.saveAnswer(new Answer("<p>", true, c));
		Answer cD = answerService.saveAnswer(new Answer("<text>", false, c));
		
		Answer dA = answerService.saveAnswer(new Answer("<root>", false, d));
		Answer dB = answerService.saveAnswer(new Answer("<r>", false, d));
		Answer dC = answerService.saveAnswer(new Answer("<html-root>", false, d));
		Answer dD = answerService.saveAnswer(new Answer("<html>", true, d));
		
		Answer eA = answerService.saveAnswer(new Answer("For programming web pages", false, d));
		Answer eB = answerService.saveAnswer(new Answer("For styling web pages", true, d));
		Answer eC = answerService.saveAnswer(new Answer("For specifying the structure of web pages", false, d));
		Answer eD = answerService.saveAnswer(new Answer("For connecting to web pages", true, d));
		
		
		
		Question f = questionService.saveQuestion(new Question("How to query a Database?", 1, 2));
        Answer fA = answerService.saveAnswer(new Answer("SELECT", true, a));
        Answer fB = answerService.saveAnswer(new Answer("INSERT", false, a));
        Answer fC = answerService.saveAnswer(new Answer("DELETE", false, a));
        
        Question g = questionService.saveQuestion(new Question("How to call stored procedure?", 1, 2));
        Answer gA = answerService.saveAnswer(new Answer("CallableStatement", true, b));
        Answer gB = answerService.saveAnswer(new Answer("PreparedStatement", false, b));
        Answer gC = answerService.saveAnswer(new Answer("Statement", false, b));
        

        Question h = questionService.saveQuestion(new Question("T/F SQL is Structured Query Language?", 1, 2));
        Answer hA = answerService.saveAnswer(new Answer("Beijing", true, c));
        Answer hB = answerService.saveAnswer(new Answer("Shanghai", false, c));
        
        Question i = questionService.saveQuestion(new Question("WHERE is used for conditionals?", 2, 2));
        Answer iA = answerService.saveAnswer(new Answer("true", true, d));
        Answer iB = answerService.saveAnswer(new Answer("false", false, d));

        Question j = questionService.saveQuestion(new Question("How to sort?", 3, 2));
        Answer jA = answerService.saveAnswer(new Answer("ORDER BY", true, d));
        Answer jB = answerService.saveAnswer(new Answer("GROUP BY", false, d));
        Answer jC = answerService.saveAnswer(new Answer("HAVING", false, d));

        
        
        Question javaa = questionService.saveQuestion(new Question("What kind of Exception is checked at runtime?", 1, 3));
        Answer javaaA = answerService.saveAnswer(new Answer("RuntimeException", true, javaa));
        Answer javaaB = answerService.saveAnswer(new Answer("Exception", false, javaa));
        Answer javaaC = answerService.saveAnswer(new Answer("Error", false, javaa));
        
        Question javab = questionService.saveQuestion(new Question("Keyword for inheritance?", 1, 3));
        Answer javabA = answerService.saveAnswer(new Answer("extends", true, javab));
        Answer javabB = answerService.saveAnswer(new Answer("implements", false, javab));
        Answer javabC = answerService.saveAnswer(new Answer("instanceof", false, javab));

        Question javac = questionService.saveQuestion(new Question("T/F Java is Aspect-oriented?", 1, 3));
        Answer javacA = answerService.saveAnswer(new Answer("false", true, javac));
        Answer javacB = answerService.saveAnswer(new Answer("true", false, javac));
        
        Question javad = questionService.saveQuestion(new Question("Marker Interface?", 2, 3));
        Answer javadA = answerService.saveAnswer(new Answer("has no implementations", true, javad));
        Answer javadB = answerService.saveAnswer(new Answer("were written by Crayola", false, javad));

        Question javae = questionService.saveQuestion(new Question("How to sort list?", 3, 3));
        Answer javaeA = answerService.saveAnswer(new Answer("Collections.sort", true, javae));
        Answer javaeB = answerService.saveAnswer(new Answer("Collections.shuffle", false, javae));
        Answer javaeC = answerService.saveAnswer(new Answer("Collections.stream", false, javae));
	}
}

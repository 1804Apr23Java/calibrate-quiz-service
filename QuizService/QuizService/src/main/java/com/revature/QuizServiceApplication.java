package com.revature;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.DTO.QuestionDTO;
import com.revature.beans.Answer;
import com.revature.beans.Question;
import com.revature.beans.Quiz;
import com.revature.repository.QuestionRepository;
import com.revature.service.AnswerService;
import com.revature.service.QuestionService;
import com.revature.service.QuizService;

@SpringBootApplication(scanBasePackages = {"com.revature"})
public class QuizServiceApplication implements CommandLineRunner {
	
	@Autowired
	QuestionService s;
	
	@Autowired
	AnswerService as;
	
	@Autowired
	QuizService qSer;

	public static void main(String[] args) {
		SpringApplication.run(QuizServiceApplication.class, args);
	}
	
	@Override
	public void run(String...args) throws Exception {
		Question q = s.saveQuestion(5, "What is the capital of Canada?");
		System.out.printf("Question # %d, %s\n", q.getId(), q.getQuestion_content());
		Integer id = q.getId();
		
		q =  s.updateQuestionContent(id, "What is the capital of Portugal?");
		q = s.updateQuestionDifficulty(id, 6);
		System.out.printf("Question # %d, %s\n", q.getId(), q.getQuestion_content());
		
		Answer a = as.saveAnswer(new Answer("Lisbon", false, q));
		System.out.printf("Answer # %d for question %d, %s :: %s = %b\n", a.getId(), a.getQuestion().getId(), a.getQuestion().getQuestion_content(), a.getAnswer_content(), a.isCorrect());
		a = as.saveAnswer(new Answer("Madrid", false, q));
		a = as.saveAnswer(new Answer("Barcelona", true, q));
		System.out.printf("Answer # %d for question %d, %s :: %s = %b\n", a.getId(), a.getQuestion().getId(), a.getQuestion().getQuestion_content(), a.getAnswer_content(), a.isCorrect());
		
		id = a.getId();
		
		as.updateAnswerIsCorrect(id, false);
		
		a = as.getAnswer(id);
		
		System.out.printf("Answer # %d for question %d, %s :: %s = %b\n", a.getId(), a.getQuestion().getId(), a.getQuestion().getQuestion_content(), a.getAnswer_content(), a.isCorrect());
		
		Set<Question> sq = new HashSet<>();
		sq.add(q);
		Quiz qz = new Quiz("Capital Quiz", sq);
		Quiz savedQuiz = qSer.saveQuiz(qz);
		System.out.printf("Quiz name = %s", savedQuiz.getName());
	}
}

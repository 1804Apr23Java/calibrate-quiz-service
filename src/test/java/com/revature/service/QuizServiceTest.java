package com.revature.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.beans.Question;
import com.revature.beans.Quiz;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT)
public class QuizServiceTest {

	@Autowired
	private QuizService quizService;
	
	@Autowired
	private QuestionService questionService;
	
	@Test
	public void saveAndDeleteTest() {
		Set<Question> questions = new HashSet<Question>();
		Question a = questionService.saveQuestion(new Question("Q1", 1, 1));
		Question b = questionService.saveQuestion(new Question("Q2", 1, 1));
		Question c = questionService.saveQuestion(new Question("Q3", 1, 1));
		questions.add(a);
		questions.add(b);
		questions.add(c);
		
		Quiz qz = quizService.saveQuiz(new Quiz("Geography Quiz", questions));
		qz = quizService.getQuiz(qz.getId());
		
		assertEquals("Geography Quiz", qz.getName());
		assertEquals(questions, qz.getQuestions());
		
		quizService.deleteQuiz(qz);
		questions.forEach((e) -> { questionService.deleteQuestion(e); });
		
		assertFalse(quizService.doesQuizExist(qz.getId()));
	}
	
	@Test
	public void updateQuizNameTest() {
		Quiz qz = quizService.saveQuiz(new Quiz("Geography Quiz", null));
		qz = quizService.updateQuizName(qz.getId(), "Capitals Quiz");
		assertEquals("Capitals Quiz", qz.getName());
		
		quizService.deleteQuiz(qz);
		assertFalse(quizService.doesQuizExist(qz.getId()));
	}
	
	@Test
	public void generateQuizByLibraryId() {
		Set<Question> questions = new HashSet<Question>();
		Question a = questionService.saveQuestion(new Question("Q1", 1, 4));
		Question b = questionService.saveQuestion(new Question("Q2", 1, 5));
		Question c = questionService.saveQuestion(new Question("Q3", 1, 6));
		questions.add(a);
		questions.add(b);
		questions.add(c);
		
		List<Integer> libraryIds = new ArrayList<>();
		libraryIds.add(4);
		libraryIds.add(5);
		libraryIds.add(6);
		
		Quiz qz = quizService.generateQuiz("TestQuiz", libraryIds, 3);
		
		assertEquals("TestQuiz", qz.getName());
		assertEquals(qz.getQuestions(), questions);
		
		quizService.deleteQuiz(qz);
		questions.forEach((e) -> { questionService.deleteQuestion(e);});
		assertFalse(quizService.doesQuizExist(qz.getId()));
	}
}

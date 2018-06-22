package com.revature.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.beans.Question;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionServiceTest {
	
	@Autowired
	private QuestionService qs;
	
	@Test
	public void saveAndDeleteTest() {
		Question q = qs.saveQuestion(new Question("What are the capitals of the World", 10, 1));
		q = qs.getQuestion(q.getId());
		assertEquals("What are the capitals of the World", q.getQuestion_content());
		assertEquals(10, q.getDifficulty().intValue());
		assertEquals(1, q.getLibrary_id().intValue());
		
		qs.deleteQuestion(q);
		assertFalse(qs.doesQuestionExist(q.getId()));
	}
	
	@Test
	public void updateContentTest() {
		Question q = qs.saveQuestion(new Question("What are the capitals of the Earth", 10, 1));
		q = qs.updateQuestionContent(q.getId(), "What are the capitals of the World");
		
		assertEquals("What are the capitals of the World", q.getQuestion_content());
		assertEquals(10, q.getDifficulty().intValue());
		assertEquals(1, q.getLibrary_id().intValue());
		
		qs.deleteQuestion(q);
		assertFalse(qs.doesQuestionExist(q.getId()));
	}
	
	@Test
	public void updateQuestionDifficultyTest() {
		Question q = qs.saveQuestion(new Question("What are the capitals of the Earth", 10, 1));
		q = qs.updateQuestionDifficulty(q.getId(), 8);
		
		assertEquals(8, q.getDifficulty().intValue());
		
		qs.deleteQuestion(q);
		assertFalse(qs.doesQuestionExist(q.getId()));
	}
	
	@Test
	public void updateQuestionLibraryTest() {
		Question q = qs.saveQuestion(new Question("What are the capitals of the Earth", 10, 1));
		q = qs.updateQuestionLibrary(q.getId(), 5);
		
		assertEquals(5, q.getLibrary_id().intValue());
		
		qs.deleteQuestion(q);
		assertFalse(qs.doesQuestionExist(q.getId()));
	}
	
	@Test
	public void getQuestionsByLibraryTest() {
		Set<Question> questions = new HashSet<>();
		
		Question a = qs.saveQuestion(new Question("What are the capitals of the Earth", 10, 1));
		questions.add(a);
		Question b = qs.saveQuestion(new Question("What are the capitals of the USA", 10, 1));
		questions.add(b);
		Question c = qs.saveQuestion(new Question("What are the capitals of Canada", 10, 1));
		questions.add(c);
		
		assertEquals(questions, qs.getQuestionsByLibrary(1));
	}
}

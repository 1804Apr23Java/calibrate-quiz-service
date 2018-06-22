package com.revature.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.beans.Answer;
import com.revature.beans.Question;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AnswerServiceTest {
	
	@Autowired
	private AnswerService as;
	
	@Autowired
	private QuestionService qs;
	
	private Question q;
	
	@BeforeClass
	public void setupForTest() {
		this.q = qs.saveQuestion(new Question("What are the Capitals of the World", 10, 1));
	}
	
	@Test
	public void saveAndDeleteTest() {
		Answer a = as.saveAnswer(new Answer("The Capital of Mexico is Mexico City", true, this.q));
		Answer savedAnswer = as.getAnswer(a.getId());
		assertEquals(savedAnswer.getAnswer_content(), "The Capital of Mexico is Mexico City");
		assertEquals(savedAnswer.getId(), a.getId());
		assertEquals(savedAnswer.getQuestion(), this.q);
		
		as.deleteAnswer(savedAnswer);
		assertNull(as.getAnswer(a.getId()));
	}
	
	@Test
	public void updateContentTest() {
		Answer a = as.saveAnswer(new Answer("The Capital of Mexico is Mexico City", true, this.q));
		Answer savedAnswer = as.getAnswer(a.getId());
		savedAnswer = as.updateAnswerContent(savedAnswer.getId(), "The Capital of Argentina is Buenos Aries");
		assertEquals(savedAnswer.getAnswer_content(), "The Capital of Australia is Canberra");
		
		as.deleteAnswer(savedAnswer);
	}
	
	@Test
	public void updateAnswerIsCorrectTest() {
		Answer a = as.saveAnswer(new Answer("The Capital of Italy is Milan", true, this.q));
		Answer savedAnswer = as.getAnswer(a.getId());
		savedAnswer = as.updateAnswerIsCorrect(savedAnswer.getId(), false);
		assertEquals(savedAnswer.isCorrect(), false);
		
		as.deleteAnswer(savedAnswer);
	}
	
	@Test
	public void getAnswersByQuestionTest() {
		Answer a = as.saveAnswer(new Answer("The Capital of Italy is Milan", true, this.q));
		Answer b = as.saveAnswer(new Answer("The Capital of China is Beijing", true, this.q));
		Answer c = as.saveAnswer(new Answer("The Capital of Japan is Tokyo", true, this.q));
		
		Set<Answer> answers = new HashSet<>();
		answers.add(a);
		answers.add(b);
		answers.add(c);
		
		Set<Answer> savedAnswers = as.getAnswersByQuuestion(this.q);
	}
}

package com.revature.controller;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.DTO.QuizDTO;
import com.revature.beans.Question;
import com.revature.beans.Quiz;
import com.revature.service.QuestionService;
import com.revature.service.QuizService;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT)
public class QuizControllerTest {
	
	@Autowired QuizService quizService;
	
	@Autowired QuestionService questionService;
	
	@Test
	public void getQuizTest() throws JsonParseException, JsonMappingException, IOException {
		Question a = questionService.saveQuestion(new Question("Test Question", 1, 456));
		Question b = questionService.saveQuestion(new Question("Test Question", 1, 456));
		Question c = questionService.saveQuestion(new Question("Test Question", 1, 456));
		Set<Question> set = new HashSet<>();
		set.add(a);
		set.add(b);
		set.add(c);
		Quiz q = quizService.saveQuiz(new Quiz("Test Quiz", set));
		
		RestAssured.port = 8763;
		RequestSpecification request = RestAssured.given();	
		Response response = request.get("/quiz/" + q.getId());
		assertEquals(200, response.getStatusCode());
		
		QuizDTO responseQuiz = new ObjectMapper().readValue(response.asString(), QuizDTO.class);
		assertEquals(q.getName(), responseQuiz.getName());
		assertEquals(q.getId(), responseQuiz.getId());
		assertEquals(q.getQuestions(), responseQuiz.getQuestions());
		
		quizService.deleteQuiz(quizService.getQuiz(responseQuiz.getId()));
		set.forEach((e) -> { questionService.deleteQuestion(e); });
	}

	@Test
	public void generateQuizTest() throws JsonParseException, JsonMappingException, IOException {
		Question a = questionService.saveQuestion(new Question("Test Question", 1, 789));
		Question b = questionService.saveQuestion(new Question("Test Question2", 1, 789));
		Question c = questionService.saveQuestion(new Question("Test Question3", 1, 789));
		Question d = questionService.saveQuestion(new Question("Test Question4", 1, 800));
		Question e = questionService.saveQuestion(new Question("Test Question5", 1, 800));
		Set<Question> set = new HashSet<>();
		set.add(a);
		set.add(b);
		set.add(c);
		set.add(d);
		set.add(e);
		
		List<Integer> list = new ArrayList<>();
		list.add(789);
		list.add(800);
		
		RestAssured.port = 8763;
		RequestSpecification request = RestAssured.given();
		request.formParam("libraryIds", list);
		request.formParam("name", "Test Quiz 2");
		request.formParam("numQuestions", 5);
		Response response = request.get("/quiz/generate");
		assertEquals(200, response.getStatusCode());
		
		QuizDTO responseQuiz = new ObjectMapper().readValue(response.asString(), QuizDTO.class);
		assertEquals("Test Quiz 2", responseQuiz.getName());
		assertEquals(5, responseQuiz.getQuestions().size());
		assertEquals(set, responseQuiz.getQuestions());
		
		quizService.deleteQuiz(quizService.getQuiz(responseQuiz.getId()));
		set.forEach((question) -> { questionService.deleteQuestion(question); });
	}
}

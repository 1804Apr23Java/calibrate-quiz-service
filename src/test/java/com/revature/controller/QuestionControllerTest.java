package com.revature.controller;

import static org.assertj.core.api.Assertions.from;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Question;
import com.revature.DTO.QuestionDTO;
import com.revature.service.QuestionService;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT)
public class QuestionControllerTest {
	
	@Autowired QuestionService questionService;
	
	@Test
	public void addQuestionEndpointTest() throws JSONException, JsonParseException, JsonMappingException, IOException {
		RestAssured.port = 8763;
		RequestSpecification request = RestAssured.given();
		
		request.formParam("content", "What is the capital of Australia");
		request.formParam("difficulty", 1);
		request.formParam("library_id", 2);
		
		Response response = request.post("/question/add");
		assertEquals(200, response.getStatusCode());
		
		QuestionDTO resp = new ObjectMapper().readValue(response.asString(), QuestionDTO.class);
		assertEquals("What is the capital of Australia", resp.getQuestionValue());
		assertEquals(new Integer(1), resp.getDifficulty());
		assertEquals(new Integer(2), resp.getLibraryId());
		
		questionService.deleteQuestion(questionService.getQuestion((Integer) resp.getQuestionId()));
		assertFalse(questionService.doesQuestionExist((Integer) resp.getQuestionId()));
	}
	
	@Test
	public void getQuestionsByLibraryIdTest() throws JsonParseException, JsonMappingException, IOException {
		Set<Question> questions = new HashSet<>();
		questions.add(questionService.saveQuestion(new Question("Q1", 1, 7)));
		questions.add(questionService.saveQuestion(new Question("Q2", 1, 7)));
		questions.add(questionService.saveQuestion(new Question("Q3", 1, 7)));
		questions.add(questionService.saveQuestion(new Question("Q4", 1, 7)));
		questions.add(questionService.saveQuestion(new Question("Q5", 1, 7)));
		
		RestAssured.port = 8763;
		RequestSpecification request = RestAssured.given();
		Response response = request.get("/question/lib/7");
		
		assertEquals(200, response.getStatusCode());
		ArrayList<QuestionDTO> resp = new ObjectMapper().readValue(response.asString(), ArrayList.class);
		assertEquals(questions.size(), resp.size());
	}
	
	@Test
	public void getQuestionByIdTest() throws JsonParseException, JsonMappingException, IOException {
		Question q = questionService.saveQuestion(new Question("Test Question", 1, 22));
		
		RestAssured.port = 8763;
		RequestSpecification request = RestAssured.given();
		Response response = request.get("/question/" + q.getId());
		
		assertEquals(200, response.getStatusCode());
		QuestionDTO responseQuestion = new ObjectMapper().readValue(response.asString(), QuestionDTO.class);
		
		assertEquals(q.getId(), responseQuestion.getQuestionId());
		assertEquals(q.getDifficulty(), responseQuestion.getDifficulty());
		assertEquals(q.getLibrary_id(), responseQuestion.getLibraryId());
		assertEquals(q.getQuestion_content(), responseQuestion.getQuestionValue());
		
		questionService.deleteQuestion(q);
		assertFalse(questionService.doesQuestionExist(q.getId()));
	}
	
	@Test
	public void updateQuestionContentTest() throws JsonParseException, JsonMappingException, IOException {
		Question q = questionService.saveQuestion(new Question("Test Question", 1, 23));
		
		RestAssured.port = 8763;
		RequestSpecification request = RestAssured.given();
		request.formParam("content", "What is 5 + 5?");
		
		Response response = request.put("/question/update/" + q.getId());
		
		assertEquals(200, response.getStatusCode());
		QuestionDTO responseQuestion = new ObjectMapper().readValue(response.asString(), QuestionDTO.class);
		
		assertEquals(q.getId(), responseQuestion.getQuestionId());
		assertEquals(q.getDifficulty(), responseQuestion.getDifficulty());
		assertEquals(q.getLibrary_id(), responseQuestion.getLibraryId());
		assertEquals("What is 5 + 5?", responseQuestion.getQuestionValue());
		
		questionService.deleteQuestion(questionService.getQuestion(responseQuestion.getQuestionId()));
	}
	
	@Test
	public void updateQuestionDifficultyTest() throws JsonParseException, JsonMappingException, IOException {
		Question q = questionService.saveQuestion(new Question("Test Question", 1, 27));
		
		RestAssured.port = 8763;
		RequestSpecification request = RestAssured.given();
		
		Response response = request.put("/question/update/" + q.getId() + "/5");
		
		assertEquals(200, response.getStatusCode());
		QuestionDTO responseQuestion = new ObjectMapper().readValue(response.asString(), QuestionDTO.class);
		
		assertEquals(q.getId(), responseQuestion.getQuestionId());
		assertEquals(new Integer(5)	, responseQuestion.getDifficulty());
		assertEquals(q.getLibrary_id(), responseQuestion.getLibraryId());
		assertEquals(q.getQuestion_content(), responseQuestion.getQuestionValue());
		
		questionService.deleteQuestion(questionService.getQuestion(responseQuestion.getQuestionId()));
	}
}

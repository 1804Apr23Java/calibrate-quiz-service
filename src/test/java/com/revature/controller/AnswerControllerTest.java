package com.revature.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.DTO.AnswerDTO;
import com.revature.beans.Answer;
import com.revature.beans.Question;
import com.revature.service.AnswerService;
import com.revature.service.QuestionService;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AnswerControllerTest {

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private AnswerService answerService;
	
	@Test
	public void getAnswerTest() throws JsonParseException, JsonMappingException, IOException {
		Question q = questionService.saveQuestion(new Question("What is 5 + 5?", 1, 189));
		Answer a = answerService.saveAnswer(new Answer("10", true, q));
		
		RestAssured.port = 8763;
		RequestSpecification request = RestAssured.given();
		Response response = request.get("/answer/" + a.getId());
		
		AnswerDTO answer = new ObjectMapper().readValue(response.asString(), AnswerDTO.class);
		assertEquals(200, response.getStatusCode());
		assertEquals("10", answer.getAnswer_content());
		assertEquals(q.getId(), answer.getQuestionId());
		
		answerService.deleteAnswer(a);
		questionService.deleteQuestion(q);
	}
	
	
}

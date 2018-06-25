package com.revature.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.service.QuestionService;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT)
public class QuestionControllerTest {
	
	@Autowired QuestionService questionService;
	
	@Test
	public void addQuestionEndpointTest() throws JSONException {
		JSONObject requestBody = new JSONObject();
		requestBody.put("content", "What is the capital of Australia");
		requestBody.put("difficulty", 1);
		requestBody.put("library_id", 2);
		
		RestAssured.port = 8763;
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.body(requestBody.toString());
		
		Response response = request.post("/question/add");
		System.out.println(response.getBody().asString());
	}

}

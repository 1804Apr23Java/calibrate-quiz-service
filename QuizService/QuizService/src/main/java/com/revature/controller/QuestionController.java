package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.DTO.QuestionDTO;
import com.revature.service.QuestionService;

@CrossOrigin
@RestController
@RequestMapping("/account")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/{id}")
	public ResponseEntity<QuestionDTO> getQuestion(@PathVariable int id) {
		return new ResponseEntity<QuestionDTO>(new QuestionDTO(questionService.getQuestion(id)), HttpStatus.OK);
	}
	
	@PostMapping("/update/difficulty")
	public ResponseEntity<QuestionDTO> updateQuestionDifficulty(@RequestParam int question_id, @RequestParam int difficulty) {
		return new ResponseEntity<QuestionDTO>(new QuestionDTO(questionService.updateQuestionDifficulty(question_id, difficulty)), HttpStatus.OK);
	}
	
	@PostMapping("/update/content")
	public ResponseEntity<QuestionDTO> updateQuestionContent(@RequestParam int question_id, @RequestParam String content) {
		return new ResponseEntity<QuestionDTO>(new QuestionDTO(questionService.updateQuestionContent(question_id, content)), HttpStatus.OK);
	}
}

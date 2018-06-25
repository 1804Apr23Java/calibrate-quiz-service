package com.revature.controller;

import java.util.Set;

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

import com.revature.beans.Answer;
import com.revature.beans.Question;
import com.revature.service.AnswerService;
import com.revature.service.QuestionService;

@RestController
@CrossOrigin
@RequestMapping("/answer")
public class AnswerController {
	
	@Autowired AnswerService answerService;
	
	@Autowired QuestionService questionService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Answer> getAnswer(@PathVariable int id) {
		Answer a = answerService.getAnswer(id);
		return new ResponseEntity<Answer>(a, HttpStatus.OK);
	}

	@GetMapping("/question/{id}")
	public ResponseEntity<Set<Answer>> getAnswersByQuestionId(@PathVariable int id) {
		Set<Answer> answers = answerService.getAnswersByQuestionId(id);
		return new ResponseEntity<Set<Answer>>(answers, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Answer> addAnswer(@RequestParam String content, @RequestParam boolean isCorrect, @RequestParam int question_id) {
		Question q = questionService.getQuestion(question_id);
		Answer a = answerService.saveAnswer(new Answer(content, isCorrect, q));
		return new ResponseEntity<Answer>(a, HttpStatus.OK);
	}
}

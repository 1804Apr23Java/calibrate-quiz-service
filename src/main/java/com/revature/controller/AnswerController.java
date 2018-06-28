package com.revature.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.DTO.AnswerDTO;
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
	public ResponseEntity<AnswerDTO> getAnswer(@PathVariable int id) {
		Answer a = answerService.getAnswer(id);
		return new ResponseEntity<AnswerDTO>(new AnswerDTO(a), HttpStatus.OK);
	}

	@GetMapping("/question/{id}")
	public ResponseEntity<Set<AnswerDTO>> getAnswersByQuestionId(@PathVariable int id) {
		Set<Answer> answers = answerService.getAnswersByQuestionId(id);
		Set<AnswerDTO> ans = new HashSet<>();
		answers.forEach((e) -> { ans.add(new AnswerDTO(e)); });
		return new ResponseEntity<Set<AnswerDTO>>(ans, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<AnswerDTO> addAnswer(@RequestParam String content, @RequestParam boolean isCorrect, @RequestParam int question_id) {
		Question q = questionService.getQuestion(question_id);
		Answer a = answerService.saveAnswer(new Answer(content, isCorrect, q));
		return new ResponseEntity<AnswerDTO>(new AnswerDTO(a), HttpStatus.OK);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<AnswerDTO> editAnswer(@PathVariable int id, @RequestParam String value, @RequestParam boolean isCorrect) {
		answerService.updateAnswerContent(id, value);
		answerService.updateAnswerIsCorrect(id, isCorrect);
		return new ResponseEntity<AnswerDTO>(new AnswerDTO(answerService.getAnswer(id)), HttpStatus.OK);
	}
}

package com.revature.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.DTO.QuestionDTO;
import com.revature.beans.Question;
import com.revature.service.QuestionService;

@CrossOrigin
@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/lib/{library_id}")
	public ResponseEntity<Set<Question>> getQuestionsByLibraryId(@PathVariable int library_id) {
		Set<Question> questions = questionService.getQuestionsByLibrary(library_id);
		return new ResponseEntity<Set<Question>>(questions, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<QuestionDTO> getQuestion(@PathVariable int id) {
		return new ResponseEntity<QuestionDTO>(new QuestionDTO(questionService.getQuestion(id)), HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}/{difficulty}")
	public ResponseEntity<QuestionDTO> updateQuestionDifficulty(@PathVariable int question_id, @PathVariable int difficulty) {
		return new ResponseEntity<QuestionDTO>(new QuestionDTO(questionService.updateQuestionDifficulty(question_id, difficulty)), HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}/content")
	public ResponseEntity<QuestionDTO> updateQuestionContent(@PathVariable int question_id, @RequestBody String content) {
		return new ResponseEntity<QuestionDTO>(new QuestionDTO(questionService.updateQuestionContent(question_id, content)), HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<QuestionDTO> addQuestion(@RequestParam String content, @RequestParam int difficulty, @RequestParam int library_id) {
		Question q = questionService.saveQuestion(new Question(content, difficulty, library_id));
		QuestionDTO qDTO = new QuestionDTO(q);
		return new ResponseEntity<QuestionDTO>(qDTO, HttpStatus.OK);
	}
}

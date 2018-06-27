package com.revature.controller;

import java.util.List;

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

import com.revature.beans.Quiz;
import com.revature.service.QuizService;

@CrossOrigin
@RestController
@RequestMapping("/quiz")
public class QuizController {

	@Autowired QuizService quizService;
	
	@GetMapping("/generate")
	public ResponseEntity<Quiz> generateQuiz(@RequestParam List<Integer> libraryIds, @RequestParam String name, @RequestParam int numQuestions) {
		return new ResponseEntity<Quiz>(quizService.generateQuiz(name, libraryIds, numQuestions), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Quiz> getQuizById(@PathVariable int id) {
		return new ResponseEntity<Quiz>(quizService.getQuiz(id), HttpStatus.OK);
	}
}

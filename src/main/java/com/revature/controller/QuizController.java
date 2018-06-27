package com.revature.controller;

import java.util.HashSet;
import com.revature.DTO.QuestionDTO;
import java.util.List;
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

import com.revature.DTO.QuizDTO;
import com.revature.beans.Quiz;
import com.revature.service.QuestionService;
import com.revature.service.QuizService;

@CrossOrigin
@RestController
@RequestMapping("/quiz")
public class QuizController {
	@Autowired 
	private QuestionService questionService;

	@Autowired 
	private QuizService quizService;
	
	@GetMapping("/generate")
	public ResponseEntity<QuizDTO> generateQuiz(@RequestParam List<Integer> libraryIds, @RequestParam String name, @RequestParam int numQuestions) {
		Quiz q = quizService.generateQuiz(name, libraryIds, numQuestions);
		Set<QuestionDTO> ggg = new HashSet<QuestionDTO>();
		q.getQuestions().forEach((e) -> { ggg.add(new QuestionDTO(e)); });
 		QuizDTO qq = new QuizDTO(q.getId(), q.getName(), ggg);
		return new ResponseEntity<QuizDTO>(qq, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<QuizDTO> getQuizById(@PathVariable int id) {
		Quiz q = quizService.getQuiz(id);
		Set<QuestionDTO> g = new HashSet<>();
		q.getQuestions().forEach((e) -> { g.add(new QuestionDTO(e)); });
		
		QuizDTO asd = new QuizDTO(q.getId(), q.getName(), g);
		return new ResponseEntity<QuizDTO>(asd, HttpStatus.OK);
	}
}

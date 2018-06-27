package com.revature.controller;

import java.util.HashSet;
import com.revature.DTO.AnswerDTO;
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
import com.revature.service.AnswerService;
import com.revature.service.QuestionService;

@CrossOrigin
@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired 
	private AnswerService answerService;
	
	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/lib/{library_id}")
	public ResponseEntity<Set<QuestionDTO>> getQuestionsByLibraryId(@PathVariable int library_id) {
		Set<Question> questions = questionService.getQuestionsByLibrary(library_id);
		Set<QuestionDTO> questionDTOs = new HashSet<>();
		questions.forEach((e) -> {
			QuestionDTO dto = new QuestionDTO(e);
			
			Set<AnswerDTO> ansd = new HashSet<AnswerDTO>();
			answerService.getAnswersByQuestion(e).forEach((etd) -> {
				ansd.add(new AnswerDTO(etd));
			});
			dto.setAnswers(ansd);
			
			questionDTOs.add(new QuestionDTO(e)); 
		});
		return new ResponseEntity<Set<QuestionDTO>>(questionDTOs, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<QuestionDTO> getQuestion(@PathVariable int id) {
		return new ResponseEntity<QuestionDTO>(new QuestionDTO(questionService.getQuestion(id)), HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}/{difficulty}")
	public ResponseEntity<QuestionDTO> updateQuestionDifficulty(@PathVariable int id, @PathVariable int difficulty) {
		return new ResponseEntity<QuestionDTO>(new QuestionDTO(questionService.updateQuestionDifficulty(id, difficulty)), HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<QuestionDTO> updateQuestionContent(@PathVariable int id, @RequestParam String content) {
		return new ResponseEntity<QuestionDTO>(new QuestionDTO(questionService.updateQuestionContent(id, content)), HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<QuestionDTO> addQuestion(@RequestParam String content, @RequestParam int difficulty, @RequestParam int library_id) {
		Question q = questionService.saveQuestion(new Question(content, difficulty, library_id));
		
		QuestionDTO dto = new QuestionDTO(q);
		
		Set<AnswerDTO> ansd = new HashSet<AnswerDTO>();
		answerService.getAnswersByQuestion(q).forEach((etd) -> {
			ansd.add(new AnswerDTO(etd));
		});
		dto.setAnswers(ansd);
		
		return new ResponseEntity<QuestionDTO>(dto, HttpStatus.OK);
	}
}

package com.revature.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Question;
import com.revature.beans.Quiz;
import com.revature.repository.QuestionRepository;
import com.revature.repository.QuizRepository;

@Service
public class QuizService {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private QuizRepository quizRepository;
	
	public Quiz getQuiz(Integer id) {
		return quizRepository.findById(id).get();
	}

	public Quiz updateQuizName(Integer id, String name) {
		Quiz q = quizRepository.findById(id).get();
		q.setName(name);
		return quizRepository.save(q);
	}
	
	public Quiz saveQuiz(Quiz q) {
		return quizRepository.save(q);
	}
	
	public void deleteQuiz(Quiz q) {
		quizRepository.delete(q);
	}
	
	public boolean doesQuizExist(Integer id) {
		return quizRepository.existsById(id);
	}
	
	public Quiz generateQuiz(String name, List<Integer> libraryIds, int numQuestions) {
		List<Question> possibleQuestions = new ArrayList<>();
		libraryIds.forEach((e) -> { possibleQuestions.addAll(questionRepository.findBylibraryId(e)); });
		
		if(possibleQuestions.size() < numQuestions) return null;
		
		Collections.shuffle(possibleQuestions);
		
		Set<Question> questions = new HashSet<>(possibleQuestions.subList(0, numQuestions));
		Quiz newQuiz = new Quiz(name, questions);
		return quizRepository.save(newQuiz);
	}
}

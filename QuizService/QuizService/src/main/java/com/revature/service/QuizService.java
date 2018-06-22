package com.revature.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Question;
import com.revature.beans.Quiz;
import com.revature.repository.QuizRepository;

@Service
public class QuizService {
	
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
}

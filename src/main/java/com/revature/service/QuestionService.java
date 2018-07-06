package com.revature.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Answer;
import com.revature.beans.Question;
import com.revature.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	
	public Question getQuestion(Integer id) {
		return questionRepository.findById(id).get();
	}
	
	public Question updateQuestionContent(Integer id, String content) {
		Question q = questionRepository.findById(id).get();
		q.setQuestion_content(content);
		return questionRepository.save(q);
	}
	
	public Question updateQuestionDifficulty(Integer id, Integer difficulty) {
		Question q = questionRepository.findById(id).get();
		q.setDifficulty(difficulty);
		return questionRepository.save(q);
	}
	
	public Question updateQuestionLibrary(Integer id, Integer libraryId) {
		Question q = questionRepository.findById(id).get();
		q.setLibrary_id(libraryId);
		return questionRepository.save(q);
	}
	
	public Question saveQuestion(int difficulty, String content, int libraryId) {
		Question q = new Question(content, difficulty, libraryId);
		q = questionRepository.save(q);
		return q;
	}
	
	public Question saveQuestion(Question q) {
		return questionRepository.save(q);
	}
	
	public boolean doesQuestionExist(Integer id) {
		return questionRepository.existsById(id);
	}
	
	public void deleteQuestion(Question q) {
		questionRepository.delete(q);
	}
	
	public Set<Question> getQuestionsByLibrary(Integer libraryId) {
		return questionRepository.findBylibraryId(libraryId);
	}
}

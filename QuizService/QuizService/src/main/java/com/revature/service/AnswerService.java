package com.revature.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Answer;
import com.revature.beans.Question;
import com.revature.repository.AnswerRepository;

@Service
public class AnswerService {

	@Autowired
	private AnswerRepository answerRepository;
	
	public Answer getAnswer(int id) {
		return answerRepository.findById(id).get();
	}
	
	public Answer updateAnswerContent(Integer id, String content) {
		Answer a = answerRepository.findById(id).get();
		a.setAnswer_content(content);
		return answerRepository.save(a);
	}
	
	public Answer updateAnswerIsCorrect(Integer id, boolean isCorrect) {
		Answer a = answerRepository.findById(id).get();
		a.setCorrect(isCorrect);
		return answerRepository.save(a);
	}
	
	public Answer updateAnswerQuestion(Integer id, Question q) {
		Answer a = answerRepository.findById(id).get();
		a.setQuestion(q);
		return answerRepository.save(a);
	}
	
	public Answer saveAnswer(Answer a) {
		return answerRepository.save(a);
	}
	
	public void deleteAnswer(Answer a) {
		answerRepository.delete(a);
	}
	
	public Set<Answer> getAnswersByQuuestion(Question q) {
		return answerRepository.findByQuestion(q);
	}
}

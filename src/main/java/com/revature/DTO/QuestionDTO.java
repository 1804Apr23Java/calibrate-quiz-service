package com.revature.DTO;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.beans.Answer;
import com.revature.beans.Question;
import com.revature.service.AnswerService;

public class QuestionDTO implements Serializable {
	
	@Autowired
	private AnswerService answerService;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2324070295258377882L;
	private Integer questionId;
	private String value;
	private Integer difficulty;
	private Integer libraryId;
	
	private Set<AnswerDTO> answers;
	
	public QuestionDTO() {
	}
	
	public QuestionDTO(Question q) {
		this.questionId = q.getId();
		this.value = q.getQuestion_content();
		this.difficulty = q.getDifficulty();
		this.libraryId = q.getLibrary_id();
		
		Set<AnswerDTO> a = new HashSet<>();
		for(Answer ans: answerService.getAnswersByQuestion(q)) {
			a.add(new AnswerDTO(ans));
		}
	}
	
	public Set<AnswerDTO> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<AnswerDTO> answers) {
		this.answers = answers;
	}

	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}

	public Integer getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(Integer libraryId) {
		this.libraryId = libraryId;
	}
	
}

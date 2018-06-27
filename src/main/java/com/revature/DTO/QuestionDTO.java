package com.revature.DTO;

import java.io.Serializable;
import java.util.Set;

import com.revature.beans.Answer;
import com.revature.beans.Question;

public class QuestionDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2324070295258377882L;
	private Integer questionId;
	private String questionValue;
	private Integer difficulty;
	private Integer libraryId;
	
	public QuestionDTO() {
	}
	
	public QuestionDTO(Question q) {
		this.questionId = q.getId();
		this.questionValue = q.getQuestion_content();
		this.difficulty = q.getDifficulty();
		this.libraryId = q.getLibrary_id();
	}
	
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	public String getQuestionValue() {
		return questionValue;
	}
	public void setQuestionValue(String questionValue) {
		this.questionValue = questionValue;
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

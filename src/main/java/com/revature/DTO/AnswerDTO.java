package com.revature.DTO;

import com.revature.beans.Question;

public class AnswerDTO {
	
	private Long answer_id;
	private String answer_content;
	private boolean isCorrect;
	private Question question;
	
	public AnswerDTO(Long answer_id, String answer_content, boolean isCorrect, Question question) {
		super();
		this.answer_id = answer_id;
		this.answer_content = answer_content;
		this.isCorrect = isCorrect;
		this.question = question;
	}

	public Long getAnswer_id() {
		return answer_id;
	}

	public void setAnswer_id(Long answer_id) {
		this.answer_id = answer_id;
	}

	public String getAnswer_content() {
		return answer_content;
	}

	public void setAnswer_content(String answer_content) {
		this.answer_content = answer_content;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
}

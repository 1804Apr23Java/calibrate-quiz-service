package com.revature.DTO;

import com.revature.beans.Answer;
import com.revature.beans.Question;

public class AnswerDTO {
	
	private Long answer_id;
	private String answer_content;
	private boolean isCorrect;
	private Integer questionId;
	
	public AnswerDTO() {}
	
	public AnswerDTO(Answer a) {
		this.answer_id = a.getId().longValue();
		this.answer_content = a.getAnswer_content();
		this.isCorrect = a.isCorrect();
		this.questionId = a.getQuestion().getId();
	}
	
	public AnswerDTO(Long answer_id, String answer_content, boolean isCorrect, Integer questionId) {
		super();
		this.answer_id = answer_id;
		this.answer_content = answer_content;
		this.isCorrect = isCorrect;
		this.questionId = questionId;
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

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer_content == null) ? 0 : answer_content.hashCode());
		result = prime * result + ((answer_id == null) ? 0 : answer_id.hashCode());
		result = prime * result + (isCorrect ? 1231 : 1237);
		result = prime * result + ((questionId == null) ? 0 : questionId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnswerDTO other = (AnswerDTO) obj;
		if (answer_content == null) {
			if (other.answer_content != null)
				return false;
		} else if (!answer_content.equals(other.answer_content))
			return false;
		if (answer_id == null) {
			if (other.answer_id != null)
				return false;
		} else if (!answer_id.equals(other.answer_id))
			return false;
		if (isCorrect != other.isCorrect)
			return false;
		if (questionId == null) {
			if (other.questionId != null)
				return false;
		} else if (!questionId.equals(other.questionId))
			return false;
		return true;
	}
	
}

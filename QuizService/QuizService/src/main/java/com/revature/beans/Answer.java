package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ForeignKey;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ANSWER")
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "answerSequence")
	@SequenceGenerator(allocationSize = 1, name = "answerSequence", sequenceName = "SQ_ANSWER_PK")
	@Column(name = "a_id")
	private Integer id;
	
	@Column(name = "ANSWER_CONTENT")
	private String answer_content;
	
	@Column(name = "IS_CORRECT", nullable = false)
	private boolean isCorrect;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id", nullable = false, foreignKey = @ForeignKey(name = "FK_ANSWER_QUESTION"))
	private Question question;
	
	public Answer() {}

	public Answer(Integer id, String answer_content, boolean isCorrect, Question question) {
		super();
		this.id = id;
		this.answer_content = answer_content;
		this.isCorrect = isCorrect;
		this.question = question;
	}

	public Answer(String answer_content, boolean isCorrect, Question question) {
		super();
		this.answer_content = answer_content;
		this.isCorrect = isCorrect;
		this.question = question;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer_content == null) ? 0 : answer_content.hashCode());
		result = prime * result + (isCorrect ? 1231 : 1237);
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
		Answer other = (Answer) obj;
		if (answer_content == null) {
			if (other.answer_content != null)
				return false;
		} else if (!answer_content.equals(other.answer_content))
			return false;
		if (isCorrect != other.isCorrect)
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

package com.revature.DTO;

import java.util.Set;

import com.revature.beans.Answer;
import com.revature.beans.Question;

public class QuestionDTO {
	private Integer question_id;
	private String question_content;
	private Integer difficulty;
	private Integer library_id;
	
	private Set<Answer> answers;
	
	public QuestionDTO(Question q) {
		this.question_id = q.getId();
		this.question_content = q.getQuestion_content();
		this.difficulty = q.getDifficulty();
		this.library_id = q.getLibrary_id();
	}

	public Integer getLibrary_id() {
		return library_id;
	}

	public void setLibrary_id(Integer library_id) {
		this.library_id = library_id;
	}

	public QuestionDTO(Integer question_id, String question_content, Integer difficulty, Set<Answer> answers) {
		super();
		this.question_id = question_id;
		this.question_content = question_content;
		this.difficulty = difficulty;
		this.answers = answers;
	}

	public Integer getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(Integer question_id) {
		this.question_id = question_id;
	}

	public String getQuestion_content() {
		return question_content;
	}

	public void setQuestion_content(String question_content) {
		this.question_content = question_content;
	}

	public Integer getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}

	public Set<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}
}

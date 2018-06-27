package com.revature.DTO;

import java.util.Set;

import com.revature.beans.Quiz;

public class QuizDTO {
	private Integer id;
	private String name;
	private Set<QuestionDTO> questions;
	
	public QuizDTO() {
		super();
	}
	
	public QuizDTO(Quiz q) {
		this.id = q.getId();
		this.name = q.getName();
	}
	
	public QuizDTO(Integer id, String name, Set<QuestionDTO> questions) {
		super();
		this.id = id;
		this.name = name;
		this.questions = questions;
	}

	public QuizDTO(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<QuestionDTO> getQuestions() {
		return questions;
	}
	public void setQuestions(Set<QuestionDTO> questions) {
		this.questions = questions;
	}
	
	
	
}

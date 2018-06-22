package com.revature.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "questionSequence")
	@SequenceGenerator(allocationSize = 1, name = "questionSequence", sequenceName = "SQ_QUESTION_PK")
	@Column(name = "QUESTION_ID")
	private Integer id;
	

	@Column(name="QUESTION_CONTENT", nullable = false)
	private String question_content;
	
	@Column(name="DIFFICULTY", nullable = false)
	private Integer difficulty;
	
	@OneToMany(targetEntity=Answer.class, cascade = CascadeType.ALL, mappedBy="question", fetch = FetchType.EAGER)
	private Set<Answer> answers;
	
	@Column(name="LIBRARY_ID")
	private Integer library_id;
	
	public Question(String question_content, Integer difficulty, Integer library_id) {
		super();
		this.question_content = question_content;
		this.difficulty = difficulty;
		this.library_id = library_id;
	}
	
	public Question(String question_content, Integer difficulty, Set<Answer> answers, Integer library_id) {
		super();
		this.question_content = question_content;
		this.difficulty = difficulty;
		this.answers = answers;
		this.library_id = library_id;
	}

	public Question(Integer id, String question_content, Integer difficulty, Set<Answer> answers, Integer library_id) {
		super();
		this.id = id;
		this.question_content = question_content;
		this.difficulty = difficulty;
		this.answers = answers;
		this.library_id = library_id;
	}

	public Integer getLibrary_id() {
		return library_id;
	}

	public void setLibrary_id(Integer library_id) {
		this.library_id = library_id;
	}

	public Question() {}

	public Question(Integer id, String question_content, Integer difficulty, Set<Answer> answers) {
		super();
		this.id = id;
		this.question_content = question_content;
		this.difficulty = difficulty;
		this.answers = answers;
	}

	public Question(String question_content, Integer difficulty, Set<Answer> answers) {
		super();
		this.question_content = question_content;
		this.difficulty = difficulty;
		this.answers = answers;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

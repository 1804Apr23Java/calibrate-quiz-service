package com.revature.DTO;

import java.util.List;

public class GenerateQuizDTO {
	private String name;
	private List<Integer> libraryIds;
	private int numQuestions;
	
	
	
	public GenerateQuizDTO() {
		super();
	}
	public GenerateQuizDTO(String string, List<Integer> list, int i) {
		this.name = string;
		this.libraryIds = list;
		this.numQuestions = i;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Integer> getLibraryIds() {
		return libraryIds;
	}
	public void setLibraryIds(List<Integer> libraryIds) {
		this.libraryIds = libraryIds;
	}
	public int getNumQuestions() {
		return numQuestions;
	}
	public void setNumQuestions(int numQuestions) {
		this.numQuestions = numQuestions;
	}
	
	
}

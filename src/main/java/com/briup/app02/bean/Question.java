package com.briup.app02.bean;

public class Question {
	private Long id;
	private String name;
	private String questionType;
	public Question() {
		super();
	}
	public Question(Long id, String name, String questionType) {
		super();
		this.id = id;
		this.name = name;
		this.questionType = questionType;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	
}

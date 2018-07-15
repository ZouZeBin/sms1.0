package com.briup.app02.bean;

public class Survey {
	private Long id;
	private String state;
	private double average;
	private String surveyDate;
	private Long questionnaire_id;
	private Long clazz_id;
	private Long user_id;
	private Long course_id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	public String getSurveyDate() {
		return surveyDate;
	}
	public void setSurveyDate(String surveyDate) {
		this.surveyDate = surveyDate;
	}
	public Long getQuestionnaire_id() {
		return questionnaire_id;
	}
	public void setQuestionnaire_id(Long questionnaire_id) {
		this.questionnaire_id = questionnaire_id;
	}
	public Long getClazz_id() {
		return clazz_id;
	}
	public void setClazz_id(Long clazz_id) {
		this.clazz_id = clazz_id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public Long getCourse_id() {
		return course_id;
	}
	public void setCourse_id(Long course_id) {
		this.course_id = course_id;
	}
	
	
}

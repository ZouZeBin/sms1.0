package com.briup.app02.vm;

import com.briup.app02.bean.Clazz;
import com.briup.app02.bean.Course;
import com.briup.app02.bean.Questionnaire;
import com.briup.app02.bean.User;

public class SurveyVM {
	private Long id;
	private String state;
	private double average;
	private String surveydate;
	private Questionnaire questionnaire;
	private Clazz clazz;
	private User user;
	private Course course;
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
	public String getSurveydate() {
		return surveydate;
	}
	public void setSurveydate(String surveydate) {
		this.surveydate = surveydate;
	}
	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}
	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}
	public Clazz getClazz() {
		return clazz;
	}
	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
}

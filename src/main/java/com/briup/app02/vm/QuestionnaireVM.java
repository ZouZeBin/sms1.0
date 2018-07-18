package com.briup.app02.vm;

import com.briup.app02.bean.Survey;

public class QuestionnaireVM {
	
	private Long id;
	
	private String name;
	
	private String description;
	
	private String createdate;
	
	private QqVM qqVM;
	
	private Survey survey;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public QqVM getQqVM() {
		return qqVM;
	}

	public void setQqVM(QqVM qqVM) {
		this.qqVM = qqVM;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

}

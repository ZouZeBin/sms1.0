package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Survey;

public interface SurveyMapper {
	List<Survey> findAll();
	
	Survey findById(long id);
	
	void save(Survey survey);
	
	void update(Survey survey);
}

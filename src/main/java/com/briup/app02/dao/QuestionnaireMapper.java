package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Questionnaire;

public interface QuestionnaireMapper {
	
	List<Questionnaire> findAll();

	Questionnaire findById(long id);

	void save(Questionnaire questionnaire);

	void update(Questionnaire questionnaire);

	void deleteById(long id);

}

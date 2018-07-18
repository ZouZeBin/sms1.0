package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Answer;

public interface AnswerMapper {
	
	List<Answer> findAll();

	void save(Answer answer);
}

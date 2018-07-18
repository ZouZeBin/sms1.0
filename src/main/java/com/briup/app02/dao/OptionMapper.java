package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Option;

public interface OptionMapper {
	/*
	 * 查看选项，删除选项，更新选项三项功能
	 * 
	 */
	List<Option> findAll();

	List<Option> findByQuestionId(long id);

	void save(Option option);

	void update(Option option);
}

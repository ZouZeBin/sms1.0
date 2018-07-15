package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.School;

public interface SchoolMapper {
	//查找所有的学校
	List<School> findAll();
	
	//通过id查找学校
	School findById(Long id);
	
	//保存学校
	void save (School school);
	//更新学校
	void update(School school);
	//删除学校
	void deleteById(long id);
	
	
	
}

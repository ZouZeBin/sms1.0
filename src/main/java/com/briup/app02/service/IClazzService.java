package com.briup.app02.service;

import java.util.List;

import com.briup.app02.bean.Clazz;

public interface IClazzService {

	
	//查询所有的班级
	List<Clazz> findAll() throws Exception;
	
	//通过ID查询班级
	Clazz findById(long id) throws Exception;
	
	void save(Clazz clazz) throws Exception;
	
	void update(Clazz clazz) throws Exception;
	
	void deleteById(long id) throws Exception;
	
}

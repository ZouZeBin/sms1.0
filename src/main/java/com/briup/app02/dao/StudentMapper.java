package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Student;

public interface StudentMapper {
	
	List<Student> findAll();
	
	Student findById(long id);
	
	//保存
	void save(Student student);
	//修改
	void update(Student student);
	
	void delete(long id);
	
}

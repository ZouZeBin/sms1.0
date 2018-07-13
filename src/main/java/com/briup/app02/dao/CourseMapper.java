package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Course;

public interface CourseMapper {
	
	List<Course> findAllC();
	
	Course findCById(long id);
}

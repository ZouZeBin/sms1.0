package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Course;



public interface CourseMapper {

		List<Course> findAll();
		
		Course findById(Long id);
		
		void save (Course course);
	
		void update(Course course);
		void deleteById(long id);
		
}

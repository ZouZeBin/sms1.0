package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Course;
import com.briup.app02.dao.CourseMapper;
import com.briup.app02.service.ICourseService;

@Service
public  class CourseServiceImpl implements ICourseService{
	@Autowired
	private CourseMapper courseMapper;

	@Override
	public List<Course> findAllC() throws Exception {
		
		List <Course> list = courseMapper.findAllC();

		return list;
	}
	
	@Override
	public Course findCById(long id) throws Exception{
		Course course = courseMapper.findCById(id);
		return course;
	}




}

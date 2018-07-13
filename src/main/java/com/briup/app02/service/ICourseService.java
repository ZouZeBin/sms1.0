package com.briup.app02.service;

import java.util.List;

import com.briup.app02.bean.Course;

public interface ICourseService {
	List<Course> findAllC() throws Exception;

	Course findCById(long id) throws Exception;


}

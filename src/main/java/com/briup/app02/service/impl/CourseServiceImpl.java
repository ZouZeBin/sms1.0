package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Course;
import com.briup.app02.dao.CourseMapper;
import com.briup.app02.service.ICourseService;

@Service
public class CourseServiceImpl implements ICourseService {
	@Autowired
	private CourseMapper courseMapper;

	@Override
	public List<Course> findAll() throws Exception {
		List <Course> course = courseMapper.findAll();
		if(course != null){
			return course;
		}
		else{
			throw new Exception("未添加任何课程！");
		}
		
	}

	@Override
	public Course findById(long id) throws Exception {
		Course course = courseMapper.findById(id);
		if(course != null){
			return courseMapper.findById(id);
			
		}else{
			throw new Exception("对不起，您要查找的课程不存在！");
			
		}
		
	}

	@Override
	public void save(Course course) throws Exception {
		if(course.getName() != null){
			courseMapper.save(course);
		}else{
			throw new Exception("保存失败！请联系管理员。");
		}
		
	}

	@Override
	public void update(Course course) throws Exception {
		Course newCourse = courseMapper.findById(course.getId());
		if(newCourse != null){
			courseMapper.update(course);
		}else{
			throw new Exception("更新失败，您要更新的课程不存在！");
			
		}
	}


	@Override
	public void deleteById(long id) throws Exception {
		Course course = courseMapper.findById(id);
		if(course != null){
			courseMapper.deleteById(id);
		}else{
			throw new Exception("删除失败，不存在该课程！");
		}
		
	}
	
	
	
}

package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Course;
import com.briup.app02.service.ICourseService;
import com.briup.app02.util.MsgResponse;

@RestController
@RequestMapping("/Course")
public class CourseController {
	@Autowired
	private ICourseService courseService;

	@GetMapping("findAllCourse")
	public MsgResponse findAllCourse(){
		try{
			List<Course> list = courseService.findAllC();

			return MsgResponse.success("查询成功", list);
		}catch(Exception e){
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@GetMapping("findCourseById")
	public MsgResponse findCourseById(long id){
		try {
			Course course = courseService.findCById(id);
			
			return MsgResponse.success("查询成功", course);
		} catch (Exception e) {
			e.printStackTrace();	
			return MsgResponse.error(e.getMessage());
		}
	}

}

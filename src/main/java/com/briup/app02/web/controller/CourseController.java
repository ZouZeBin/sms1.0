package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Course;
import com.briup.app02.service.ICourseService;
import com.briup.app02.util.MsgResponse;

@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private ICourseService courseService;

	/**
	 * @author 胡杰
	 * 通过创建MsgResponse方法 ，若查询成功，则返回"查询成功！"，并将所查询的班级返回
	 * 若查询不成功，则捕获抛出的新异常
	 * 
	 * */
	
	
		@GetMapping("findAll")
		public MsgResponse findAll(){
			try{
				List<Course> list = courseService.findAll();
				return MsgResponse.success("查询成功！", list);

			}catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());

			}
		}
		
		
		@GetMapping("findById")
		public MsgResponse findById(long id){
			try {
				Course course = courseService.findById(id);
				return MsgResponse.success("查询成功！", course);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
		

		@PostMapping("save")
		public MsgResponse save(Course course){
			try {
				courseService.save(course);
				return MsgResponse.success("保存成功！", null);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
				
			}
		}
		
	
		@PostMapping("update")
		public MsgResponse update(Course course){
			try {
				courseService.update(course);
				return MsgResponse.success("更新成功！", null);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
		
	
		@PostMapping("deleteById")
		public MsgResponse deleteById(long id){
			try {
				courseService.deleteById(id);
				return MsgResponse.success("删除成功", null);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}

	
}

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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="课程相关接口")
@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private ICourseService courseService;

	/**
	 * 
	 * 通过创建MsgResponse方法 ，若查询成功，则返回"查询成功！"，并将所查询的班级返回
	 * 若查询不成功，则捕获抛出的新异常
	 * 
	 * */
	
	    @ApiOperation(value="查找课程全部信息")
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
		
	    @ApiOperation(value="通过课程ID查找全部课程信息")
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
		
	    @ApiOperation(value="插入课程信息")
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
		
	    @ApiOperation(value="更新课程信息")
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
		
	    @ApiOperation(value="通过课程ID删除课程信息")
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

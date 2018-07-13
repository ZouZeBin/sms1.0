package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Student;
import com.briup.app02.service.IStudentService;
import com.briup.app02.util.MsgResponse;

@RestController
@RequestMapping("/student")

public class StudentController {
	//注入studentService的实例
	@Autowired
	private IStudentService studentService;

	@GetMapping("findAllStudent")
	public MsgResponse findAllStudent(){

		try {
			List<Student> list = studentService.findAll();
			return MsgResponse.success("查找成功", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}
	@GetMapping("findById")
	public MsgResponse findById(long id){

		try {
			Student student= studentService.findById(id);
			return MsgResponse.success("查找成功", student);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

	@PostMapping("updateStudent")
	public MsgResponse updateStudent(Student student){
		try{
			studentService.update(student);
			return MsgResponse.success("更新成功！", null);

		}catch(Exception e){
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}


	}



	/**
	 * 保存学生信息
	 * @author 胡杰
	 * @param student
	 * @return
	 * */

	@PostMapping("saveStudent")
	public MsgResponse save(Student student){
		try {
			studentService.sava(student);
			return MsgResponse.success("保存成功！",null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		
		}
	}
	
	@PostMapping("deleteStudent")
	public MsgResponse delete(long id){
		try {
			studentService.delete(id);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		
		}
	}


}

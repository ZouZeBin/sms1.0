package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Student;
import com.briup.app02.dao.StudentMapper;
import com.briup.app02.service.IStudentService;

@Service
public  class StudentServiceImpl implements IStudentService{
	 @Autowired
	 private StudentMapper studentMapper;
	
	
	@Override
	public List<Student> findAll() throws Exception {
		//调用studentMapper查询所有学生
		List<Student> list=studentMapper.findAll();
		if(list!=null){
			return list;
		}else{
			 throw new Exception("对不起，学生不存在！");
		}
		
	}
	

	

	@Override
	public Student findById(long id) throws Exception {
		// TODO Auto-generated method stub
		Student student=studentMapper.findById(id);
		if(student!=null){
			return  studentMapper.findById(id);
		}
		else{
			 throw new Exception("对不起，该学生不存在！");
		}
	}




	@Override
	public void sava(Student student) throws Exception {
		// TODO Auto-generated method stub
		if(student.getName()!=null){
			studentMapper.save(student);
		}else{
			throw new Exception("保存失败，请填写学生姓名！");
		}
	}
	
	//更新学生
	@Override
	public void update(Student student) throws Exception{
		Student newStudent=studentMapper.findById(student.getId());
		if(newStudent!=null){
			studentMapper.update(student);
		}else{
			throw new Exception("您要更新的学生ID不存在！");
		}
	}
	//删除学生
	@Override
	public void delete(long id) throws Exception{
		Student student=studentMapper.findById(id);
		if(student!=null){
			studentMapper.delete(id);
		}
		else{
			 throw new Exception("对不起，该学生不存在！");
		}
	}

}

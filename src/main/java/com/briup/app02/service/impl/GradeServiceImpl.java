package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Grade;
import com.briup.app02.dao.GradeMapper;
import com.briup.app02.service.IGradeService;

@Service
public class GradeServiceImpl implements IGradeService {

	@Autowired
	private GradeMapper gradeMapper;
	
	@Override
	public List<Grade> findAll() throws Exception {
		List <Grade> grade = gradeMapper.findAll();
		if(grade != null){
			return grade;
		}
		else{
			throw new Exception("不存在！");
		}
	}

	@Override
	public Grade findById(long id) throws Exception {
		Grade grade = gradeMapper.findById(id);
		if(grade != null){
			return gradeMapper.findById(id);
			
		}else{
			throw new Exception("对不起，您要查找的成绩不存在！");
			
		}
	}

	@Override
	public void save(Grade grade) throws Exception {
		if(grade.getName() != null){
			gradeMapper.save(grade);
		}else{
			throw new Exception("保存失败！请联系管理员。");
		}
				
	}

	@Override
	public void update(Grade grade) throws Exception {
		Grade newSchool = gradeMapper.findById(grade.getId());
		if(newSchool != null){
			gradeMapper.update(grade);
		}else{
			throw new Exception("更新失败，您要更新的成绩不存在！");
			
		}		
	}

	@Override
	public void deleteById(long id) throws Exception {
		Grade grade = gradeMapper.findById(id);
		if(grade != null){
			gradeMapper.deleteById(id);
		}else{
			throw new Exception("删除失败，不存在该id！");
		}		
	}

}

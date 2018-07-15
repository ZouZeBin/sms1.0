package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.School;
import com.briup.app02.dao.SchoolMapper;
import com.briup.app02.service.ISchoolService;

@Service
public class SchoolServiceImpl implements ISchoolService {
	@Autowired
	private SchoolMapper schoolMapper;
	
	@Override
	public List<School> findAll() throws Exception {
		List <School> school = schoolMapper.findAll();
		if(school != null){
			return school;
		}
		else{
			throw new Exception("未添加任何学校！");
		}
		
	}

	@Override
	public School findById(long id) throws Exception {
		School school = schoolMapper.findById(id);
		if(school != null){
			return schoolMapper.findById(id);
			
		}else{
			throw new Exception("对不起，您要查找的学校不存在！");
			
		}
		
	}

	@Override
	public void save(School school) throws Exception {
		if(school.getName() != null){
			schoolMapper.save(school);
		}else{
			throw new Exception("保存失败！请联系管理员。");
		}
		
	}

	@Override
	public void update(School school) throws Exception {
		School newSchool = schoolMapper.findById(school.getId());
		if(newSchool != null){
			schoolMapper.update(school);
		}else{
			throw new Exception("更新失败，您要更新的学校不存在！");
			
		}
	}


	@Override
	public void deleteById(long id) throws Exception {
		School school = schoolMapper.findById(id);
		if(school != null){
			schoolMapper.deleteById(id);
		}else{
			throw new Exception("删除失败，不存在该学校！");
		}
		
	}
	

}

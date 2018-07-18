package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Survey;
import com.briup.app02.dao.SurveyMapper;
import com.briup.app02.dao.extend.SurveyVMMapper;
import com.briup.app02.service.ISurveyService;
import com.briup.app02.vm.SurveyVM;

@Service
public class SurveyServiceImpl implements ISurveyService{
	@Autowired
	private SurveyMapper surveyMapper;
	@Autowired
	private SurveyVMMapper surveyVMMapper;
	
	@Override
	public List<Survey> findAll() throws Exception {
		List <Survey> survey = surveyMapper.findAll();
		if(survey != null){
			return survey;
		}
		else{
			throw new Exception("查找失败");
		}
	}

	@Override
	public Survey findById(long id) throws Exception {
		Survey survey = surveyMapper.findById(id);
		if(survey != null){
			return surveyMapper.findById(id);
			
		}else{
			throw new Exception("查找失败");
			
		}
	}

	@Override
	public void save(Survey survey) throws Exception {
		
			surveyMapper.save(survey);
		
				
	}

	@Override
	public void update(Survey survey) throws Exception {
		Survey newSurvey = surveyMapper.findById(survey.getId());
		if(newSurvey != null){
			surveyMapper.update(survey);
		}else{
			throw new Exception("更新失败");
			
		}		
	}

	@Override
	public List<SurveyVM> findAllSurveyVM() throws Exception {
		// TODO Auto-generated method stub
		return surveyVMMapper.findAllSurveyVM();
	}

	@Override
	public SurveyVM findByIdSurveyVM(long id) throws Exception {
		// TODO Auto-generated method stub
		SurveyVM s=surveyVMMapper.findByIdSurveyVM(id);
		if(s!=null){
			return s;
		}
		else{
			throw new Exception("您要查找的课调不存在！");
		}
	}


	
}

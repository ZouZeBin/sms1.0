package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Survey;
import com.briup.app02.dao.SurveyMapper;
import com.briup.app02.service.ISurveyService;

@Service
public class SurveyServiceImpl implements ISurveyService{
	@Autowired
	private SurveyMapper surveyMapper;
	
	
	@Override
	public List<Survey> findAll() throws Exception {
		List <Survey> survey = surveyMapper.findAll();
		if(survey != null){
			return survey;
		}
		else{
			throw new Exception("未添加任何用户！");
		}
	}

	@Override
	public Survey findById(long id) throws Exception {
		Survey survey = surveyMapper.findById(id);
		if(survey != null){
			return surveyMapper.findById(id);
			
		}else{
			throw new Exception("对不起，您要查找的用户不存在！");
			
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
			throw new Exception("更新失败，您要更新的用户不存在！");
			
		}		
	}


	
}

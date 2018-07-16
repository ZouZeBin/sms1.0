package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Questionnaire;
import com.briup.app02.dao.QuestionnaireMapper;
import com.briup.app02.service.IQuestionnaireService;

@Service
public class QuestionnaireServiceImpl implements IQuestionnaireService {
	@Autowired
	private QuestionnaireMapper questionnaireMapper;
	
	@Override
	public List<Questionnaire> findAll() throws Exception {
		List <Questionnaire> questionnaire = questionnaireMapper.findAll();
		if(questionnaire != null){
			return questionnaire;
		}
		else{
			throw new Exception("不存在！");
		}
	}

	@Override
	public Questionnaire findById(long id) throws Exception {
		Questionnaire grade = questionnaireMapper.findById(id);
		if(grade != null){
			return questionnaireMapper.findById(id);
			
		}else{
			throw new Exception("对不起，您要查找的调查问卷不存在！");
			
		}
	}

	@Override
	public void save(Questionnaire questionnaire) throws Exception {
		if(questionnaire.getName() != null){
			questionnaireMapper.save(questionnaire);
		}else{
			throw new Exception("保存失败！请联系管理员。");
		}
				
	}

	@Override
	public void update(Questionnaire questionnaire) throws Exception {
		Questionnaire newQuestionnaire = questionnaireMapper.findById(questionnaire.getId());
		if(newQuestionnaire != null){
			questionnaireMapper.update(questionnaire);
		}else{
			throw new Exception("更新失败，您要更新的调查问卷不存在！");
			
		}		
	}

	@Override
	public void deleteById(long id) throws Exception {
		Questionnaire questionnaire = questionnaireMapper.findById(id);
		if(questionnaire != null){
			questionnaireMapper.deleteById(id);
		}else{
			throw new Exception("删除失败，不存在该id！");
		}		
	}
}

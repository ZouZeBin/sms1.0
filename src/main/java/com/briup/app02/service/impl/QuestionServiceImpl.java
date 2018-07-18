package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Question;
import com.briup.app02.dao.QuestionMapper;
import com.briup.app02.dao.extend.QuestionVMMapper;
import com.briup.app02.service.IQuestionService;
import com.briup.app02.vm.QuestionVM;

@Service
public class QuestionServiceImpl implements IQuestionService{
	@Autowired
	private QuestionMapper questionMapper;
	@Autowired
	private QuestionVMMapper questionVMMapper;
	@Autowired
	
	@Override
	public List<Question> findAll() throws Exception {
		List <Question> question = questionMapper.findAll();
		if(question != null){
			return question;
		}
		else{
			throw new Exception("查找失败");
		}
	}
	
	@Override
	public List<QuestionVM> findAllQuestionVM() throws Exception {
		List <QuestionVM> questionVM = questionVMMapper.findAllQuestionVM();
		if(questionVM != null){
			return questionVM;
		}
		else{
			throw new Exception("查找失败");
		}
	}
	

	@Override
	public Question findById(long id) throws Exception {
		Question question = questionMapper.findById(id);
		if(question != null){
			return questionMapper.findById(id);
			
		}else{
			throw new Exception("查找失败");
			
		}
	}
	
	@Override
	public QuestionVM findByIdQuestionVM(long id) throws Exception {
		QuestionVM questionVM = questionVMMapper.findByIdQuestionVM(id);
		if(questionVM != null){
			return questionVMMapper.findByIdQuestionVM(id);
		}else{
			throw new Exception("查找失败");

		}
	}


	@Override
	public void save(Question question) throws Exception {
		if(question.getName() != null){
			questionMapper.save(question);
		}else{
			throw new Exception("保存失败");
		}
				
	}

	@Override
	public void update(Question question) throws Exception {
		Question newQuestion = questionMapper.findById(question.getId());
		if(newQuestion != null){
			questionMapper.update(question);
		}else{
			throw new Exception("更新失败");
			
		}		
	}

	@Override
	public void deleteById(long id) throws Exception {
		Question grade = questionMapper.findById(id);
		if(grade != null){
			questionMapper.deleteById(id);
		}else{
			throw new Exception("删除失败");
		}		
	}

	/*@Override
	public void save(QuestionVM questionVM) throws Exception {
		*//**一对多
		 * 1.将question和option 从questionVM中剥离出来
		 * 2.question 
		 * 
		 * *//*
		Long questionId = questionVM.getId();
		
		
		
	}*/


	
	
	
	
}

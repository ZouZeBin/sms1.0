package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Questionnaire;
import com.briup.app02.service.IQuestionnaireService;
import com.briup.app02.util.MsgResponse;

@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController {
	
	@Autowired
	private IQuestionnaireService questionnaireService;
	@GetMapping("findAll")
	public MsgResponse findAll() throws Exception {
		
		try{
			List<Questionnaire> list = questionnaireService.findAll();
			return MsgResponse.success("查询成功！", list);

		}catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());

		}
		
	}
	
	//通过ID查询
		@GetMapping("findById")
		public MsgResponse findById(long id){
			try {
				Questionnaire questionnaire = questionnaireService.findById(id);
				return MsgResponse.success("查询成功！", questionnaire);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
		
		//保存
		@PostMapping("save")
		public MsgResponse save(Questionnaire questionnaire){
			try {
				questionnaireService.save(questionnaire);
				return MsgResponse.success("保存成功！", null);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
				
			}
		}
		
		//更新
		@PostMapping("update")
		public MsgResponse update(Questionnaire questionnaire){
			try {
				questionnaireService.update(questionnaire);
				return MsgResponse.success("更新成功！", null);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
		
		//删除
		@PostMapping("deleteById")
		public MsgResponse deleteById(long id){
			try {
				questionnaireService.deleteById(id);
				return MsgResponse.success("删除成功", null);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}

	
	
}

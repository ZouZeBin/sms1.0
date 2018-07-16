package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Survey;
import com.briup.app02.service.ISurveyService;
import com.briup.app02.util.MsgResponse;

@RestController
@RequestMapping("/survey")
public class SurveyController {
	@Autowired
	private ISurveyService surveyService;
	
	/**
	 * @author 胡杰
	 * 通过创建MsgResponse方法 ，若查询成功，则返回"查询成功！"，并将所查询的班级返回
	 * 若查询不成功，则捕获抛出的新异常
	 * 
	 * */
	
	
		@GetMapping("findAll")
		public MsgResponse findAll(){
			try{
				List<Survey> list = surveyService.findAll();
				return MsgResponse.success("查询成功！", list);

			}catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());

			}
		}
		
		
		@GetMapping("findById")
		public MsgResponse findById(long id){
			try {
				Survey survey = surveyService.findById(id);
				return MsgResponse.success("查询成功！", survey);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
		

		@PostMapping("save")
		public MsgResponse save(Survey survey){
			try {
				surveyService.save(survey);
				return MsgResponse.success("保存成功！", null);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
				
			}
		}
		
	
		@PostMapping("update")
		public MsgResponse update(Survey survey){
			try {
				surveyService.update(survey);
				return MsgResponse.success("更新成功！", null);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
		
}

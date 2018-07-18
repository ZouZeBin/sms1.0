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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="调查实体相关接口")
@RestController
@RequestMapping("/survey")
public class SurveyController {
	@Autowired
	private ISurveyService surveyService;
	
	
	    @ApiOperation(value="查询全部课调实体信息")
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
		
	    @ApiOperation(value="通过ID查询全部课调实体信息")
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
		
	    @ApiOperation(value="插入课调实体信息")
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
		
	    @ApiOperation(value="更新课调实体信息")
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

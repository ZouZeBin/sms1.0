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
import com.briup.app02.vm.QuestionnaireVM;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="调查问卷相关接口")
@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController {
	
	@Autowired
	private IQuestionnaireService questionnaireService;
	
	@ApiOperation(value="查询全部问卷实体信息")
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
	
	@ApiOperation(value="查询全部问卷实体信息(级联)")
	@GetMapping("findAllQuestionnaireVM")
	public MsgResponse findAllQuestionnaireVM() throws Exception {

		try{
			List<QuestionnaireVM> list = questionnaireService.findAllQuestionnaireVM();
			return MsgResponse.success("查询成功！", list);

		}catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());

		}

	}

	
	    @ApiOperation(value="通过ID查询问卷实体信息")
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
		
	    @ApiOperation(value="通过ID查询问卷实体信息(级联)")
		@GetMapping("findByIdQuestionnaireVM")
		public MsgResponse findByIdQuestionnaireVM(long id) throws Exception {

			try{
				QuestionnaireVM questionnaireVM = questionnaireService.findByIdQuestionnaireVM(id);
				return MsgResponse.success("查询成功！", questionnaireVM);

			}catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());

			}

		}
		
		
		
	    @ApiOperation(value="插入问卷实体信息")
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
		
	    @ApiOperation(value="更新问卷实体信息")
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
		
	    @ApiOperation(value="删除问卷实体信息")
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

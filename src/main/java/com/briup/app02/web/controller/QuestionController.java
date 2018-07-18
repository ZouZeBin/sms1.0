package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Question;
import com.briup.app02.service.IQuestionService;
import com.briup.app02.util.MsgResponse;
import com.briup.app02.vm.QuestionVM;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(description="问题相关接口")
@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private IQuestionService questionService;
	
	
	@ApiOperation(value="插入问题信息(级联)",notes="保存问题相关的选项，问题ID和选项id以及question_id不需要输入")
	@PostMapping("saveQuestion")
	public MsgResponse save(QuestionVM questionVM){
		try {
				
			return MsgResponse.success("保存成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());

		}
	}
	
	
	@ApiOperation(value="查询所有问题",notes="只查询所有问题，不包括其答案")
	@GetMapping("findAll")
	public MsgResponse findAll() throws Exception {

		try{
			List<Question> list = questionService.findAll();
			return MsgResponse.success("查询成功！", list);

		}catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());

		}

	}
	
	@ApiOperation(value="查询所有问题(级联)",notes="查询所有问题的所有信息，包括问题的答案，所在的问卷调查")
	@GetMapping("findAllQuestionVM")
	public MsgResponse findAllQuestionVM() throws Exception {

		try{
			List<QuestionVM> list = questionService.findAllQuestionVM();
			return MsgResponse.success("查询成功！", list);

		}catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());

		}

	}

	@ApiOperation(value="通过ID查询问题信息",notes="只查询所有问题，不包括其答案")
	@GetMapping("findById")
	public MsgResponse findById(long id){
		try {
			Question question = questionService.findById(id);
			return MsgResponse.success("查询成功！", question);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value="通过ID查询问题信息(级联)",notes="查询所有问题及其答案")
	@GetMapping("findByIdQuestionVM")
	public MsgResponse findByIdQuestionVM(long id){
		try {
			QuestionVM questionVM = questionService.findByIdQuestionVM(id);
			return MsgResponse.success("查询成功！", questionVM);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="插入问题信息")
	@PostMapping("save")
	public MsgResponse save(Question question){
		try {
			questionService.save(question);
			return MsgResponse.success("保存成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());

		}
	}

	@ApiOperation(value="更新问题信息")
	@PostMapping("update")
	public MsgResponse update(Question question){
		try {
			questionService.update(question);
			return MsgResponse.success("更新成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value="通过ID删除问题信息")
	@PostMapping("deleteById")
	public MsgResponse deleteById(long id){
		try {
			questionService.deleteById(id);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}

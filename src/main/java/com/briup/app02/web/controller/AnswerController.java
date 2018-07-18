package com.briup.app02.web.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Answer;
import com.briup.app02.service.IAnswerService;
import com.briup.app02.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="问题相关接口")
@RestController
@RequestMapping("/answer")
public class AnswerController {
	@Autowired
	private IAnswerService answerService;
	
	@ApiOperation(value="查询所有问题",notes="查询班级的基本信息，不能查看年级和班主任")
	@GetMapping("findAll")
	public MsgResponse findAll() throws Exception {

		try {
			List<Answer> list = answerService.findAll();
			return MsgResponse.success("查询成功！", list);

		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());

		}

	}
	
	@ApiOperation(value="插入所有问题")
	@PostMapping("save")
	public MsgResponse save(Answer answer) {
		try {
			answerService.save(answer);
			return MsgResponse.success("保存成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());

		}
	}

}

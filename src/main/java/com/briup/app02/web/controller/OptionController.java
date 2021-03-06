package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Option;
import com.briup.app02.service.IOptionService;
import com.briup.app02.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="选项实体相关接口")
@RestController
@RequestMapping("/option")
public class OptionController {
	@Autowired
	private IOptionService optionService;

    @ApiOperation(value="查询全部选项实体信息")
	@GetMapping("findAll")
	public MsgResponse findAll() throws Exception {
		
		try{
			List<Option> list = optionService.findAll();
			return MsgResponse.success("查询成功！", list);

		}catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());

		}
		
	}
    
    @ApiOperation(value="插入选项实体信息")
	@PostMapping("save")
	public MsgResponse save(Option option){
		try {
			optionService.save(option);
			return MsgResponse.success("保存成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
			
		}
	}
    
    @ApiOperation(value="更新选项实体信息")
	@PostMapping("update")
	public MsgResponse update(Option option){
		try {
			optionService.update(option);
			return MsgResponse.success("更新成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
	
	
	
}

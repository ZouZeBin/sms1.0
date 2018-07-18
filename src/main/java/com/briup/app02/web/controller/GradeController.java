package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Grade;
import com.briup.app02.service.IGradeService;
import com.briup.app02.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="年级相关接口")
@RestController
@RequestMapping("/grade")
public class GradeController {

	@Autowired
	private IGradeService gradeService;
	
	@ApiOperation(value="查找全部年级信息")
	@GetMapping("findAll")
	public MsgResponse findAll() throws Exception {
		
		try{
			List<Grade> list = gradeService.findAll();
			return MsgResponse.success("查询成功！", list);

		}catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());

		}
		
	}
	
	
	    @ApiOperation(value="通过ID查询用户信息")
		@GetMapping("findById")
		public MsgResponse findById(long id){
			try {
				Grade grade = gradeService.findById(id);
				return MsgResponse.success("查询成功！", grade);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
		
		
	    @ApiOperation(value="插入用户信息")
		@PostMapping("save")
		public MsgResponse save(Grade grade){
			try {
				gradeService.save(grade);
				return MsgResponse.success("保存成功！", null);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
				
			}
		}
		
	
	    @ApiOperation(value="更新用户信息")
		@PostMapping("update")
		public MsgResponse update(Grade grade){
			try {
				gradeService.update(grade);
				return MsgResponse.success("更新成功！", null);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
		
		
	    @ApiOperation(value="删除用户信息")
		@PostMapping("deleteById")
		public MsgResponse deleteById(long id){
			try {
				gradeService.deleteById(id);
				return MsgResponse.success("删除成功", null);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}

	
}

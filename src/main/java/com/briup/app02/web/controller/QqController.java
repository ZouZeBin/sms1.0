package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Qq;
import com.briup.app02.service.IQqService;
import com.briup.app02.util.MsgResponse;
import com.briup.app02.vm.QqVM;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;
@Api(description="问题和调查问卷桥表")

@RestController
@RequestMapping("/qq")
public class QqController {
	@Autowired
	private IQqService qqService;

    @ApiOperation(value="查询全部桥表信息")
	public MsgResponse findAll() throws Exception {
		
		try{
			List<Qq> list = qqService.findAll();
			return MsgResponse.success("查询成功！", list);

		}catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());

		}
		
	}
    
    @ApiOperation(value="查询全部桥表信息(级联)")
	@GetMapping("findAllQqVM")
	public MsgResponse findAllQqVM() throws Exception {
		
		try{
			List<QqVM> list = qqService.findAllQqVM();
			return MsgResponse.success("查询成功！", list);

		}catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());

		}
		
	}
	
    @ApiOperation(value="插入桥表信息")
	@PostMapping("save")
	public MsgResponse save(Qq qq){
		try {
			qqService.save(qq);
			return MsgResponse.success("保存成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
			
		}
	}
    @ApiOperation(value="更新桥表信息")
	@PostMapping("update")
	public MsgResponse update(Qq qq){
		try {
			qqService.update(qq);
			return MsgResponse.success("更新成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
}

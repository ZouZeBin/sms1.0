package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Clazz;
import com.briup.app02.service.IClazzService;
import com.briup.app02.util.MsgResponse;
import com.briup.app02.vm.ClazzVM;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(description="班级相关接口")
@RestController
@RequestMapping("/clazz")
public class ClazzController {

	@Autowired
	private IClazzService  clazzService;
	
	/**
	 * @author 胡杰
	 * 通过创建MsgResponse方法 ，若查询成功，则返回"查询成功！"，并将所查询的班级返回
	 * 若查询不成功，则捕获抛出的新异常
	 * 
	 * */
	
		@ApiOperation(value="查询所有班级",notes="只能查询班级的基本信息，不能查看年级和班主任")
		@GetMapping("findAll")
		public MsgResponse findAll(){
			try{
				List<Clazz> list = clazzService.findAll();
				return MsgResponse.success("查询成功！", list);

			}catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());

			}
		}
		
		@ApiOperation(value="查询所有班级",notes="即查询班级的基本信息，也能查看年级和班主任")
		@GetMapping("findAllClazzVM")
		public MsgResponse findAllClazzVM(){
			try{
				List<ClazzVM> list = clazzService.findAllClazzVM();
				return MsgResponse.success("查询成功！", list);

			}catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());

			}
		}
		
		//通过ID查询班级
		@ApiOperation(value="根据ID查看班级",notes="即查询班级的基本信息，也能查看年级和班主任")
		@GetMapping("findByIdClazzVM")
		public MsgResponse findByIdClazzVM(long id){
			try {
				ClazzVM clazzVM = clazzService.findByIdClazzVM(id);
				return MsgResponse.success("查询成功！", clazzVM);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
		
		@ApiOperation(value="根据ID查看班级",notes="只能查询班级的基本信息")
		@GetMapping("findById")
		public MsgResponse findById(long id){
			try {
				Clazz clazz = clazzService.findById(id);
				return MsgResponse.success("查询成功！", clazz);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
		
		//保存班级
		@PostMapping("save")
		public MsgResponse save(Clazz clazz){
			try {
				clazzService.save(clazz);
				return MsgResponse.success("保存成功！", null);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
				
			}
		}
		
		//更新班级
		@PostMapping("update")
		public MsgResponse update(Clazz clazz){
			try {
				clazzService.update(clazz);
				return MsgResponse.success("更新成功！", null);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
		
		//删除学校
		@PostMapping("deleteById")
		public MsgResponse deleteById(long id){
			try {
				clazzService.deleteById(id);
				return MsgResponse.success("删除成功！", null);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}


	
}

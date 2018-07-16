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
		
		//通过ID查询班级
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
				return MsgResponse.success("删除成功", null);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}


	
}

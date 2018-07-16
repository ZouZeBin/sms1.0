package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.User;
import com.briup.app02.service.IUserService;
import com.briup.app02.util.MsgResponse;

@RestController
@RequestMapping("/User")
public class UserController {

	@Autowired
	private IUserService userService;
	

	//查询所有的用户
	@GetMapping("findAll")
	public MsgResponse findAll(){
		try{
			List<User> list = userService.findAll();
			return MsgResponse.success("查询成功！", list);

		}catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());

		}
	}
	
	//通过ID查询用户
	@GetMapping("findById")
	public MsgResponse findById(long id){
		try {
			User user = userService.findById(id);
			return MsgResponse.success("查询成功！", user);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	//保存用户
	@PostMapping("save")
	public MsgResponse save(User user){
		try {
			userService.save(user);
			return MsgResponse.success("保存成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
			
		}
	}
	
	//更新用户
	@PostMapping("update")
	public MsgResponse update(User user){
		try {
			userService.update(user);
			return MsgResponse.success("更新成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	//删除用户
	@PostMapping("deleteById")
	public MsgResponse deleteById(long id){
		try {
			userService.deleteById(id);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}


	
}

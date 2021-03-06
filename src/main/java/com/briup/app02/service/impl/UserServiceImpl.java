package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.User;
import com.briup.app02.dao.UserMapper;
import com.briup.app02.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper userMapper;
	

	@Override
	public List<User> findAll() throws Exception {
		List <User> user = userMapper.findAll();
		if(user != null){
			return user;
		}
		else{
			throw new Exception("查找失败");
		}
	}

	@Override
	public User findById(long id) throws Exception {
		User user = userMapper.findById(id);
		if(user != null){
			return userMapper.findById(id);
			
		}else{
			throw new Exception("查找失败");
			
		}
	}

	@Override
	public void save(User user) throws Exception {
		if(user.getName() != null){
			userMapper.save(user);
		}else{
			throw new Exception("保存失败");
		}
				
	}

	@Override
	public void update(User user) throws Exception {
		User newSchool = userMapper.findById(user.getId());
		if(newSchool != null){
			userMapper.update(user);
		}else{
			throw new Exception("更新失败");
			
		}		
	}

	@Override
	public void deleteById(long id) throws Exception {
		User user = userMapper.findById(id);
		if(user != null){
			userMapper.deleteById(id);
		}else{
			throw new Exception("删除失败");
		}		
	}

}

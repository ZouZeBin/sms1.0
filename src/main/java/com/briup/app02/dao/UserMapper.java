package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.User;

public interface UserMapper {

	List<User> findAll();

	User findById(long id);

	void save(User user);

	void update(User user);

	void deleteById(long id);
}

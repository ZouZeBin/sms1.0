package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Clazz;

public interface ClazzMapper {
	// 查找所有班级
	List<Clazz> findAll();

	// 通过Id来查找班级
	Clazz findById(long id);

	// 保存班级
	void save(Clazz clazz);

	// 更新班级
	void update(Clazz clazz);

	// 删除班级
	void deleteById(long id);

}

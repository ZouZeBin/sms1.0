package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Qq;

public interface QqMapper {

	List<Qq> findAll();

	List<Qq> findByQuestionId(long id);

	void save(Qq qq);

	void update(Qq qq);

}

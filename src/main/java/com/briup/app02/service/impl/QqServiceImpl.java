package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Qq;
import com.briup.app02.dao.QqMapper;
import com.briup.app02.service.IQqService;

@RestController
@RequestMapping("/qq")
public class QqServiceImpl implements IQqService {
	
	@Autowired
	private QqMapper qqMapper;
	
	@Override
	public List<Qq> findAll() throws Exception {
		List <Qq> qq = qqMapper.findAll();
		if(qq != null){
			return qq;
		}
		else{
			throw new Exception("不存在选项！");
		}
	}

	@Override
	public void save(Qq qq) throws Exception {
		if(qq.getQuestion_id() != null){
			qqMapper.save(qq);
		}else{
			throw new Exception("保存失败！请联系管理员。");
		}
	}


	@Override
	public void update(Qq qq) throws Exception {
	
		if(qq.getId() != null){
			qqMapper.update(qq);
		}else{
			throw new Exception("更新失败，您要更新的学校不存在！");
			
		}
	}
}

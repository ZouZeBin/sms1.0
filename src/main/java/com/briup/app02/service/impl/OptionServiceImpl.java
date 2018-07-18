package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Option;
import com.briup.app02.dao.OptionMapper;
import com.briup.app02.service.IOptionService;

@Service
public class OptionServiceImpl implements IOptionService {
	@Autowired
	private OptionMapper optionMapper;

	@Override
	public List<Option> findAll() throws Exception {
		List <Option> option = optionMapper.findAll();
		if(optionMapper != null){
			return option;
		}
		else{
			throw new Exception("查找失败！");
		}
	}

	@Override
	public void save(Option option) throws Exception {
		if(option.getLabel() != null){
			optionMapper.save(option);
		}else{
			throw new Exception("保存失败");
		}
	}

	@Override
	public void update(Option option) throws Exception {
		// TODO Auto-generated method stub

	}
}


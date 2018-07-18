package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Clazz;
import com.briup.app02.dao.ClazzMapper;
import com.briup.app02.dao.extend.ClazzVMMapper;
import com.briup.app02.service.IClazzService;
import com.briup.app02.vm.ClazzVM;

@Service
public class ClazzServiceImpl implements IClazzService {
	
	@Autowired
	private ClazzMapper clazzMapper;
	@Autowired
	private ClazzVMMapper clazzVMMapper;
	
	/**
	 * @author 胡杰
	 * @param clazz
	 * 若查询失败  则抛出一个新异常让StudentControll捕获
	 * 
	 * */
	
	
	@Override
	public List<Clazz> findAll() throws Exception {
		List <Clazz> clazz = clazzMapper.findAll();
		if(clazz != null){
			return clazz;
		}else{
			throw new Exception("不存在任何班级！");
		}
		
	}
	
	@Override
	public List<ClazzVM> findAllClazzVM() throws Exception {
		
		return clazzVMMapper.findAllClazzVM();
	}
	
	@Override
	public Clazz findById(long id) throws Exception {
		Clazz clazz = clazzMapper.findById(id);
		if(clazz != null){
			return clazz;
		}else{
			throw new Exception("您要查找的班级不存在！");
		}
		
	}
	
	@Override
	public ClazzVM findByIdClazzVM(long id) throws Exception {
		ClazzVM clazzVM = clazzVMMapper.findByIdClazzVM(id);
		if(clazzVM != null){
			return clazzVM;
		}else{
			throw new Exception("您要查找的班级不存在！");
		}
	}


	@Override
	public void save(Clazz clazz) throws Exception {
		if(clazz.getName() !=null){
			clazzMapper.save(clazz);
		}else{
			throw new Exception("保存失败！请输入完整信息");
		}
	}

	@Override
	public void update(Clazz clazz) throws Exception {
		Clazz newClazz = clazzMapper.findById(clazz.getId());
		if(newClazz != null){
			clazzMapper.update(clazz);
		}else{
			throw new Exception("更新失败！不存在该班级");
		}
		
	}

	@Override
	public void deleteById(long id) throws Exception {
		Clazz clazz = clazzMapper.findById(id);
		if(clazz != null){
			clazzMapper.deleteById(id);
		}else{
			throw new Exception("删除失败！不存在该班级");
		}
		
	}



	
}

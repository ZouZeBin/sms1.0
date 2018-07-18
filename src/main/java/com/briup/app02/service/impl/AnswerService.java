package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Answer;
import com.briup.app02.dao.AnswerMapper;
import com.briup.app02.service.IAnswerService;

@RestController
@RequestMapping("/answer")
public class AnswerService implements IAnswerService {
	@Autowired
	private AnswerMapper answerMapper;

	@Override
	public List<Answer> findAll() throws Exception {
		List<Answer> answer = answerMapper.findAll();
		if (answer != null) {
			return answer;
		} else {
			throw new Exception("不存在选项！");
		}
	}

	@Override
	public void save(Answer answer) throws Exception {

		answerMapper.save(answer);

	}
}

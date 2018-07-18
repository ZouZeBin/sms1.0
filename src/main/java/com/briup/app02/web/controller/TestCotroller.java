package com.briup.app02.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;
@ApiIgnore
@RestController
@RequestMapping()

public class TestCotroller {
	@GetMapping("宫本")
	public String 宫本(){
		return "无敌的我 ，又回来了";
	}
	
	@GetMapping("小乔")
	public String 小乔(){
		return "小乔  ，要努力变强";
	}
	
	@GetMapping("韩信")
	public String 韩信(){
		return "重生，我既不吃大蒜，也没有口臭";
	}


}

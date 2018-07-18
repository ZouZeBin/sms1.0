package com.briup.app02.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;


@ApiIgnore //网页上不显示
@RestController
@RequestMapping()

public class TestCotroller {
	@GetMapping("hello")
	public String hello(){
		return "hello world";
	}
	

}

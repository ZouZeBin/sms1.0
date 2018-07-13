package com.briup.app02.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.briup.app02.dao")//告诉mybatis映射借口写在哪个包中
public class MybatisConfig {

}

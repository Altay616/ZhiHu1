package com.team.zhihu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@MapperScan("com.team.zhihu.mapper")
public class ZhihuDemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ZhihuDemoApplication.class, args);
	}

}

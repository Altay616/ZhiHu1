package com.team.zhihu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Controller;

import com.team.zhihu.bean.Book;

@Mapper//注解方式
@Controller
public interface bookMapper {
	
	
	@Select("select * from book")
	public List<Book> findAll();
	
	
	
	
	
}

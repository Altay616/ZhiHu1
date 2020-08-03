package com.team.zhihu.service;

import java.util.List;

import com.team.zhihu.bean.Essay;

public interface HomeService {
	//主页文章列表
	List<Essay> selectEssayWithUname();
	
	//主页模糊查询
	List<Essay> selectByKeyworrd(String keyword);
		

	
	Essay selectById(Integer id);
}

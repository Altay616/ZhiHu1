package com.team.zhihu.service;

import java.util.List;

import com.team.zhihu.bean.Good;

public interface GoodService {

	public List<Good> selectByUserid(Integer id) ;
	
	//用户点赞后插入点赞表
	public int insertGood(Good good);
	
	//用户取消点赞
	public int cancelGood(Integer essayid,Integer userid);

}

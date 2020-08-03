package com.team.zhihu.service;



import com.team.zhihu.bean.Essay;


public interface EssayService {

	int insert(Essay essay);
	//添加点赞数
    int addGoodById(int goodnum,int id);        
}

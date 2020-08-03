package com.team.zhihu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.zhihu.bean.Essay;
import com.team.zhihu.mapper.EssayMapper;
import com.team.zhihu.service.EssayService;
@Service
public class EssayServiceImpl implements EssayService {
	@Autowired
	EssayMapper essayMapper;
	@Override
	public int insert(Essay essay) {
		return essayMapper.insert(essay);
		
	}
	@Override
	public int addGoodById(int goodnum, int id) {
		// TODO 自动生成的方法存根
		return essayMapper.updateGoodNumByid(goodnum, id);
	}

}

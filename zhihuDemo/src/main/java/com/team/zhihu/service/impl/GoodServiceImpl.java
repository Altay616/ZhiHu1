package com.team.zhihu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.zhihu.bean.Good;
import com.team.zhihu.mapper.GoodMapper;
import com.team.zhihu.service.GoodService;

@Service
public class GoodServiceImpl implements GoodService{
	
	@Autowired
	private GoodMapper goodMapper;

	@Override
	public List<Good> selectByUserid(Integer id) {
		// TODO Auto-generated method stub
		return goodMapper.selectByUserid(id);
	}

	@Override
	public int insertGood(Good good) {
		// TODO 自动生成的方法存根
		return goodMapper.insert(good);
	}

	@Override
	public int cancelGood(Integer essayid, Integer userid) {
		// TODO 自动生成的方法存根
		return goodMapper.deleteByEssayId(essayid, userid);
	}

}

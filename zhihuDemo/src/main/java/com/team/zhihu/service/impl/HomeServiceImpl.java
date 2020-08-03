package com.team.zhihu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.zhihu.bean.Essay;
import com.team.zhihu.bean.User;
import com.team.zhihu.mapper.EssayMapper;
import com.team.zhihu.mapper.UserMapper;
import com.team.zhihu.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService{
	
	@Autowired
	EssayMapper essayMapper;
	
	@Autowired
	UserMapper userMapper;
	
	/*@Override
	public List<Essay> selectByEtype(int type) {
		// TODO 自动生成的方法存根
		return essayMapper.selectByEtype(type);
	}*/

	@Override
	public List<Essay> selectEssayWithUname() {
		// TODO 自动生成的方法存根
		/*List<Essay> EssayList=new ArrayList<>();
		EssayList=essayMapper.selectByEtype();
		for(int i=0;i<EssayList.size();i++) {
			User user=userMapper.selectByPrimaryKey(EssayList.get(i).getUserid());
			EssayList.get(i).setUser(user);
		}
		return EssayList;*/
		return essayMapper.selectEssayWithUname();
	}

	@Override
	public List<Essay> selectByKeyworrd(String keyword) {
		// TODO 自动生成的方法存根
		/*List<Essay> EssayList=new ArrayList<>();
		EssayList=essayMapper.selectByKeyword(keyword);
		for(int i=0;i<EssayList.size();i++) {
			User user=userMapper.selectByPrimaryKey(EssayList.get(i).getUserid());
			EssayList.get(i).setUser(user);
		}
		return EssayList;*/
		return essayMapper.selectByKeyword(keyword);
	}

	@Override
	public Essay selectById(Integer id) {
		return essayMapper.selectByPrimaryKey(id);
	}


}

package com.team.zhihu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.zhihu.bean.User;
import com.team.zhihu.mapper.UserMapper;
import com.team.zhihu.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	 private UserMapper userMapper;
	@Override
	public User selectByUser(User user) {
		
		// TODO Auto-generated method stub
		return userMapper.selectByUser(user);
	}
	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.insertSelective(user);
	}
	@Override
	public User selectByphonenumber(String phonenumber) {
		// TODO Auto-generated method stub
		return userMapper.selectByPhoneNumber(phonenumber);
	}
	@Override
	public User selectByUserName(String username) {
		// TODO Auto-generated method stub
		return userMapper.selectByUserName(username);
	}
	@Override
	public User selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}

	
}
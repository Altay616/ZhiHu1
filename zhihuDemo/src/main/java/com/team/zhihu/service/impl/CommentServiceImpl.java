package com.team.zhihu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.zhihu.bean.Comment;
import com.team.zhihu.mapper.CommentMapper;
import com.team.zhihu.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	CommentMapper commentMapper;


	@Override
	public int insertComment(Comment comment) {
		// TODO 自动生成的方法存根
		return commentMapper.insert(comment);
	}
	public List<Comment> selectByEssayid(Integer essayid) {
		// TODO Auto-generated method stub
		return commentMapper.selectByEssayId(essayid);
	}
	@Override
	public Integer showCommentNumber(Integer essayid) {
		// TODO Auto-generated method stub
		return commentMapper.selectCommentNumber(essayid);
	}
	@Override
	public List<Comment> getAllCommentById(int essayid) {
		// TODO 自动生成的方法存根
		return commentMapper.selectByEssayId(essayid);
	}
	
	@Override
	public Comment selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return commentMapper.selectByPrimaryKey(id);
	}
}

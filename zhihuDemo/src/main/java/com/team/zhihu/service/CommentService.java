package com.team.zhihu.service;

import java.util.List;

import com.team.zhihu.bean.Comment;

public interface CommentService {
	//根据文章id获取所有评论列表
	List<Comment> getAllCommentById(int essayid);
	//添加评论
	int insertComment(Comment comment);
	public Integer showCommentNumber(Integer essayid);
	
	List<Comment> selectByEssayid(Integer essayid);
	Comment selectByPrimaryKey(Integer id);
}

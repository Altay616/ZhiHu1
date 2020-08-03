package com.team.zhihu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.zhihu.bean.Reply;
import com.team.zhihu.bean.ReplyExample;
import com.team.zhihu.bean.ReplyExample.Criteria;
import com.team.zhihu.mapper.ReplyMapper;
import com.team.zhihu.service.ReplyService;

@Service
public class ReplyServiceIpml implements ReplyService {

	@Autowired
	private ReplyMapper replyMapper;
	@Override
	public Reply selectByCommentId(Integer commentId) {
		// TODO Auto-generated method stub
		return replyMapper.selectByCommentKey(commentId);
	}
	@Override
	public int insertReply(Reply reply) {
		// TODO 自动生成的方法存根
		return replyMapper.insert(reply);
	}
	
//	这两个都是一样的
//	跟据主键获取集合 调用的方法都是一样的
	@Override
	public List<Reply> selectByCommentKey(Integer id) {
		// TODO 自动生成的方法存根
		return replyMapper.selectByCommentId(id);
	}
	

//	根据 commentid获取 reply集合
	@Override
	public List<Reply> selectByCommentid(Integer commentId) {
		// TODO Auto-generated method stub
		return replyMapper.selectByCommentId(commentId);
	}
	@Override
	public Reply selectByPrimaryKey(Integer myid) {
		// TODO Auto-generated method stub
		return replyMapper.selectByPrimaryKey(myid);
	}
	@Override
	public Integer insertByReply(Reply reply) {
		// TODO Auto-generated method stub
		return replyMapper.insertSelective(reply);
	}
	@Override
	public Reply selectByReply(Reply reply) {
		// TODO Auto-generated method stub
		return replyMapper.selectByReply(reply);
	}
	@Override
	public Integer showReplyNumber(Integer eassayid) {
		ReplyExample replyExample = new ReplyExample();
		Criteria createCriteria = replyExample.createCriteria();
		createCriteria.andEssayidEqualTo(eassayid);
		// TODO Auto-generated method stub
		return (int) replyMapper.countByExample(replyExample);
	}
	

}

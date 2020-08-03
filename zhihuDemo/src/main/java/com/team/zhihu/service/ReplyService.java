package com.team.zhihu.service;

import java.util.List;

import com.team.zhihu.bean.Reply;

public interface ReplyService {

	Reply selectByCommentId(Integer commentId);
	
	int insertReply(Reply reply);
	
	List<Reply> selectByCommentKey(Integer id);
	
	List<Reply> selectByCommentid(Integer commentId);

	Reply selectByPrimaryKey(Integer myid);

	Integer insertByReply(Reply reply);

	Reply selectByReply(Reply reply);

	Integer showReplyNumber(Integer eassayid);

}

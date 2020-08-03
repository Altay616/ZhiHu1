package com.team.zhihu.mapper;

import com.team.zhihu.bean.Reply;
import com.team.zhihu.bean.ReplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReplyMapper {
    long countByExample(ReplyExample example);

    int deleteByExample(ReplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Reply record);

    int insertSelective(Reply record);

    List<Reply> selectByExample(ReplyExample example);

    Reply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Reply record, @Param("example") ReplyExample example);

    int updateByExample(@Param("record") Reply record, @Param("example") ReplyExample example);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKey(Reply record);

	Reply selectByCommentKey(Integer commentId);
	
	List<Reply> selectByCommentId(Integer commentId);
	
	List<Reply> selectListByCommenId(Integer commitid);
	Reply selectByReply(Reply reply);
}
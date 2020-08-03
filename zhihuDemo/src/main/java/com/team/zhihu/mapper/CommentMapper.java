package com.team.zhihu.mapper;

import com.team.zhihu.bean.Comment;
import com.team.zhihu.bean.CommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentMapper {
	
	//根据文章id查询评论
	List<Comment> selectByEssayId(Integer essayid);
	
    long countByExample(CommentExample example);

    int deleteByExample(CommentExample example);

    int deleteByPrimaryKey(Integer id);
//添加评论
    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectByExample(CommentExample example);

    Comment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByExample(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

	List<Comment> selectByEssayid(Integer essayid);

	Integer selectCommentNumber(Integer essayid);
}
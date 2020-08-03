package com.team.zhihu.mapper;

import com.team.zhihu.bean.Essay;
import com.team.zhihu.bean.EssayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EssayMapper {
    long countByExample(EssayExample example);

    int deleteByExample(EssayExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Essay record);

    int insertSelective(Essay record);
    
    List<Essay> selectByExample(EssayExample example);

    Essay selectByPrimaryKey(Integer id);
    
    //根据essay表中的type获取文章列表
    List<Essay> selectByEtype();
    //联合查询user,eassy
    List<Essay> selectEssayWithUname();
    
    //模糊查询
    List<Essay> selectByKeyword(String keyword);
    
    int updateByExampleSelective(@Param("record") Essay record, @Param("example") EssayExample example);

    int updateByExample(@Param("record") Essay record, @Param("example") EssayExample example);

    int updateByPrimaryKeySelective(Essay record);

    int updateByPrimaryKey(Essay record);
    
    //更新点赞数
    int updateGoodNumByid(int goodnum,int id);
}
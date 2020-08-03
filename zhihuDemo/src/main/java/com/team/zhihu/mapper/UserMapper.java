package com.team.zhihu.mapper;

import com.team.zhihu.bean.User;
import com.team.zhihu.bean.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	User selectByUser(User user);

	User selectByPhoneNumber(String phonenumber);

	User selectByUserName(String username);

    
}
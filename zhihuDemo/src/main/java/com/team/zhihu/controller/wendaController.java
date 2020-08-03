package com.team.zhihu.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.zhihu.bean.Comment;
import com.team.zhihu.bean.Essay;
import com.team.zhihu.bean.Topic;
import com.team.zhihu.bean.User;
import com.team.zhihu.bean.commentUser;
import com.team.zhihu.mapper.CommentMapper;
import com.team.zhihu.mapper.EssayMapper;
import com.team.zhihu.mapper.TopicMapper;
import com.team.zhihu.mapper.UserMapper;
import com.team.zhihu.utils.DateUtil;

@Controller
public class wendaController {
	
	//@author 于增才
	@Autowired
	EssayMapper essayMapper;
	@Autowired
	TopicMapper topicmapper;
	@Autowired
	UserMapper UserMapper;
	@Autowired
	CommentMapper commentMapper;
	
	@RequestMapping("wenda")
	public String towendaHtml(Integer id, Map<String,Object> map) { 
		//查询诸多要素
		System.out.println(id);
		 Essay essay = essayMapper.selectByPrimaryKey(id);
		Topic topic =topicmapper.selectByPrimaryKey(essay.getTopictype()); 
		map.put("topicName", topic);
		User user = UserMapper.selectByPrimaryKey(essay.getUserid());
		map.put("myessay", essay);
		map.put("user",user);
		List<Comment> comments = commentMapper.selectByEssayid(essay.getId());
		List<commentUser> commentUsers = new ArrayList<commentUser>();
		for(Comment comment:comments) {
			User user1 = UserMapper.selectByPrimaryKey(comment.getUserid());
			commentUser commentUser = new commentUser(comment.getId(), user1, comment.getContext(),comment.getDate());
			commentUsers.add(commentUser);
		}
		map.put("commnentUsers", commentUsers); 
		return "wenda";
	} 
	
	@RequestMapping("wenda/commment")
	public void wendaComment(Comment comment) {
		 Date date = new Date();
		 String date1 = DateUtil.dateToString(date);
		 comment.setDate(date1);
		 System.out.println(comment.toString());
		 commentMapper.insert(comment);  
	}
}

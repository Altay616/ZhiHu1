package com.team.zhihu.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.zhihu.bean.Essay;
import com.team.zhihu.bean.Question;
import com.team.zhihu.bean.Topic;
import com.team.zhihu.mapper.EssayMapper;
import com.team.zhihu.mapper.QuestionMapper;
import com.team.zhihu.mapper.TopicMapper;

@Controller
public class askQuestionController {
	@Autowired
	TopicMapper topicMapper;
	
	@Autowired
	EssayMapper essayMapper;
	@RequestMapping("askQuestion")
		public String askQuestion() {
		return "askQuestion"; 
	}
	
	@ResponseBody
	@RequestMapping("askQuestionController/topic_search")
	public Map<String, Object> getTpoics(String topicname){ 
		Map<String, Object> map = new HashMap<String, Object>();
		List<Topic> list = new ArrayList<Topic>();
		list = topicMapper.selectTopicByName(topicname); 
		map.put("mylist", list);
		return  map;
	}
	
	@RequestMapping("askQuestionController/publishQuestion")
	@ResponseBody
	public String publishQuestion(Question question) {
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 
		Essay essay = new Essay(null, question.getTitle(), question.getDescribe(), 0, 1, question.getTypeid(), question.getUserid() ,df.format(date));
		essayMapper.insert(essay);	 
		System.out.println("111111111");
		return "index"; 
	}
}


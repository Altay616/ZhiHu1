package com.team.zhihu.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.zhihu.bean.Comment;
import com.team.zhihu.bean.Reply;
import com.team.zhihu.bean.User;
import com.team.zhihu.service.CommentService;
import com.team.zhihu.service.ReplyService;
import com.team.zhihu.utils.DateUtil;

@Controller
public class CommentController{
	@Autowired
	CommentService commenservice;
	
	@Autowired
	ReplyService replyservice;
	@RequestMapping("/addComment")
	public String addComment(int essayid,String context,HttpServletRequest req,HttpServletResponse resp) {
		Date date=new Date();
		String dateAdd=DateUtil.dateToString(date);
		HttpSession session=req.getSession();
		User user=(User) session.getAttribute("curUser");
		int userid=user.getId();
		Comment comment=new Comment(0, essayid, context, userid, dateAdd, user);
		commenservice.insertComment(comment);
		return "redirect:/queryCommentByid?id="+essayid;
	}
	@RequestMapping("/toUserComment")
	public String toUserComment(int essayid,int commitid,String context,int touserid,HttpServletRequest req,HttpServletResponse resp) {
		Date date=new Date();
		String dateAdd=DateUtil.dateToString(date);
		HttpSession session=req.getSession();
		User user=(User) session.getAttribute("curUser");
		Reply reply=new Reply(0, essayid, commitid, context, user.getId(), touserid, dateAdd, null, null);
		replyservice.insertReply(reply);
		return "redirect:/queryCommentByid?id="+essayid;
	}

	
}
package com.team.zhihu.controller;
//主页内容文章的显示

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.zhihu.bean.Comment;
import com.team.zhihu.bean.Essay;
import com.team.zhihu.bean.Reply;
import com.team.zhihu.bean.User;
import com.team.zhihu.service.CommentService;
import com.team.zhihu.service.HomeService;
import com.team.zhihu.service.ReplyService;
import com.team.zhihu.service.UserService;

@Controller
public class HomeController {

	@Autowired
	HomeService homeservice;

	@Autowired
	CommentService commenservice;

	@Autowired
	ReplyService replyService;
	@Autowired
	UserService userService;

	// 主页显示
	@RequestMapping("/index")
	public String toHome(HttpServletRequest req, HttpServletResponse resp) {
		// 查询所有文章
		HttpSession session = req.getSession();
		List<Essay> essays = homeservice.selectEssayWithUname();
		/*
		 * for(Essay essay:essays) { System.out.println(essay.getTopic()); }
		 */
		// 将查到的文章列表存到session中
		session.setAttribute("essays", essays);
		return "index";
	}

	// 主页模糊查询
	@RequestMapping("/queryByKeyword")
	public String queryLikeUnameOrTitle(String keyword, HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		System.out.println(keyword);
		List<Essay> essays = homeservice.selectByKeyworrd(keyword);
		/*
		 * for(Essay essay:essays) { System.out.println(essay.getUser()); }
		 */
		session.setAttribute("essays", essays);
		return "index";
	}

	// 查询评论
	@RequestMapping("/queryCommentByid")
	public String queryCommentList(Integer id, HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		List<Comment> listComments =new ArrayList<>();
		List<Comment> comments=new ArrayList<>();
		List<Reply> newreply=new ArrayList<>();
		 listComments = commenservice.getAllCommentById(id);
		if(listComments!=null) {
			for (Comment comment : listComments) {
				List<Reply> replys =new ArrayList<>();
				replys = replyService.selectByCommentKey(comment.getId());
				System.out.println("replys"+replys);
				for (Reply reply : replys) {
					if (reply != null) {
						User fromUser = userService.selectByPrimaryKey(reply.getFromuserid());
						User toUser = userService.selectByPrimaryKey(reply.getTouserid());
						reply.setFromUser(fromUser);
						reply.setToUser(toUser);
						newreply.add(reply);
					}
				}
				comment.setReplyList(newreply);
				comments.add(comment);
			}
			
			session.setAttribute("listComments", comments);
		}
		
		return "comment";
	}

}

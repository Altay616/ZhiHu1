package com.team.zhihu.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.zhihu.bean.Comment;
import com.team.zhihu.bean.Essay;
import com.team.zhihu.bean.Good;
import com.team.zhihu.bean.Reply;
import com.team.zhihu.bean.User;
import com.team.zhihu.service.CommentService;
import com.team.zhihu.service.EssayService;
import com.team.zhihu.service.GoodService;
import com.team.zhihu.service.HomeService;
import com.team.zhihu.service.ReplyService;
import com.team.zhihu.service.UserService;
import com.team.zhihu.utils.DateUtil;

@Controller
public class MineController {
	@Autowired
	private GoodService goodService;
	
	@Autowired
	private HomeService homeService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private ReplyService replyService;
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/mine")
	public String showGoodEssay(HttpServletRequest req) {
		User user = (User)req.getSession().getAttribute("curUser");
		//个人主页为 自己赞过的文章  页面请参照 知乎官网
		List<Good> goods = goodService.selectByUserid(user.getId());
		List<Essay> essays = new ArrayList<>();
		/**
		 * 先根据 good的essayid找到 essay
		 * 同时在评论表里面查找评论数 :  当前文章的评论+回复
		 */
		for(Good good:goods) {
			Essay essay = homeService.selectById((good.getEassayid()));
			Integer commentNumber = commentService.showCommentNumber(good.getEassayid());
			Integer replyNumber = replyService.showReplyNumber(good.getEassayid());
			commentNumber += replyNumber;
			essay.setCommentNumber(commentNumber);
			essays.add(essay);
		}
		req.getSession().setAttribute("goodEssays", essays);
		return "mine";
	}
	
	@ResponseBody()
	@RequestMapping("/mine/showcommit")
	public List<Comment> showCommit(@RequestParam("essayid")Integer essayid,HttpServletRequest req) {
		//展示当前文章的评论
		User user = (User)req.getSession().getAttribute("curUser");
		// 所有评论
		List<Comment> comments = commentService.selectByEssayid(essayid);
		for(Comment comment:comments) {
			// 查询评论里的 回复
			List<Reply> replys= replyService.selectByCommentid(comment.getId());
			for(Reply reply:replys) {
				if(reply!=null) {
					// 查询 fromUser to User 便于后端取名
					User fromUser = userService.selectByPrimaryKey(reply.getFromuserid());
					User toUser = userService.selectByPrimaryKey(reply.getTouserid());
					reply.setFromUser(fromUser);
					reply.setToUser(toUser);	
				}
			}
			comment.setReplyList(replys);
		}
		return comments;
	}
	
	@ResponseBody()
	@RequestMapping("/reply/insert")
	public Object insertReply(String id,String text,HttpServletRequest req) {
//		将 ids分隔开  
//		ids[0]为评论或回复的id
//		ids[1]为类型  0则为评论id  1则为回复id
		String[] ids = id.split(",");
		User user = (User)req.getSession().getAttribute("curUser");
		Date  date = new Date();
		String dateToString = DateUtil.dateToString(date);
		int myid = Integer.parseInt(ids[0]);
		Reply reply ;
		Integer toUserid;
		if("0".equals(ids[1])) {	
			// 当前id为评论id 根据此id查出数据  new reply
			Comment comment = commentService.selectByPrimaryKey(myid);
			reply = new Reply(null,comment.getEssayid(),comment.getId(),text,user.getId(),comment.getUserid(),dateToString);
			toUserid = comment.getUserid();
		}else {
			// 当前id 为 回复id
			System.out.println("++++++++++++");
			
			Reply pastReply = replyService.selectByPrimaryKey(myid);
			System.out.println(pastReply);
			reply = new Reply(null,pastReply.getEssayid(),pastReply.getCommitid(),text,user.getId(),pastReply.getFromuserid(),dateToString);
			toUserid = pastReply.getFromuserid();
		}
			//查出touser的信息
			User toUser = userService.selectByPrimaryKey(toUserid);
			Integer i = replyService.insertByReply(reply);

			if(i!=0) {
				//因为需要id 所以再次查询一次 获得id
				Reply myReply = replyService.selectByReply(reply);
				myReply.setFromUser(user);
				myReply.setToUser(toUser);
				return myReply;
			}		
		return "0";
	}
	
}

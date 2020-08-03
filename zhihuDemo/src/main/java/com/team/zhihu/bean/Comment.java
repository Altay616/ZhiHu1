package com.team.zhihu.bean;

import java.util.List;

public class Comment {
	private Integer id;

	private Integer essayid;

	private String context;

	private Integer userid;

	private String date;

	private User user;

	private Reply reply;
	private List<Reply> replyList;

	public List<Reply> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<Reply> replyList) {
		this.replyList = replyList;
	}

	public Reply getReply() {
		return reply;
	}

	public void setReply(Reply reply) {
		this.reply = reply;
	}

	public Comment(Integer id, Integer essayid, String context, Integer userid, String date, User user) {
		super();
		this.id = id;
		this.essayid = essayid;
		this.context = context;
		this.userid = userid;
		this.date = date;
		this.user = user;
	}

	public Comment() {
		super();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEssayid() {
		return essayid;
	}

	public void setEssayid(Integer essayid) {
		this.essayid = essayid;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context == null ? null : context.trim();
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date == null ? null : date.trim();
	}
}
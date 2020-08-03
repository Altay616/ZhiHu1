package com.team.zhihu.bean;

public class commentUser {
	private int id;
	private User user;
	private String context;
	private String date;
	public commentUser(int id, User user, String context,String date) {
		super();
		this.id = id;
		this.user = user;
		this.context = context;
		this.date = date;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	@Override
	public String toString() {
		return "commentUser [id=" + id + ", user=" + user + ", context=" + context + "]";
	}
	
}

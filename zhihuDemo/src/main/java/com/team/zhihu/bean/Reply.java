package com.team.zhihu.bean;

public class Reply {
    private Integer id;

    private Integer essayid;

    private Integer commitid;

    private String context;

    private Integer fromuserid;

    private Integer touserid;

    private String date;
    
    private User fromUser;
    private User toUser;
    
    public Reply() {
		super();
	}

	public Reply(Integer id, Integer essayid, Integer commitid, String context, Integer fromuserid, Integer touserid,
			String date, User fromUser, User toUser) {
		super();
		this.id = id;
		this.essayid = essayid;
		this.commitid = commitid;
		this.context = context;
		this.fromuserid = fromuserid;
		this.touserid = touserid;
		this.date = date;
		this.fromUser = fromUser;
		this.toUser = toUser;
	}
	
	public Reply(Integer id, Integer essayid, Integer commitid, String context, Integer fromuserid, Integer touserid,
			String date) {
		super();
		this.id = id;
		this.essayid = essayid;
		this.commitid = commitid;
		this.context = context;
		this.fromuserid = fromuserid;
		this.touserid = touserid;
		this.date = date;
		
	}

	public User getFromUser() {
		return fromUser;
	}

	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
	}

	public User getToUser() {
		return toUser;
	}

	public void setToUser(User toUser) {
		this.toUser = toUser;
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

    public Integer getCommitid() {
        return commitid;
    }

    public void setCommitid(Integer commitid) {
        this.commitid = commitid;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    public Integer getFromuserid() {
        return fromuserid;
    }

    public void setFromuserid(Integer fromuserid) {
        this.fromuserid = fromuserid;
    }

    public Integer getTouserid() {
        return touserid;
    }

    public void setTouserid(Integer touserid) {
        this.touserid = touserid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }
}
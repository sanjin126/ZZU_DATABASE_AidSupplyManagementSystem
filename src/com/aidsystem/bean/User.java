package com.aidsystem.bean;

public class User {
	private int id;
	private String userName;
	private String userPwd;
	private Integer volId;
	
	public User() {
		super();
	}
	/**
	 * 
	 * @Description 可空的属性：volId
	 */
	public User(int id, String userName, String userPwd, Integer volId) {
		super();
		this.id = id;
		this.userName = userName;
		this.userPwd = userPwd;
		this.volId = volId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public Integer getVolId() {
		return volId;
	}

	public void setVolId(Integer volId) {
		this.volId = volId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userPwd=" + userPwd + ", volId=" + volId + "]";
	}

	

	
}

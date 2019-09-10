package kr.or.ddit.user.model;

public class User {
	private String userId;
	private String userNm;
	private String alias;
	
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userNm=" + userNm + ", alias=" + alias + "]";
	}
	
	
	
	public User() {
		
	}
	public User(String userId) {
		this.userId = userId;
	}
	public User(String userId, String userNm, String alias) {
		this.userId = userId;
		this.userNm = userNm;
		this.alias = alias;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	
}

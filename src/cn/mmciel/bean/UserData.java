package cn.mmciel.bean;

public class UserData {
	private int userid;
	private String username;
	private String usermail;
	private String password;
	private int permission;
	
	public UserData() {
		
	}
	public UserData(String username,String usermail,String password,int permission) {
		this.password = password;
		this.username = username;
		this.usermail = usermail;
		this.permission = permission;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsermail() {
		return usermail;
	}
	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPermission() {
		return permission;
	}
	public void setPermission(int permission) {
		this.permission = permission;
	}
	
	
	
	
}

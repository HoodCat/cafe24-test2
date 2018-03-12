package com.cafe24.jblog.vo;

public class UserVo implements JBlogVo{
	private Long no;
	private String id;
	private String password;
	public UserVo(){
		
	}
	public UserVo(Long no, String id, String password) {
		super();
		this.no = no;
		this.id = id;
		this.password = password;
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserVo [no=" + no + ", id=" + id + ", password=" + password + "]";
	}
}

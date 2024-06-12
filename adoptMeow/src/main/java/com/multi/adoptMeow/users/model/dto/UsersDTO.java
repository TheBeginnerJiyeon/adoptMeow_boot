package com.multi.adoptMeow.users.model.dto;

import java.util.Date;

public class UsersDTO {
	
	private int no;
	private int userCategory;
	
	private String id;
	private String pw;
	private String name;
	private String tel;
	private Date createdDate;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public int getUserCategory() {
		return userCategory;
	}
	public void setUserCategory(int userCategory) {
		this.userCategory = userCategory;
	}
	@Override
	public String toString() {
		return "UsersDTO [no=" + no + ", userCategory=" + userCategory + ", id=" + id + ", pw=" + pw + ", name=" + name
				+ ", tel=" + tel + ", createdDate=" + createdDate + "]";
	}
	
	
	
	
	
	
	
	
	
	
	

}

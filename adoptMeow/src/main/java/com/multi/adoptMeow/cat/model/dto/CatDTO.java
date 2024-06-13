package com.multi.adoptMeow.cat.model.dto;

import java.util.Date;

public class CatDTO {
	
	private int rownum;
	
	private int id;
	private String name;
	private int catColorId;
	private String content;
	private int age;
	private String shelterId;
	private String img;
	private Date createdDate;
	private String createdPerson;
	private Date modifiedDate;
	private String modifiedPerson;
	private String status;
	
	
	
	
	public String getModifiedPerson() {
		return modifiedPerson;
	}
	public void setModifiedPerson(String modifiedPerson) {
		this.modifiedPerson = modifiedPerson;
	}
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCatColorId() {
		return catColorId;
	}
	public void setCatColorId(int catColorId) {
		this.catColorId = catColorId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getShelterId() {
		return shelterId;
	}
	public void setShelterId(String shelterId) {
		this.shelterId = shelterId;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedPerson() {
		return createdPerson;
	}
	public void setCreatedPerson(String createdPerson) {
		this.createdPerson = createdPerson;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "CatDTO [rownum=" + rownum + ", id=" + id + ", name=" + name + ", catColorId=" + catColorId
				+ ", content=" + content + ", age=" + age + ", shelterId=" + shelterId + ", img=" + img
				+ ", createdDate=" + createdDate + ", createdPerson=" + createdPerson + ", modifiedDate=" + modifiedDate
				+ ", status=" + status + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

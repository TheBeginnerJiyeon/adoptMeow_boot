package com.multi.adoptMeow.users.model.dto;

public class UsersCategoryDTO {
	
	private int cCode;
	private String cName;
	
	public int getcCode() {
		return cCode;
	}
	
	public void setcCode(int cCode) {
		this.cCode = cCode;
	}
	
	public String getcName() {
		return cName;
	}
	
	public void setcName(String cName) {
		this.cName = cName;
	}
	
	@Override
	public String toString() {
		return "UsersCategiryDTO{" +
				"cCode=" + cCode +
				", cName='" + cName + '\'' +
				'}';
	}
}

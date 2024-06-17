package com.multi.adoptMeow.users.model.dto;

public class UsersAuthorityDTO {

	private int authorityCode;
	private String authorityName;
	private String authorityDesc;
	
	public UsersAuthorityDTO() {
	}
	
	public UsersAuthorityDTO(int authorityCode, String authorityName, String authorityDesc) {
		this.authorityCode = authorityCode;
		this.authorityName = authorityName;
		this.authorityDesc = authorityDesc;
	}
	
	public String getAuthorityName() {
		return authorityName;
	}
	
	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}
	
	public String getAuthorityDesc() {
		return authorityDesc;
	}
	
	public void setAuthorityDesc(String authorityDesc) {
		this.authorityDesc = authorityDesc;
	}
	
	public int getAuthorityCode() {
		return authorityCode;
	}
	
	public void setAuthorityCode(int authorityCode) {
		this.authorityCode = authorityCode;
	}
	
	@Override
	public String toString() {
		return "UsersAuthorityDTO{" +
				"authorityCode=" + authorityCode +
				", authorityName='" + authorityName + '\'' +
				", authorityDesc='" + authorityDesc + '\'' +
				'}';
	}
}

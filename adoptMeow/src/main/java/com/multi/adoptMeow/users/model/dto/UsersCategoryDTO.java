package com.multi.adoptMeow.users.model.dto;

public class UsersCategoryDTO {
	
	private int cCode;
	private String cName;
	private UsersAuthorityDTO usersAuthorityDTO;
	
	
	
	public UsersCategoryDTO() {
	}
	
	public UsersCategoryDTO(int cCode, String cName, UsersAuthorityDTO usersAuthorityDTO) {
		this.cCode = cCode;
		this.cName = cName;
		this.usersAuthorityDTO = usersAuthorityDTO;
	}
	
	
	public UsersAuthorityDTO getAuthorityDTO() {
		return usersAuthorityDTO;
	}
	
	public void setAuthorityDTO(UsersAuthorityDTO authorityDTO) {
		this.usersAuthorityDTO = authorityDTO;
	}
	
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
		return "UsersCategoryDTO{" +
				"cCode=" + cCode +
				", cName='" + cName + '\'' +
				", authorityDTO=" + usersAuthorityDTO +
				'}';
	}
}

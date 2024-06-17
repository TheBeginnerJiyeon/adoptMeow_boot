package com.multi.adoptMeow.authentication.model.dto;

import com.multi.adoptMeow.users.model.dto.UsersCategoryDTO;
import com.multi.adoptMeow.users.model.dto.UsersDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public class CustomUser extends User {
	
	private int no;
	private int userCategory;
	
	private String id;
	private String pw;
	private String name;
	private String tel;
	private Date createdDate;
	
	private List<UsersCategoryDTO> usersCategoryDTOList;
	
	
	public CustomUser(UsersDTO usersDTO, Collection<? extends GrantedAuthority> authorities) {
		super(usersDTO.getId(), usersDTO.getPw(), authorities);
		setDetails(usersDTO);
	}
	
	/*public CustomUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}*/
	
	public void setDetails(UsersDTO usersDTO){
		
		this.no = usersDTO.getNo();
		this.userCategory = usersDTO.getUserCategory();
		this.id = usersDTO.getId();
		this.pw = usersDTO.getPw();
		this.name = usersDTO.getName();
		this.tel = usersDTO.getTel();
		this.createdDate = usersDTO.getCreatedDate();
		this.usersCategoryDTOList = usersDTO.getUsersCategoryDTOList();
	}
	
	public List<UsersCategoryDTO> getUsersCategoryDTOList() {
		return usersCategoryDTOList;
	}
	
	public void setUsersCategoryDTOList(List<UsersCategoryDTO> usersCategoryDTOList) {
		this.usersCategoryDTOList = usersCategoryDTOList;
	}
	
	@Override
	public String toString() {
		return "CustomUser{" +
				"no=" + no +
				", userCategory=" + userCategory +
				", id='" + id + '\'' +
				", pw='" + pw + '\'' +
				", name='" + name + '\'' +
				", tel='" + tel + '\'' +
				", createdDate=" + createdDate +
				", usersCategoryDTOList=" + usersCategoryDTOList +
				'}';
	}
	
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public int getUserCategory() {
		return userCategory;
	}
	
	public void setUserCategory(int userCategory) {
		this.userCategory = userCategory;
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
	
	
}

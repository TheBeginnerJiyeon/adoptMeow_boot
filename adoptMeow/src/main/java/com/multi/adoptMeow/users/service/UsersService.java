package com.multi.adoptMeow.users.service;


import com.multi.adoptMeow.users.model.dto.UsersCategoryDTO;
import com.multi.adoptMeow.users.model.dto.UsersDTO;

import java.util.ArrayList;

public interface UsersService {

	public UsersDTO login(UsersDTO usersDTO) throws Exception;

	public int insertUser(UsersDTO usersDTO) throws Exception;

	public int updateUser(UsersDTO usersDTO) throws Exception;
	
	
	ArrayList<UsersCategoryDTO> usersCategoryGet() throws Exception;
}

package com.multi.adoptMeow.users.model.dao;

import com.multi.adoptMeow.users.model.dto.UsersCategoryDTO;
import com.multi.adoptMeow.users.model.dto.UsersDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;


@Mapper
public interface UsersMapper {

	public UsersDTO selectOne(UsersDTO usersDTO);
	
	public UsersDTO selectOneById(String usersId);

	public int insertUser(UsersDTO usersDTO);

	public int updateUser(UsersDTO usersDTO);
	
	ArrayList<UsersCategoryDTO> selectCategoryList();
}

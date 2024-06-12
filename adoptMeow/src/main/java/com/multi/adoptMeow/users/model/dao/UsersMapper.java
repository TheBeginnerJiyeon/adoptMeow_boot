package com.multi.adoptMeow.users.model.dao;

import com.multi.adoptMeow.users.model.dto.UsersDTO;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UsersMapper {

	public UsersDTO selectOne(UsersDTO usersDTO);

	public int insertUser(UsersDTO usersDTO);

	public int updateUser(UsersDTO usersDTO);

}

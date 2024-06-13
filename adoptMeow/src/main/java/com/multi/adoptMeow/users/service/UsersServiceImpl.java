package com.multi.adoptMeow.users.service;


import com.multi.adoptMeow.users.model.dao.UsersMapper;
import com.multi.adoptMeow.users.model.dto.UsersCategoryDTO;
import com.multi.adoptMeow.users.model.dto.UsersDTO;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@EnableAspectJAutoProxy
@Transactional(rollbackFor = {Exception.class})
@Service("userService")
public class UsersServiceImpl implements UsersService {
	
	private final UsersMapper usersMapper;

	/*@Autowired
	private SqlSessionTemplate sqlSessionTemplate;*/
	
	public UsersServiceImpl(UsersMapper usersMapper) {
		super();
		this.usersMapper = usersMapper;
	}

	/*@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;*/
	
	@Override
	public UsersDTO login(UsersDTO usersDTO) throws Exception {
		
		UsersDTO loginDto = usersMapper.selectOne(usersDTO);
		
		if (loginDto == null) {
			System.out.println("아이디 자체가 없음...");
			throw new Exception("아이디 자체가 없음...");
		} /*else if (!bCryptPasswordEncoder.matches(usersDTO.getPw(), loginDto.getPw())) {
			System.out.println("비밀번호 불일치...");
			throw new Exception("비밀번호 불일치......");
		}*/ else if (!usersDTO.getPw().equals(loginDto.getPw())) {
			System.out.println(usersDTO.getPw());
			System.out.println(loginDto.getPw());
			
			System.out.println("비밀번호 불일치...");
			throw new Exception("비밀번호 불일치......");
		}
		
		return loginDto;
	}
	
	@Override
	public int insertUser(UsersDTO usersDTO) throws Exception {

		/*String encPw = bCryptPasswordEncoder.encode(usersDTO.getPw());

		usersDTO.setPw(encPw);
*/
		int result = usersMapper.insertUser(usersDTO);
		
		return result;
		
	}
	
	@Override
	public int updateUser(UsersDTO usersDTO) throws Exception {

		/*String encPw = bCryptPasswordEncoder.encode(usersDTO.getPw());

		usersDTO.setPw(encPw);*/
		
		int result = usersMapper.updateUser(usersDTO);
		
		return result;
		
	}
	
	@Override
	public ArrayList<UsersCategoryDTO> usersCategoryGet() throws Exception {
		
		ArrayList<UsersCategoryDTO> list = usersMapper.selectCategoryList();
		
		return list;
	}
	
}

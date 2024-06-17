package com.multi.adoptMeow.authentication.service;

import com.multi.adoptMeow.authentication.model.dto.CustomUser;
import com.multi.adoptMeow.users.model.dao.UsersMapper;
import com.multi.adoptMeow.users.model.dto.UsersCategoryDTO;
import com.multi.adoptMeow.users.model.dto.UsersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	
	private final UsersMapper usersMapper;
	
	@Autowired
	public AuthenticationServiceImpl(UsersMapper usersMapper) {
		this.usersMapper = usersMapper;
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		
		System.out.println("loadUserByUsername(String username)");
		System.out.println("userId : " + userId);
		
		UsersDTO usersDTO = usersMapper.selectOneById(userId);
		System.out.println("선택된 유저: " + usersDTO);
		
		if (usersDTO == null) {
			throw new UsernameNotFoundException("유저 아이디가 없습니다");
		}
		
		List<UsersCategoryDTO> usersCategoryDTOList = usersDTO.getUsersCategoryDTOList();
		System.out.println("usersCategoryDTOList : " + usersCategoryDTOList);
		
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		usersCategoryDTOList.forEach(usersCategoryDTO -> {
			
			System.out.println("usersCategoryDTO.getAuthorityDTO().getAuthorityName() : " + usersCategoryDTO.getAuthorityDTO().getAuthorityName());
			
			authorities.add(new SimpleGrantedAuthority(usersCategoryDTO.getAuthorityDTO().getAuthorityName()));
			
		});
		
		System.out.println("usersCategoryDTO.getAuthorityDTO().getAuthorityName() : " + authorities);
		
		return new CustomUser(usersDTO, authorities);
		
		
	}
	
	@Override
	public Map<String, List<String>> getPermitUrlListMap() {
		
		Map<String, List<String>> permitUrlListMap = new HashMap<>();
		List<String> adminPermitUrlList = new ArrayList<>();
		List<String> usersPermitUrlList = new ArrayList<>();
		
		adminPermitUrlList.add("/admin/**");
		adminPermitUrlList.add("/shelter/**");
		
		usersPermitUrlList.add("/cat/**");
		usersPermitUrlList.add("/chat/**");
		usersPermitUrlList.add("/board/**");
		usersPermitUrlList.add("/common/**");
		
		permitUrlListMap.put("adminPermitUrlList", adminPermitUrlList);
		permitUrlListMap.put("usersPermitUrlList", usersPermitUrlList);
		
		
		return permitUrlListMap;
		
		
	}
}

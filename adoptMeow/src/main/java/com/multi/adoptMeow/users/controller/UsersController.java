package com.multi.adoptMeow.users.controller;

import com.multi.adoptMeow.users.model.dto.UsersDTO;
import com.multi.adoptMeow.users.service.UsersService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/users")
public class UsersController {

	private final UsersService usersService;

	public UsersController(UsersService usersService) {
		super();
		this.usersService = usersService;
	}

	@RequestMapping("/main")
	public String main() {

		String page = "redirect:/";

		return page;

	}
	
	
	@RequestMapping("/usersMain")
	public void usersMain() {

	}
	

	@RequestMapping("/insert_form")
	public void insertForm() {

	}

	@RequestMapping("/modify_form")
	public void modifyForm() {

	}

	@RequestMapping("/login")
	public String login(UsersDTO usersDTO, HttpSession httpSession) {

		UsersDTO loginDto = null;
		try {
			loginDto = usersService.login(usersDTO);

			if (loginDto == null) {
				// 오류를 이미 서비스 임플에서 잡아놔서 굳이 할 필요 없을 거 같긴 한데 왜 넣었지
				throw new Exception("로그인 실패!! 아이디가 없음..");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		httpSession.setAttribute("loginUser", loginDto);
		httpSession.setAttribute("loginUser2", usersDTO);

		/* redirectAttributes.addAttribute("loginUser",loginDto); */

		String page = "redirect:/";

		return page;

	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {

		session.invalidate();

		String page = "redirect:/";

		return page;

	}

	@RequestMapping("/insert")
	public void insertUser(UsersDTO usersDTO) {

		int result;
		try {
			result = usersService.insertUser(usersDTO);

			if (result < 0) {
				throw new Exception("회원가입 실패!!");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping("/update")
	public void updateUser(UsersDTO usersDTO, HttpSession httpSession) {

		UsersDTO loginDto = (UsersDTO) httpSession.getAttribute("loginUser");

		loginDto.setUserCategory(usersDTO.getUserCategory());
		loginDto.setId(usersDTO.getId());
		loginDto.setPw(usersDTO.getPw());
		loginDto.setName(usersDTO.getName());
		loginDto.setTel(usersDTO.getTel());

		System.out.println("loginDto modified: " + loginDto);

		int result;
		try {
			result = usersService.updateUser(loginDto);

			if (result < 0) {
				throw new Exception("회원수정 실패!!");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

package com.multi.adoptMeow.shelter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/shelter") // ** 는 모든 하위 폴더 전부
public class ShelterController {
	

	
	@RequestMapping("/main")
	public String Main() {
		
		return "redirect:/";
	}
	
	@RequestMapping("/shelterMain")
	public void shelterMain() {
	
	}
	
	
}

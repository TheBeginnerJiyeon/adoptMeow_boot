package com.multi.adoptMeow.common.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

	@GetMapping(value = {"/","/main"})
	public String main() {
		return "common/main";
	}

	@PostMapping("/")
	public String redirectMain() {
		return "redirect:/";
	}
	
	@GetMapping("/test")
	public String testPage() {
		return "test";
	}

}

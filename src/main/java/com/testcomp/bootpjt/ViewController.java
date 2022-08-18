package com.testcomp.bootpjt;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class ViewController {
	
	// 메인 페이지
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	// 사용자 등록 페이지
	@GetMapping("/signup_view")
	public String signupView() {	
		return "user/signup_view";
	}
}

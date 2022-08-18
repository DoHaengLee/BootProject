package com.testcomp.bootpjt;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class ViewController {
	
	// ���� ������
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	// ����� ��� ������
	@GetMapping("/signup_view")
	public String signupView() {	
		return "user/signup_view";
	}
}

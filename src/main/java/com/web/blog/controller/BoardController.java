package com.web.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
	
	@GetMapping("/")
	public String index() {
		return "index"; //yml에 prefix,suffix 설정 했기에 이렇게 가능.
	}
}

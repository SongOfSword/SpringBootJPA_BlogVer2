package com.web.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {
	
	// http://localhost:8080/blog/temp/home
	@GetMapping("/temp/home")
	public String tempHome() {
		// 스프링의 @Controller 애노테이션은 html파일을 리턴하게 되는데
		// 기본 경로가 src/main/resources/static
		// 그렇다면 아래 메소드에서 파일을 리턴할 때 "/"를 붙여주지 않는다면
		// src/main/resources/statichome.html이 된다. 그래서 "/"를 붙여주어야 된다.
		// 참고로 static폴더는 html같은 정적타입의 파일 즉 브라우저가 인식할 수 있는 파일만 놓는다.
		// (이미지파일도 정적파일에 해당)
		// templates에는 thymeLeaf , jsp같은 동적파일을 넣는다.(동적파일은 컴파일이 필요하다.)
		System.out.println("tempHome()");
		return "/home.html";
	}
	
	@GetMapping("/temp/img")
	public String tempImg() {
		return "/a.jpg";
	}
	
	@GetMapping("/temp/jsp")
	public String tempJsp() {
		
		return "test";
	}
}

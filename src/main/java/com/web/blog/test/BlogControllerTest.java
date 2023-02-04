package com.web.blog.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogControllerTest {
	
	// 스프링이 내가 만든 com.web.blog이하를 스캔해서 메모리힙에 띄우는 것은 아니고
	// 특정 애노테이션이 붙어 있는 클래스 파일들만 new해서(IoC)해서 스프링 컨테이너에 관리해준다.
	@GetMapping("/test/hello")
	public String hello() {
		
		int sum = 0;
		for(int i=0; i<10; i++) {
			sum += i;
//			for(int j=0; j<10; j++) {
//				
//			}
		}
		String result = "It's "+sum;
		return result;
	}
	
}

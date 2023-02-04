package com.web.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
// 사용자의 요청 -> 응답(HTML파일)
// @Controller

// 사용자의 요청 -> 응답(Data)
@RestController
public class HttpControllerTest {
	
	public static final String tag = "HttpControllerTest:";
	
	@GetMapping("/http/lombok")
	public String lombokTest() {
		Member m = Member.builder().email("just@naver.com").password("1234").username("just").build();
		System.out.println(tag + "getter:"+m.getId());
		m.setId(5000);
		System.out.println(tag +"setter:" + m.getId());
		return "Lombok테스트 완료!";
		
	}
	
	// 인터넷 브라우저 요청은 get요청밖에 할수 없다.
	// http://localhost:8080/http/get
	@GetMapping("/http/get")
	//public String getTest(@RequestParam int id, @RequestParam String username)
	public String getTest(Member m) {
		
		//return "get要請"+"id:"+id+","+"username:"+username;
		return m.getId() +","+ m.getUsername();
	}

	// MesageBody에 요청 내용을 넣어서 보내기 때문에 오브젝트 혹은 @RequestBody를 사용해서 받는다.
	@PostMapping("/http/post")
	//public String postTest(@RequestBody int id, @RequestBody String username)
	//public String postTest(@RequestBody Member m) <- Json타입의 요청을 받을 때
	public String postTest(@RequestBody Member m) {
		return "post要請"+","+m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
	}
	
	@PutMapping("/http/put")
	public String putTest() {
		return "put要請";
	}
	
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete要請";
	}
}

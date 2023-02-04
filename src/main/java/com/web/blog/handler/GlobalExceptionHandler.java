package com.web.blog.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

// 어디에서든 Exception이 발생하면 이 클래스가 실행되도록 하기 위해 @ControllerAdvice
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

	// ExceptionHandler 애노테이션을 걸어주고 어떤 익셉션에 이 메소드가 반응할지 value지정
	@ExceptionHandler(value=IllegalArgumentException.class)
	public String handleArgumentException(IllegalArgumentException e) {
		return "<h2>"+e.getMessage()+"</h2>";
	}
}

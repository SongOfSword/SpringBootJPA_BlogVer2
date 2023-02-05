package com.web.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.blog.model.User;
import com.web.blog.repository.UserRepository;

import jakarta.transaction.Transactional;

// @Service를 붙여주어야지 스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌.즉 IoC를 해줌.
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public int save(User user) {
		try {
			userRepository.save(user);
			return 1;
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("UserService(회원가입):"+e.getMessage());
		}
		return -1;
	}
}

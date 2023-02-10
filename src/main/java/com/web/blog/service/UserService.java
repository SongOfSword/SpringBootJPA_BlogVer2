package com.web.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.blog.model.User;
import com.web.blog.repository.UserRepository;

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

	@Transactional(readOnly = true) //select할 때 트랜잭션이 시작되고, 서비스 종료시에 종료. 정합성(데이터일관성) 유지.
	public User login(User user) {
		System.out.println(user);
		return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
	}
}

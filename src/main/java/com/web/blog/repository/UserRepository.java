package com.web.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.blog.model.User;

//★해당 JpaRepository는 User테이블을 관리하는 레파지토리야, 그리고 해당 테이블의 프라이머리키는 Integer야!
// JPA의 쿼리에 관한 담당은 JpaRepository인터페이스라고 이해하면 쉬울듯.
// 이 인터페이스 안에 CRUD혹은 기타에 관한 메소드들이 구현돼 있음.
// 그래서 직접 구현을 하지 않아도 됨.
// 기본적인 CRUD만 필요하다면 아무것도 작성하지 않고 이대로 상속만 하고 코드를 작성하지 않으면 된다.
// JSP로 치면 여기가 DAO(Database Access Object)

// 스프링 레거시는 
//@Repository 라고 애노테이션을 붙여 주어야 컴포넌트 스캔해서 메모리에 띄워주어 사용했는데 부트는 필요없이 자동으로 된다.
public interface UserRepository extends JpaRepository<User, Integer>{
	
}

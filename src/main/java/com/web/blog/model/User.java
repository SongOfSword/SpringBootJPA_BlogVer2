package com.web.blog.model;

import java.sql.Timestamp;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
// ※테이블 생성시에는 작업관리자 서비스에 mysql이 실행중이어야 한다.
// ※ORM: Java든 다른 언어든간에 Object -> 테이블로 매핑해주는 기술.
// ※밑에 클래스의 코드를 아무거나 바꾸고 저장하면 db에 바로 반영이 된다.

//@Entity스프링이 실행될 때 User클래스를 통해서, 아래 변수들을 통해서 자동으로 mysql에 테이블이 생성된다.
@Data	//겟터,셋터
@NoArgsConstructor	//빈생성자
@AllArgsConstructor	//필드전체 생성자
@Builder //빌더 패턴
@Entity  //ORM클래스라고 알려주는 애노테이션, 데이터베이스에 매핑을 시켜주는 클래스다라는 의미.
//@DynamicInsert insert할 때 null인 값은 쿼리문 자체에서 빼버린다. 그리면 아래role default애노테이션이 작동이 가능하다.
public class User {
	
	@Id             // primaryKey
	@GeneratedValue(strategy = GenerationType.IDENTITY) //넘버링 전략=
	//IDENTITY-프로젝트에서 연결된 DB의 넘버링 전략을 따라가겠다.
	// (즉 오라클을 연결하면 시퀀스, 마이에스큐엘 연결하면 auto_increment를 사용하겠다는 의미)
	//SEQUENCE-무조건 시퀀스를 사용하겠다.
	//AUTO-자동으로 맞추어지는.
	//TABLE-테이블에 번호를 만들어두고 그 번호를 사용하겠다.
	private int id; //(Oracle)sequence, (mysql)auto_increment
	
	// @Column애노테이션은 칼럼에 대한 세부설정을 해줄 수 있다.
	@Column(nullable = false, length=30, unique = true) // 유저네임은 null이 될수 없고, 아이디는 최대 30자, 유니크=중복 불가
	private String username; 	//아이디
	
	@Column(nullable = false, length=100) //비밀번호 길게 주는 이유는 =>해쉬(암호화 해서 db에 넣기위해)
	private String password;
	
	@Column(nullable = false, length=50)
	private String email;
	
	//@ColumnDefault("'user'") //기본권한을user로 하게해준다.특이점은 홑따옴표안에 넣어야 함.(varchar)
	@Enumerated(EnumType.STRING) // DB에는 RoleType이 없으므로 이 애노테이션으로 해당 enum은 String임을 명시.
	private RoleType role; // Enum을 쓰는게 좋다.(도메인을 지정한다는 의미) ex)Admin, manager, user
	// String으로 하면 입력시 magagerrrr같은 입력 오류가 발생할 수 도 있는데 Enum은 저 세개를 설정하면
	// 세개중에서만 입력이 가능하도록 해줄수 있다. 다른 예로 남,녀 를 입력하는 항목이라든지에서 사용가능.
	// Enum에 대해서는 필요할 때 공부하자.
	
	@CreationTimestamp  //오라클의 sysdate같은 , 회원가입시 자바에서 시간을 자동입력 해준다.
	private Timestamp createDate;  //java.sql의 Timestamp타입
	
	//이렇게 설정하면 데이터 입력시 즉 회원가입시 프라이머리키인 ID랑 시간은 자동이므로 입력 필요없다.
}
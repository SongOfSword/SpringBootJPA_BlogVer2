package com.web.blog.model;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder //빌더 패턴
@Entity  //ORM클래스라고 알려주는 애노테이션, 데이터베이스에 매핑을 시켜주는 클래스다라는 의미.
public class Reply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	// 댓글은 누가 썼고, 어느글의 댓글인지 알아야 하기에 두개의 조인이 필요.
	
	@ManyToOne  // 여러개의 게시글은 하나의 유저에 의해 작성되어 질 수있다.
	@JoinColumn(name = "userId")
	private User user;
	
	@ManyToOne  // 여러개의 게시글은 하나의 글 밑에 달릴 수 있다.
	@JoinColumn(name = "boardId")
	private Board board;
	
	@CreationTimestamp
	private Timestamp createDate;
}
package com.web.blog.model;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder //빌더 패턴
@Entity  //ORM클래스라고 알려주는 애노테이션, 데이터베이스에 매핑을 시켜주는 클래스다라는 의미.
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob  // 데이터 타입을 Lob으로 잡는다. (대용량 데이터일 때)
	private String content; // 섬머노트 라이브러리, <html>태그가 섞여서 디자인이 됨.
	
	@ColumnDefault("0") // 데이터타입 int이므로 홑따옴표 x
	private int count;
	
	@ManyToOne(fetch = FetchType.EAGER) 
	// Default fetch전략(지정안해도): EAGER -> Board조회하면 얘는 무조건 join해서 들고올게.
	// FetchType.LAZY전략은 요구하면 들고올게.
	
	// To앞부분은 현재 클래스, 뒷부분은 Join하는 클래스 , 연관관계 설정이다.
	// Many = Board, One = User 인데
	// 여러게시글은 한 유저에 의해 씌여진다. O
	// 여러유저는 하나의 게시글을 쓴다는 말이 안되기에 X.  이런 느낌이다.
	@JoinColumn(name = "userId")  //Join해서 생성하는 외래키 칼럼명은 userId
	//private int userId; 원래라면 이렇게 선언해서 이 id로 user테이블에서 해당 유저를 찾거나
	// 아니면 이 아이디로 user테이블과 조인을 해서 누가 글쓴이인지 찾게 되는데
	// 역설계 즉 Entity를 먼저 만드는 현재 방식에서 오브젝트 타입으로 설정을 해주면
	// 테이블 만들 때 알아서 FK즉 ForeignKey로 만들어 준다.
	// DB는 오브젝트를 인식할 수 없기 때문에 자바가 알아서 오브젝트를 DB에 맞춰서 생성하게 해준다.
	// 실제 DB에는 integer타입으로 FK가 생성된다. User의 Id와 조인되니까 JPA가 User오브젝트로 가서 타입확인까지 한다.
	private User user;
	
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
	//뭘로 관계를 맺고 있는지 오브젝트 변수명을 지정해준다.
	// 한마디로 난 연관관계의 주인이 아니다.(FK가 아니다.) DB에 컬럼을 만들지 말어라. 라는 의미.
	
	//하나의 게시글에는 여러개의 댓글이 달린다. 그러면 Select결과는 여러개가 될것이므로 List타입으로 선언해서 받는다.
	// 여기에서는 단순 조회를 하는 것이 목적이고 이 댓글의 Fk는 필요없기 때문에 조회를 위해 단순 관계만 명시해준다.
	// 그러므로 JoinColumn항목은 쓰면 안된다. @JoinColumn은 실제로 칼럼을 이 클래스테이블에 생성해준다.
	private List<Reply> reply;
	
	@CreationTimestamp // 데이터가 insert,update 될때 자동으로 시간을 넣어줌.
	private Timestamp createDate;
}

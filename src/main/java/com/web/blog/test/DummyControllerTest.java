package com.web.blog.test;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.blog.model.RoleType;
import com.web.blog.model.User;
import com.web.blog.repository.UserRepository;

import jakarta.transaction.Transactional;

@RestController
public class DummyControllerTest {
	
	//의존성 주입! D I !
	@Autowired 
	//★★★위 클래스가 컴포넌트 스캔될때 레퍼런스(참조)변수타입(클래스,인터페이스)이 
	//메모리에 떠있다면 값을 가져와서 변수에 넣어줘라. 아래는 떠있다, 왜냐면 JpsRepository상속-> 자동스캔
	// 상속된 인터페이스의 내부를 사용할 땐 이렇게 필드에 참조형으로 선언해서 인잭션 받고 사용 !!!
	// ★★★ 위의 @Autowired가 없다면 userRepository는 DI를 못받아서 null값으로 존재.
	private UserRepository userRepository;
	
	// 유저 전체를 가져오는 메소드
	@GetMapping("/dummy/users")
	public List<User> list(){
		return userRepository.findAll();
	}
	
	// 페이징을 나누어 주는 메소드
	//@PageableDefault로 속성을 지정해준다. 
	//size-페이지당 데이터수, sort-분류기준 즉 무엇을 기준으로 순서를 매길것인가.
	//direction-데이터 순번 기준
	// 즉 페이지당 데이터수2, id로 sort(분류)할거고 내림차순으로 분류할거야.
	// Pageable - import org.springframework.data.domain.Pageable;
	// http://localhost:8080/blog/dummy/user?page=0 <== 첫번째 페이지
	@GetMapping("/dummy/user")
	public List<User> pageList(@PageableDefault(size=1, sort="id", direction= Sort.Direction.DESC) Pageable pageable){
		// findAll()은 page에 대한 여러 정보들이 담기는 Page를 리턴한다. .
		Page<User> pagingUser = userRepository.findAll(pageable); // 여기까지면 그 Page의 정보 모두를 가져온다.
//		if(pagingUser.isLast()) {
//			첫번째 데이터라면 혹은 마지막 데이터라면...
// 			이러한 메소드도 지원한다.
//		}
		List<User> users = pagingUser.getContent(); // 위에서 꺼내온 JSON데이터에서 Content 부분만 빼내어 리턴.
		return users;
	}
	
	//{id}로 파라미터를 전달 받을 수 있다.
	// http://localhost:8080/blog/dummy/user/3
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		// user/4를 요청하면 내가 데이터베이스에서 못찾아 오면 user가 null이 될것인데,
		// 그러면 return값이 null이 된다. 그럼 프로그램에 문제가 있지 않을까?
		// 그래서 Optional로 User객체를 감싸서 가져올테니 null인지 아닌지 판단해서 리턴 해!
		// So, userRepository.findById(id); 라면 Optional에 감싸진 Optional타입의 객체를 얻게 된다.
		// 여기에서 
		// 1. .get()을 하면 Optional에서 바로 데이터를 뽑게 되는데 null이 절대로 발생할 가능성이 없다면 이걸로 가능.
		// 2. .orElseGet()은 null일 경우 인터페이스 Supplier의 메소드를 오버라이딩해서 빈객체를 만들어 준다.
		// (인터페이스는 new할수 없고 익명클래스를 생성해주어야 됨.)
		// 여기에서는 new 하면서 메소드 오버라이딩...(요부분 이해가 잘안됨.)
		// 아무튼 정상적으로 데이터를 가져왔다면 .orElseGet()은 실행되지 않는다.
		// 이방법은 스프링이 선호하는 방법이 아니다.
		// select결과 null일 경우 2.
//		User user = userRepository.findById(id).orElseGet(new Supplier<User>() {
//			@Override
//			public User get() {
//				return new User(); // 빈 객체를 만들어서 리턴. 그러면 적어도 null은 아님.
//			}
//		});
		
		// select결과 null일 경우 3.
		// IllegalArgument(잘못된 아규먼트)Exception을 날리는 방법.
		// null값이 온다면 아래 사진에서처럼 에러메시지와 함께 뜰텐데,
		// 나중에 이 에러를 가로채서 에러페이지로 이동시키는 방식도 가능하다.
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {

			@Override
			public IllegalArgumentException get() {
				return new IllegalArgumentException("해당 유저는 없습니다. id: "+id); // 해당 Exception에 메시지 동봉.
			}
			
		});
		
//		User user = userRepository.findById(id).orElseGet(new Supplier<User>() {
//
//			@Override
//			public User get() {
//				return new User();
//			}
//			
//		});
		return user;
	}
	
	// 회원가입시 user엔티티 클래스를 살펴보면
	// id, createDate, role 등은 자동으로 생성되고 필요한건 username, password, email이 되겠다.
	@PostMapping("/dummy/join")
	public String join(User user) {
		
		System.out.println("id: " + user.getId());
		System.out.println("username: " + user.getUsername());
		System.out.println("password: " + user.getPassword());
		System.out.println("email: " + user.getEmail());
		System.out.println("role: " + user.getRole());
		System.out.println("createDate: " + user.getCreateDate());
		
		user.setRole(RoleType.USER);
		// user객체를 그냥 집어 넣으면 됨.
		userRepository.save(user);
		
		return "회원가입이 완료되었습니다.";
		
	}
	
	// 수정할 때는 PutMapping
	// 위에 다른 메소드랑 주소가 같지만 매핑 형태가 다르기 때문에 알아서 구분한다.
	// Form태그로 데이터를 받으면 파라미터를 User user 이런식으로 받지만, JSON으로 받을때는 RequestBody로.
	// 여기도 마찬가지로 클라이언트 측에서 JSON데이터를 보내면서 요청을 하면 컨트롤러에서는 MessageConverter가 작동해서
	// JSON을 자바 Object로 자동 변환을 해준다.
	
	// save함수는 id를 전달하지 않으면 insert를 해주고
	// save함수는 id를 전달하면 해당 id에 대한 데이터가 있으면 update를 해주고
	// save함수는 id를 전달하면 해당 id에 대한 데이터가 없으면 insert를 해준다.
	@Transactional  //이 @Transactional을 걸어주면 save를 하지 않아도 요청을 받으면 저장이 된다.
	@PutMapping("/dummy/user/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User RequestUser) {
		
		System.out.println("id: "+id);
		System.out.println("password: "+RequestUser.getPassword());
		System.out.println("email: "+RequestUser.getEmail());
		
		// 요청받은 id로 해당유저 찾아와서 객체에 셋팅후 저장하는 방법.
		User user = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("해당 유저는 없습니다. id: "+id);
		});
		user.setPassword(RequestUser.getPassword());
		user.setEmail(RequestUser.getEmail());
//		userRepository.save(user);
		
		return user;
	}
	
	// 삭제
	@DeleteMapping("/dummy/delete/{id}")
	public String delete(@PathVariable int id) {
		
		try {
			userRepository.deleteById(id); // return값이 없기 때문에 에러를 대비해서 
		}catch (EmptyResultDataAccessException e) { 
			// 모든 Exception은 Exception 클래스의 자식이다.
			// 위에 것은 빈결과 익셉션을 딱 찍어서 한 익셉션을 잡아준 것이고 그냥 Exception타입으로 선언하면 토탈로 잡아준다.
			return "삭제가 실패하였습니다. 해당 id는 없는id입니다.";
		}
		return "삭제가 완료되었습니다.";
	}
}

// index객체를 만듬.
// 객체는 아무것도 하지 않기 때문에, 실행은 아래에서처럼 
let index = {
	init : function(){
		// 이부분 이렇게 안해주면 에러가 뜨는데, 나중에 이유를 알아보자.
		// Error: this.save is not a function
		let self = this;
		//$('#btnSubmit').on('click', ()=>{
		//	this.save(); // 위에 람다식을 사용하지 않으면 여기this는 window를 가리킨다. 밑에 코드처럼. 
		//});            // 바인딩? 하기위해 람다식 사용. 자세한 이유는 나중에 공부하자.
		// 람다식 사용하거나 or let self = this; 처럼 this를 변수에 넣어서 명시하거나
		document.getElementById('btnSubmit').onclick = function(){
			self.save();
		};
	},
	save : function(){
		let data = {
			username : document.getElementById("username").value,
			password : document.getElementById("pwd").value,
			email : document.getElementById("email").value
		};
	
		let xhr = new XMLHttpRequest();
		xhr.open("POST", "/blog/api/user", true);
		xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
		xhr.send(JSON.stringify(data));
	
		xhr.onreadystatechange = function(result) {
			if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
				alert("회원가입이 완료되었습니다.");
				console.log(result);
				//location.href = "/blog";
			} else if (xhr.readyState === XMLHttpRequest.DONE) {
				console.error(xhr.responseText);
			}
		};
	}
}

index.init();
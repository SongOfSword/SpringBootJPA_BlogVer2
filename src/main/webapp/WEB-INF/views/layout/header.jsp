<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!-- 
	//principal은 현재 current오브젝트에 접근을 허용.
	//var는 그 변수에 저장을 해준다는 의미. 즉 매핑을 해서 해당 페이지에서 해당 변수로 사용이 가능케 해준다.
	// 즉 이 변수명이 세션명이 되는것.
 -->
<sec:authorize access="isAuthenticated()"> <!-- 로그인이 유효한지 자체적 입증하는 메소드 -->
		<sec:authentication property="principal" var="principal" />
</sec:authorize>

<!DOCTYPE html>
<html lang="en">

<head>
<title>Blog Example</title>
    
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<h1>${principal}</h1>
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <div class="container-fluid">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" href="/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/board/form">Write</a> <!-- / = context-path -->
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/user/form">Member Info</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/logout">Logout</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/loginForm">Login</a> <!-- / = context-path -->
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/joinForm">Sign up</a>
                </li>
            </ul>
        </div>
    </nav>
</body>

</html>
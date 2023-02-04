<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="kr">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <div class="container-fluid">
	    <ul class="navbar-nav">
	      <li class="nav-item">
	        <a class="nav-link active" href="/blog">Home</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/user/login">Login</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/user/join">Sign up</a>
	      </li>
	    </ul>
	  </div>
	</nav>
	<br>
	
	<div class="container">
		<% for(int i=0; i<3; i++){%>
			<div class="card m-2"> <!-- m-2 마진2 -->
			  <div class="card-body">
			    <h4 class="card-title">Title</h4>
			    <p class="card-text">Some example text.</p>
			    <a href="#" class="btn btn-primary">Detail</a>
		 	  </div>
			</div>
		<%}%>
	</div>
	
	<div class="mt-5 p-4 bg-dark text-white text-center">
	  <p>Created By J404</p>
	  <p>🪶: j404@naver.com</p>
	  <p>⛰️: 東京都 新宿区</p>
	</div>
</body>
</html>
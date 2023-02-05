<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Blog Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <div class="container-fluid">
	    <ul class="navbar-nav">
	      <li class="nav-item">
	        <a class="nav-link active" href="/blog">Home</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/blog/user/loginForm">Login</a> <!-- / = context-path -->
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/blog/user/joinForm">Sign up</a>
	      </li>
	    </ul>
	  </div>
	</nav>
</body>
</html>
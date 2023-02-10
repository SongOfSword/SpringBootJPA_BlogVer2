<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Blog Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<%@ include file="layout/header.jsp" %>
</head>
<body>
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
<%@ include file="layout/footer.jsp" %>
</body>
</html>
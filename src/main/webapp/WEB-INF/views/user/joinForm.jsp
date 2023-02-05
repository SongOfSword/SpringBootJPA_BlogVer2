<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Blog Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <%@ include file="../layout/header.jsp" %>
</head>

<body>
    <br>
    <div class="container">
    
        <form>
            <div class="mb-3 mt-3">
                <label for="username" class="form-label">UserName:</label>
                <input type="text" class="form-control" id="username" placeholder="username" name="username">
            </div>
            <div class="mb-3">
                <label for="pwd" class="form-label">Password:</label>
                <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pswd">
            </div>
            <div class="mb-3 mt-3">
                <label for="email" class="form-label">Email:</label>
                <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
            </div>
        </form>
            <button id="btnSubmit" class="btn btn-primary">Submit</button>
        
    </div>
    <!-- 스프링은 기본적으로 static폴더(정적파일)를 스캔하기 때문에, /하면 static폴더 찾음 -->
    <!-- js와 연동 되도록 script로 명시를 해줌 -->
    <script src="/blog/js/user/user.js"></script>
    <%@ include file="../layout/footer.jsp" %>
</body>

</html>
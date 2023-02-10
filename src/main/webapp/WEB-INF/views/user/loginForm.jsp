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
                <input type="text" class="form-control" id="username" placeholder="Enter username" name="username">
            </div>
            <div class="mb-3">
                <label for="pwd" class="form-label">Password:</label>
                <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pswd">
            </div>
            <div class="form-check mb-3">
                <label class="form-check-label">
                    <input class="form-check-input" type="checkbox" name="remember"> Remember me
                </label>
            </div>
        </form>
        <button id="btnLogin" class="btn btn-primary" >Login</button>
    </div>
    <script src="/js/user/user.js"></script>
    <%@ include file="../layout/footer.jsp" %>
</body>

</html>
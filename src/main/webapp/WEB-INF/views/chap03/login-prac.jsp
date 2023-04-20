<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <h1>로그인 페이지 연습중입니당!!~~</h1>
    <form action="/sh/login-checking" method="POST">

    <label>
        # 아이디 : <input type="text" name="id">
    </label>
    <label>
        # 비밀번호 : <input type="text"  name="pwd">
    </label>
    <button type="submit">로그인 하기요</button>
    </form>
</body>
<script>
        const $id = document.getElementById('id');
        const $pwd = document.getElementById('pwd');




</script>
</html>
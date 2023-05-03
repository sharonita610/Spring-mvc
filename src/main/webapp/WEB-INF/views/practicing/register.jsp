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

<h1>동물 등록 화면입니다</h1>
<form action="/animal/register" method="post">
    <h2>동물을 등록해볼까요?</h2>
    <label>
        이름 : <input type="text" name="aniName">
    </label><br>
    <label>
        나이 : <input type="text" name="aniAge">
    </label><br>
    <label>
        성별 : <input type="text" name="aniGender">
    </label><br>
    <label>
        보호자 : <input type="text" name="aniGuardian">
    </label><br>
    <label>
        주소 : <input type="text" name="aniAddr">
    </label><br>
    <label>
        종 : <input type="text" name="aniType">
    </label><br><br><br><br>

    <button type="submit"> 새로운 동물 등록하기</button>
    <button><a href="/animal/list">메인화면으로</a></button>
</form>


</body>
</html>
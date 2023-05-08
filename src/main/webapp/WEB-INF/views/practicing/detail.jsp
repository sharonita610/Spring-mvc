
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


    <style>
        .wrap {
            width: 500px;
            height: 100%;
            border: 5px solid #4CAF50;
        }

        li {
            list-style: none;
        }


    </style>
</head>
<body>

<div class="wrap">
    <h1>${a.aniName}의 상세정보</h1>
    <ul>
        <li>종류 : ${a.aniType}</li>
        <li>나이 : ${a.aniAge}</li>
        <li>성별 : ${a.aniGender}</li>
        <li>보호자 : ${a.aniGuardian}</li>
        <li>주소 : ${a.aniAddr}</li>


    </ul>

    <button><a href="/animal/list">목록으로</a></button>
    <!-- 댓글 영역 -->


</div>




</body>
</html>
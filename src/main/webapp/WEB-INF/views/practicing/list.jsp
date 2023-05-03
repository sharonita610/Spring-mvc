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
            width: 100%;
            height: 100%;
            color: #333;
            border: 2px solid #000000;
            text-align: center;
        }

        h1 {
            align-content: center;
            text-align: center;
        }

        li {
            width: 90%;
            color: #000;
            list-style: none;
            border: 2px solid #1b64c3;
        }

    </style>

</head>
<body>
<div class="wrap">
    <h1>🐶🐺🐱🦁우리 귀여운 동물 친구들🐯🦒🐮🐷</h1>


    <button><a href="/animal/newRegister">동물 등록</a></button>




    <c:forEach var="a" items="${aList}">
        <ul>
            <li>
                이름 :<a href="/animal/detail?aniNum=${a.aniNum}"> ${a.aniName}</a>
                | 종류 : ${a.aniType}
                | 성별 : ${a.aniGender}
                | 보호자 : ${a.aniGuardian}
                <a href="/animal/delete?aniNum=${a.aniNum}">삭제</a>
            </li>



        </ul>
    </c:forEach>

</div>

</body>
</html>
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
        body {

            width: 350px;
            height: 300px;
            box-shadow: 2px 1px 10px #1b64c3;
            border: 2px solid #0db9e5;
            border-radius: 5%;
            margin: 20% auto;

        }

        li {
            list-style: none;
        }
        .title{
            text-align: center;
        }

        a{
            text-decoration: none;
            width: 80%;
            display: block;
        }
        .button {
            width: fit-content;
            height: 25px;
            margin-top: 5%;
            margin-left: 10%;
            color: #cacbd0;
            font-width: 800;
            background: #3046c3;
            border-radius: 5px;
            border: #ea6e6e;
            cursor: pointer;
        }
    </style>
    </style>
</head>
<body>
<div class="box">
    <div class="title">
        <h1>${s.name} 님 성적 정보</h1>
    </div>
    <div class="list">
        <ul>
            <li># 국어 : ${s.kor}점</li>
            <li># 영어 : ${s.eng}점</li>
            <li># 수학 : ${s.math}점</li>
            <li># 총점 : ${s.total}점</li>
            <li># 평균 : ${s.average}점</li>
            <li># 학점 : ${s.grade}점</li>
        </ul>
    </div>

        <a href="/score/list"><div class="button">목록</div></a>
        <a href="/score/edit?stuNum=${s.stuNum}"><div class="button">수정</div></a>


</div>
</body>
</html>

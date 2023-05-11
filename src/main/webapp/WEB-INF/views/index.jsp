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
    <%@ include file="./include/static-head.jsp"%>
    <style>

        #main-title {
            margin-top: 200px;
            font-size: 40px;
            font-weight: 700;
            color: orange;
        }

    </style>
</head>
<body>
    <%@ include file="./include/header.jsp"%>
    <h1 id="main-title">초보자님 안녕하세요~</h1>

<c:if test="${flag}">
    로그인하셨군요?

</c:if>
    <script>
        console.log('flag : ${flag}');
    </script>

</body>
</html>
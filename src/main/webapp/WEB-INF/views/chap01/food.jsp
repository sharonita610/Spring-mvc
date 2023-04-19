<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <h1>food.JSP 테스중입니당</h1>

    <form action="/spring/food-select" method="get">

        # 음식명 : <input type="text" name="foodName"><br>
        # 음식 카테고리:
        <select name="category">
            <option value="KOREAN">한식</option>
            <option value="WESTERN">양식</option>
            <option value="CHINESE">중식</option>

        </select>
        <br>
        <button type="submit">확인</button>

    </form>
</body>
</html>
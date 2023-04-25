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

<div id="wrap">

    <div class="main-title-wrapper">
        <h1 class="main-title">꾸러기 게시판</h1>
        <button class="add-btn">글 읽기</button>
    </div>
    <div class="card-container">
        <div class="card-wrapper">
            <section class="card" data-bno="${b.boardNo}">
                <div class="card-title-wrapper">
                    <h2 class="card-title">${b.shortTitle}</h2>
                    <div class="time-view-wrapper">
                        <div class="time">
                            <i class="far fa-clock"></i>
                                ${b.date}
                        </div>
                        <div class="view">
                            <i class="fas fa-eye"></i>
                            <span class="view-count">
                                    ${b.viewCount}
                            </span>
                        </div>
                    </div>
                </div>
                <div class="card-content">

                        ${b.shortContent}

                </div>
            </section>
            <div class="card-btn-group">
                <button class="del-btn">
                    <i class="fas fa-times"></i>
                </button>
            </div>
        </div>


    </div>
</div>

</body>
</html>
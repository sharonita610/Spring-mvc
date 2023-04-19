<%@ page contentType="text/html; charset=UTF-8" language="java" %>
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
    <h1>로그인 하기~</h1>
    <form action="/hw/s-login-check" method="POST">
        <label>
            # 아이디 : <input name ="inputId" type="text">
        </label>
        <label>
            # 비밀번호 : <input name ="inputPwd" type="text">
        </label>



    <button type="submit">로그인</button>
</form>
    <script>


        const $inputId = document.getElementById('id');
        const $inputPwd = document.getElementById('pwd');


        console.log($inputId);
        console.log($inputPwd);




    </script>
</body>

</html>
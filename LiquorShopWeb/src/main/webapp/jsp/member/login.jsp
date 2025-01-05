<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>로그인 - LiquorShop</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <style>
        /* 동일한 스타일 */
        .login-container {
            max-width: 400px;
            margin: 50px auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .login-container input {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border-radius: 5px;
            border: 1px solid #ccc;
        }

        .login-container button {
            width: 100%;
            padding: 10px;
            background-color: #4caf50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .login-container button:hover {
            background-color: #45a049;
        }

        .register-button {
            margin-top: 15px;
            display: block;
            text-align: center;
            color: #333;
            text-decoration: none;
            font-size: 14px;
        }
    </style>
</head>
<body>
    <%@ include file="/jsp/include/header.jsp" %>

    <div class="login-container">
      <h2>로그인</h2>
        
        <!-- 에러 메시지가 있을 경우 출력 -->
        <c:if test="${not empty errorMessage}">
            <p class="error-message">${errorMessage}</p>
        </c:if>

        <form action="${pageContext.request.contextPath}/member/login.do" method="post">
            <input type="email" name="email" placeholder="이메일" required>
            <input type="password" name="password" placeholder="비밀번호" required>
            <button type="submit">로그인</button>
        </form>

        <a href="${pageContext.request.contextPath}/member/register.do">회원가입</a>
    </div>

    <%@ include file="/jsp/include/footer.jsp" %>
</body>
</html>

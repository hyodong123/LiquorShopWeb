<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/jsp/include/header.jsp"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>에러 발생</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <style>
        .error-container {
            text-align: center;
            margin: 50px auto;
            padding: 20px;
            max-width: 600px;
            background-color: #f8d7da;
            border: 1px solid #f5c2c7;
            border-radius: 10px;
            color: #842029;
        }
        .error-container h1 {
            font-size: 24px;
            margin-bottom: 20px;
        }
        .error-container p {
            font-size: 16px;
        }
        .back-button {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #6c757d;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        .back-button:hover {
            background-color: #5a6268;
        }
    </style>
</head>
<body>
    <div class="error-container">
        <h1>에러가 발생했습니다</h1>
        <p>요청을 처리하는 중 문제가 발생했습니다. 아래 내용을 확인하세요:</p>
        <p><strong>에러 메시지:</strong> ${requestScope.errorMessage}</p>
        <p><strong>원인:</strong> ${requestScope.errorCause}</p>
        <a href="${pageContext.request.contextPath}/" class="back-button">홈으로 돌아가기</a>
    </div>
</body>
<%@ include file="/jsp/include/footer.jsp"%>
</html>

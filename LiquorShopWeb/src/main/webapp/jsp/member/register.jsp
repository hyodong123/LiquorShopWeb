<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/jsp/include/header.jsp" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/register.css">
</head>
<body>
    <%@ include file="/jsp/include/header.jsp" %>

    <div class="register-container">
        <h1>회원가입</h1>

        <c:if test="${not empty errorMessage}">
            <div class="error-message">${errorMessage}</div>
        </c:if>

        <form action="${pageContext.request.contextPath}/member/register.do" method="post">
            <div class="form-group">
                <label for="email">이메일 *</label>
                <input type="email" id="email" name="email" placeholder="이메일을 입력하세요" required>
            </div>

            <div class="form-group">
                <label for="password">비밀번호 *</label>
                <input type="password" id="password" name="password" placeholder="비밀번호를 입력하세요">
                <small>소셜 로그인 사용 시 비밀번호를 입력하지 않아도 됩니다.</small>
            </div>

            <div class="form-group">
                <label for="username">이름 *</label>
                <input type="text" id="username" name="username" placeholder="이름을 입력하세요" required>
            </div>

            <div class="form-group">
                <label for="phone">전화번호</label>
                <input type="text" id="phone" name="phone" placeholder="전화번호를 입력하세요">
            </div>

            <div class="form-group">
                <label for="address">주소</label>
                <textarea id="address" name="address" placeholder="주소를 입력하세요"></textarea>
            </div>

            <div class="form-group">
                <label for="socialProvider">소셜 로그인 제공자</label>
                <input type="text" id="socialProvider" name="socialProvider" placeholder="예: Google, Facebook">
            </div>

            <div class="form-group">
                <label for="socialAccountId">소셜 계정 ID</label>
                <input type="text" id="socialAccountId" name="socialAccountId" placeholder="소셜 계정 ID를 입력하세요">
            </div>

            <div class="form-actions">
                <button type="submit" class="register-button">회원가입</button>
                <a href="${pageContext.request.contextPath}/member/login.do" class="login-link">로그인 페이지로 이동</a>
            </div>
        </form>
    </div>
</body>
<%@ include file="/jsp/include/footer.jsp" %>
</html>


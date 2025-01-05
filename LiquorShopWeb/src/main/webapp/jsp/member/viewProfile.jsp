<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/jsp/include/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<h2>마이페이지</h2>
	<h3>프로필 정보</h3>

	<!-- 성공 또는 오류 메시지 표시 -->
	<c:if test="${not empty successMessage}">
		<div class="alert alert-success">${successMessage}</div>
	</c:if>
	<c:if test="${not empty errorMessage}">
		<div class="alert alert-danger">${errorMessage}</div>
	</c:if>

	<!-- 프로필 수정 폼 -->
	<form
		action="${pageContext.request.contextPath}/mypage.do?action=updateProfile"
		method="post">
		<label for="username">이름: </label> <input type="text" id="username"
			name="username" value="${member.username}" required /><br /> <label
			for="email">이메일: </label> <input type="email" id="email" name="email"
			value="${member.email}" required /><br /> <label for="phoneNumber">전화번호:
		</label> <input type="text" id="phoneNumber" name="phoneNumber"
			value="${member.phoneNumber}" required /><br /> <label
			for="address">주소: </label>
		<textarea id="address" name="address" required>${fn:escapeXml(member.address)}</textarea>
		<br />

		<button type="submit">수정하기</button>
	</form>
</body>
<%@ include file="/jsp/include/footer.jsp"%>
</html>

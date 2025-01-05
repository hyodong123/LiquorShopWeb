<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/headerFooter.css">
<title>LiquorShop</title>
</head>
<body>
	<nav class="navbar">
		<div class="navbar-container">
			<!-- 로고 -->
			<a href="${pageContext.request.contextPath}/index.jsp"
				class="navbar-logo">LiquorShop</a>

			<!-- 메뉴 -->
			<ul class="navbar-menu">
				<li><a href="${pageContext.request.contextPath}/liquor/list.do">주류
						목록</a></li>
				<li><a
					href="${pageContext.request.contextPath}/jsp/about/about.jsp">소개</a></li>
				<li><a
					href="${pageContext.request.contextPath}/liquor/contact.do">문의하기</a></li>
				<li><a href="${pageContext.request.contextPath}/cart/view.do">장바구니</a></li>

				<!-- 로그인 여부 확인 -->
				<c:choose>
					<c:when test="${empty sessionScope.user}">
						<!-- 로그인 전 -->
						<li><a
							href="${pageContext.request.contextPath}/member/login.do">로그인</a></li>
						<li><a
							href="${pageContext.request.contextPath}/member/register.do">회원가입</a></li>
					</c:when>
					<c:otherwise>
						<!-- 로그인 후 -->
						<li><span>환영합니다, ${sessionScope.user.username}님!</span></li>
						<li><a
							href="${pageContext.request.contextPath}/member/logout.do">로그아웃</a></li>
						<!-- 마이페이지 메뉴 추가 -->
						<li><a
							href="${pageContext.request.contextPath}/member/viewProfile.do">마이페이지</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</nav>
</body>
</html>

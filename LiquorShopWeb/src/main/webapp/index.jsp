<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/jsp/include/header.jsp"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>LiquorShop Main Page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/listCss.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/headerFooter.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css">
<body>
	<!-- 메인 배너 -->
	<div class="main-banner">
		<img src="${pageContext.request.contextPath}/images/banner.jpg"
			alt="Welcome to LiquorShop">
		<div class="banner-text">
			<h1>Welcome to LiquorShop</h1>
			<p> 안녕하세요</p>
			<a href="/LiquorShopWeb/liquor/list.do" class="main-button">지금
				쇼핑하기</a>
		</div>
	</div>

	<!-- 주요 섹션 링크 -->
	<div class="main-links">
		<a href="/LiquorShopWeb/liquor/list.do" class="main-button">주류 리스트</a>
		<a href="/LiquorShopWeb/jsp/about/about.jsp" class="main-button">소개</a>
		<a href="/LiquorShopWeb/liquor/contact.do" class="main-button">문의하기</a>
	</div>

	<%@ include file="/jsp/include/footer.jsp"%>
</body>
</html>

<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/jsp/include/header.jsp"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Liquor List</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/listCss.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/headerFooter.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<!-- Liquor List -->
	<div class="card-container">
		<c:forEach var="liquor" items="${liquors}">
			<div class="card">
				<img
					src="${liquor.imageUrl != null ? liquor.imageUrl : '/LiquorShop/images/no-image.png'}"
					alt="Liquor Image">
				<div class="card-content">
					<div class="card-title">${liquor.name}</div>
					<div class="card-price">Price: ${liquor.price} 원</div>

					<!-- 상세 보기 버튼 -->
					<a href="/LiquorShopWeb/liquor/detail.do?id=${liquor.liquorId}"
						class="buy-button">상세 보기</a>

					<!-- 장바구니 추가 버튼 (아이콘) -->
					<form action="/LiquorShopWeb/cart/add.do" method="post"
						style="display: inline;">
						<input type="hidden" name="action" value="add">
						<!-- 반드시 추가 -->
						<input type="hidden" name="liquorId" value="${liquor.liquorId}">
						<input type="hidden" name="quantity" value="1">
						<button type="submit" class="cart-button">
							<img
								src="${pageContext.request.contextPath}/images/cart-icon.png"
								alt="Add to Cart" title="장바구니에 추가">
						</button>
					</form>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
<%@ include file="/jsp/include/footer.jsp"%>
</html>

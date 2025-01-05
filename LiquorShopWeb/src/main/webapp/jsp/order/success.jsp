<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/jsp/include/header.jsp" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>결제 완료</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <h1>결제가 완료되었습니다!</h1>
        <p>주문 번호: <strong>${orderId}</strong></p>

        <h2>주문 내역</h2>
        <c:choose>
            <c:when test="${empty orderDetails}">
                <p>주문 내역을 불러올 수 없습니다.</p>
            </c:when>
            <c:otherwise>
                <table border="1" width="100%">
                    <thead>
                        <tr>
                            <th>상품명</th>
                            <th>수량</th>
                            <th>가격</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="detail" items="${orderDetails}">
                            <tr>
                                <td>${detail.liquorName}</td>
                                <td>${detail.quantity}</td>
                                <td>${detail.price} 원</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:otherwise>
        </c:choose>

        <p><a href="${pageContext.request.contextPath}/member/viewProfile.do">마이페이지에서 주문 내역 확인하기</a></p>
    </div>
<%@ include file="/jsp/include/footer.jsp" %>
</body>
</html>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/jsp/include/header.jsp" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>주문 내역</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <h1>주문 내역</h1>
    <c:choose>
        <c:when test="${empty orders}">
            <p>주문 내역이 없습니다.</p>
        </c:when>
        <c:otherwise>
            <table border="1" width="100%">
                <thead>
                    <tr>
                        <th>주문 번호</th>
                        <th>총 금액</th>
                        <th>배송 주소</th>
                        <th>상태</th>
                        <th>주문 날짜</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="order" items="${orders}">
                        <tr>
                            <td>${order.orderId}</td>
                            <td>${order.totalPrice} 원</td>
                            <td>${order.shippingAddress}</td>
                            <td>${order.status}</td>
                            <td>${order.orderDate}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
    <br>
    <a href="${pageContext.request.contextPath}/index.jsp" style="text-decoration: none;">홈으로 돌아가기</a>

<%@ include file="/jsp/include/footer.jsp" %>
</body>
</html>

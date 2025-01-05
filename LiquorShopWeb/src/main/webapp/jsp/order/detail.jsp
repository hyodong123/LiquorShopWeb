<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/jsp/include/header.jsp" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>주문 상세</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <h1>주문 상세 내역</h1>
    <p>주문 번호: <%= request.getAttribute("orderId") %></p>
    <c:choose>
        <c:when test="${empty orderDetails}">
            <p>주문 상세 내역이 없습니다.</p>
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

<%@ include file="/jsp/include/footer.jsp" %>
</body>
</html>

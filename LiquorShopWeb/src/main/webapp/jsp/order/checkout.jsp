<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/jsp/include/header.jsp" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Checkout</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <h1>Checkout</h1>

    <c:choose>
        <c:when test="${not empty cartList}">
            <form action="order.do?action=checkout" method="post">
                <h3>배송 정보</h3>
                <label for="shippingAddress">배송 주소:</label>
                <input type="text" name="shippingAddress" id="shippingAddress" required><br><br>
                
                <h3>장바구니 내역</h3>
                <table border="1" width="100%">
                    <thead>
                        <tr>
                            <th>상품명</th>
                            <th>수량</th>
                            <th>가격</th>
                            <th>합계</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="totalPrice" value="0" />
                        <c:forEach var="cart" items="${cartList}">
                            <tr>
                                <td>${cart.liquorName}</td>
                                <td>${cart.quantity}</td>
                                <td>${cart.price} 원</td>
                                <td>
                                    <c:set var="itemTotal" value="${cart.price * cart.quantity}" />
                                    ${itemTotal} 원
                                </td>
                                <c:set var="totalPrice" value="${totalPrice + itemTotal}" />
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <p><strong>총 금액:</strong> ${totalPrice} 원</p>
                <input type="hidden" name="totalPrice" value="${totalPrice}">
                
                <button type="submit">결제하기</button>
            </form>
        </c:when>
        <c:otherwise>
            <p>장바구니가 비어 있습니다.</p>
            <a href="${pageContext.request.contextPath}/liquor/list.jsp">상품 목록으로 이동</a>
        </c:otherwise>
    </c:choose>

<%@ include file="/jsp/include/footer.jsp" %>
</body>
</html>

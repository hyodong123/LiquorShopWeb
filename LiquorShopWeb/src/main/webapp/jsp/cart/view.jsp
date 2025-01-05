<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/jsp/include/header.jsp"%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
$(document).ready(function () {
    // 초기 요약 정보 계산
    updateSummary();

    // 수량 버튼 이벤트
    $(".quantity-btn").on("click", function () {
        let $button = $(this);
        let $input = $button.siblings("input");
        let currentQuantity = parseInt($input.val(), 10);

        // 수량 조절
        if ($button.text() === "+" && currentQuantity < 99) {
            currentQuantity++;
        } else if ($button.text() === "-" && currentQuantity > 1) {
            currentQuantity--;
        }

        $input.val(currentQuantity);

        // 행 단위 합계 업데이트
        let $row = $button.closest("tr");
        let price = parseInt($row.find(".price").text().replace(/[^0-9]/g, ""));
        let total = price * currentQuantity;
        $row.find(".total-price").text(total.toLocaleString() + " 원");

        // 요약 정보 업데이트
        updateSummary();
    });

    // 체크박스 이벤트
    $("input[type='checkbox']").on("change", function () {
        updateSummary();
    });

    // 삭제 버튼 이벤트
    $(".delete-btn").on("click", function () {
        const cartId = $(this).data("cart-id");
        if (!confirm("정말 삭제하시겠습니까?")) return;

        $.ajax({
            url: "${pageContext.request.contextPath}/cart/delete.do",
            type: "POST",
            data: { cartId: cartId },
            success: function () {
                alert("상품이 삭제되었습니다.");
                location.reload(); // 페이지 새로고침
            },
            error: function () {
                alert("삭제에 실패했습니다. 다시 시도해주세요.");
            }
        });
    });

    // 요약 정보 업데이트 함수
    function updateSummary() {
        let totalItems = 0;
        let totalPrice = 0;

        $(".cart-table tbody tr").each(function () {
            let $row = $(this);
            let isChecked = $row.find("input[type='checkbox']").is(":checked");
            if (isChecked) {
                let quantity = parseInt($row.find("input[type='text']").val(), 10);
                let price = parseInt($row.find(".price").text().replace(/[^0-9]/g, ""));
                totalItems += quantity;
                totalPrice += price * quantity;
            }
        });

        // 요약 섹션에 반영
        $(".summary-total-items").text(totalItems + " 개");
        $(".summary-total-price").text(totalPrice.toLocaleString() + " 원");
        $(".summary-total-final").text(totalPrice.toLocaleString() + " 원");
    }

    // 주문하기 버튼 클릭 이벤트
    $(".checkout-btn").on("click", function () {
        // "주문하기" 버튼 클릭 시 주문 페이지로 이동
        location.href = "${pageContext.request.contextPath}/order/checkout.jsp";
    });
});
</script>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>장바구니</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <style>
/* 장바구니 전체 컨테이너 */
.cart-container {
	width: 90%;
	max-width: 1000px;
	margin: 50px auto;
	background-color: #f9f9f9;
	border: 1px solid #ddd;
	border-radius: 10px;
	padding: 20px;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
	font-family: 'Arial', sans-serif;
	color: #333;
}

/* 테이블 스타일 */
.cart-table {
	width: 100%;
	border-collapse: collapse;
	margin-bottom: 20px;
}

.cart-table th, .cart-table td {
	padding: 15px;
	border: 1px solid #ddd;
	text-align: center;
	font-size: 14px;
}

.cart-table th {
	background-color: #f2f2f2;
	font-weight: bold;
}

/* 수량 조절 버튼 */
.quantity-input {
	display: inline-flex;
	justify-content: center;
	align-items: center;
}

.quantity-input input {
	width: 40px;
	text-align: center;
	margin: 0 5px;
	border: 1px solid #ccc;
	border-radius: 3px;
	font-size: 14px;
}

.quantity-btn {
	background-color: #eee;
	border: none;
	padding: 3px 8px;
	cursor: pointer;
	font-size: 12px;
	color: #555;
}

.quantity-btn:hover {
	background-color: #ddd;
}

/* 삭제 버튼 */
.delete-btn {
	background-color: #ff4d4d;
	color: white;
	border: none;
	padding: 5px 10px;
	border-radius: 5px;
	cursor: pointer;
	font-size: 12px;
}

.delete-btn:hover {
	background-color: #ff1a1a;
}

/* 결제 요약 섹션 */
.summary-container {
	background-color: #f2f6ff;
	border: 1px solid #cce5ff;
	border-radius: 10px;
	padding: 20px;
	text-align: right;
	color: #333;
}

.summary-container p {
	font-size: 16px;
	margin: 10px 0;
}

.checkout-btn {
	background-color: #007bff;
	color: white;
	border: none;
	padding: 10px 20px;
	border-radius: 5px;
	font-size: 16px;
	cursor: pointer;
}

.checkout-btn:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
    <div class="cart-container">
        <h2 style="text-align: center;">장바구니</h2>
        <table class="cart-table">
            <thead>
                <tr>
                    <th><input type="checkbox" checked /></th>
                    <th>상품명</th>
                    <th>가격</th>
                    <th>수량</th>
                    <th>합계</th>
                    <th>삭제</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="cart" items="${cartList}">
                    <tr>
                        <td><input type="checkbox" checked /></td>
                        <td>${cart.liquorName}</td>
                        <td class="price">${cart.price} 원</td>
                        <td>
                            <div class="quantity-input">
                                <button type="button" class="quantity-btn">-</button>
                                <input type="text" value="${cart.quantity}" readonly />
                                <button type="button" class="quantity-btn">+</button>
                            </div>
                        </td>
                        <td class="total-price">${cart.price * cart.quantity} 원</td>
                        <td>
                            <button type="button" class="delete-btn" data-cart-id="${cart.cartId}">삭제</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div class="summary-container">
            <p>총 상품 가격: <strong class="summary-total-price">0 원</strong></p>
            <p>배송비: <strong>0 원</strong></p>
            <p>총 주문 상품수: <strong class="summary-total-items">0 개</strong></p>
            <p>총 결제 예상 금액: <strong class="summary-total-final">0 원</strong></p>

            <!-- "주문하기" 버튼 -->
            <form action="${pageContext.request.contextPath}/order/checkout.do" method="get">
                <input type="hidden" name="action" value="checkout">
                <button type="submit" class="checkout-btn">주문하기</button>
            </form>
        </div>
    </div>
</body>
<%@ include file="/jsp/include/footer.jsp" %>
</html>
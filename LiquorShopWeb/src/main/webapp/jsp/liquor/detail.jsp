<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>${liquor.name} - 상세 정보</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/listCss.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/headerFooter.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <style>
        .detail-container {
            max-width: 1200px;
            margin: 50px auto;
            padding: 20px;
            background-color: #222;
            color: #f4f4f4;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.3);
            display: flex; /* 왼쪽 이미지와 오른쪽 설명을 나란히 배치 */
            gap: 30px;
        }

        .detail-image {
            flex: 1;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .detail-image img {
            width: 100%;
            max-width: 400px;
            height: auto;
            border-radius: 10px;
        }

        .detail-info-container {
            flex: 2;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
        }

        .detail-header {
            margin-bottom: 20px;
        }

        .detail-header h2 {
            font-size: 28px;
            font-weight: bold;
            margin-bottom: 10px;
        }

        .detail-info {
            padding: 20px;
            background-color: #333;
            border-radius: 10px;
            margin-bottom: 20px;
        }

        .detail-info table {
            width: 100%;
            color: #f4f4f4;
        }

        .detail-info th, .detail-info td {
            padding: 10px;
            border-bottom: 1px solid #444;
        }

        .detail-info th {
            text-align: left;
            font-weight: bold;
        }

        .detail-price {
            font-size: 24px;
            color: #ff6347; /* 가격 강조 */
            text-align: right;
        }

        .detail-description {
            font-size: 16px;
            line-height: 1.6;
            margin-bottom: 20px;
        }

        .action-buttons {
            margin-top: 20px;
        }

        .action-buttons a {
            display: inline-block;
            background-color: #4caf50;
            color: white;
            padding: 10px 20px;
            border-radius: 5px;
            text-align: center;
            text-decoration: none;
            transition: background-color 0.3s;
        }

        .action-buttons a:hover {
            background-color: #45a049;
        }

        .back-button {
            background-color: #444;
        }

        .back-button:hover {
            background-color: #555;
        }
    </style>
</head>
<body>
    <%@ include file="/jsp/include/header.jsp" %>

    <div class="detail-container">
        <!-- 제품 이미지 (왼쪽) -->
        <div class="detail-image">
            <img src="${liquor.imageUrl != null ? liquor.imageUrl : '/LiquorShop/images/no-image.png'}" alt="${liquor.name}">
        </div>

        <!-- 제품 상세 정보 (오른쪽) -->
        <div class="detail-info-container">
            <!-- 제품명 -->
            <div class="detail-header">
                <h2>${liquor.name}</h2>
            </div>

            <!-- 제품 정보 테이블 -->
            <div class="detail-info">
                <table>
                    <tr>
                        <th>원산지</th>
                        <td>${liquor.category != null ? liquor.category : "N/A"}</td>
                    </tr>
                    <tr>
                        <th>알코올 도수</th>
                        <td>40%</td>
                    </tr>
                    <tr>
                        <th>소비자가격</th>
                        <td>- 원</td>
                    </tr>
                    <tr>
                        <th>판매 가격</th>
                        <td class="detail-price">${liquor.price} 원</td>
                    </tr>
                </table>
            </div>

            <!-- 제품 설명 -->
            <div class="detail-description">
                <h3>상품 설명</h3>
                <p>
                    원산지: ${liquor.category != null ? liquor.category : "N/A"}<br>
                    용량: 750ml<br>
                    (재고소진까지) 특가 할인
                </p>
            </div>

            <!-- 이전/다음 버튼 및 장바구니 추가 -->
            <div class="action-buttons">
                <a href="/LiquorShopWeb/liquor/list.do" class="back-button">목록</a>
                <a href="/LiquorShopWeb/liquor/addToCart.do?id=${liquor.liquorId}" class="buy-button">상품문의</a>
            </div>
        </div>
    </div>

    <%@ include file="/jsp/include/footer.jsp" %>
</body>
</html>

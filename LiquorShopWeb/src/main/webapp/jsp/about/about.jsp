<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>소개 - LiquorShop</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/headerFooter.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="https://unpkg.com/leaflet/dist/leaflet.css" />
    <script src="https://unpkg.com/leaflet/dist/leaflet.js"></script>
    <style>
        .about-container {
            max-width: 800px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            color: #333;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .about-container h2 {
            text-align: center;
            font-size: 32px;
            margin-bottom: 20px;
        }

        .about-container p {
            font-size: 16px;
            line-height: 1.6;
            margin-bottom: 20px;
        }

        #map {
            width: 100%;
            height: 400px;
            margin-top: 20px;
            border-radius: 10px;
        }
    </style>
</head>
<body>
    <%@ include file="/jsp/include/header.jsp" %>

    <div class="about-container">
        <h2>LiquorShop 소개</h2>
        <p>LiquorShop에 오시는 길</p>
        <p>LiquorShop은 서울 중심부에 위치하고 있으며, 다양한 주류를 구매하실 수 있는 매장입니다. 아래 지도에서 위치를 확인하시고 방문해 주세요!</p>
        
        <!-- 지도 표시 -->
        <div id="map"></div>
    </div>

    <%@ include file="/jsp/include/footer.jsp" %>

    <script>
        // 지도 초기화
        var map = L.map('map').setView([37.5665, 126.9780], 15); // 서울의 예시 좌표 사용

        // OSM 타일 레이어 추가
        L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
            attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
        }).addTo(map);

        // 마커 추가
        var marker = L.marker([37.5665, 126.9780]).addTo(map)
            .bindPopup("<b>LiquorShop 위치</b><br>여기로 오세요!")
            .openPopup();
    </script>
</body>
</html>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>선의 거리 계산하기</title>
<link rel="stylesheet" href="css/map.css">
</head>
<body>

	<section class="ftco-section ftco-degree-bg">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 order-lg-last ftco-animate">
					<h3 class="mb-4 billing-heading">펫 산책정보 </h3>
					<div class="row">
						<div class="container" id='container'>
							<div id="map" style="width: 100%; height: 350px;"></div>
						</div>
						<p>원하는 경로를 지정해주세요. (마지막경로 : 마우스 우측클릭)</p>
						<!-- 일부분 부분-->
						<button class="btn btn-primary py-2 px-3" onclick=partShot()>지도스크린샷</button>
						<%-- <!-- 결과화면을 그려줄 canvas -->
						<canvas id="canvas" width="900" height="600"
							style="border: 1px solid #d3d3d3;"></canvas> --%>
						<div class="col-xl-10 ftco-animate">
						<form action="petWalkingPostAction" method="post" enctype="multipart/form-data" class="billing-form">
							<div class="form-group">
								<label for="routeImage"> 산책경로 사진 </label> <input type="file"
									class="form-control" id="routeImage" name="routeImage">
							</div>
							<div class="form-group">
								<label for="writer"> 작성자 </label> <input type="text"
									class="form-control" id="writer" name="writer"
									value=${loginedMember.memberId } readonly >
							</div>
							<div class="form-group">
								<label for="routeName"> 산책경로 제목 </label> <input type="text"
									class="form-control" id="routeName" name="routeName">
							</div>
							<div class="form-group">
								<label for="routeStart"> 산책 시작장소 </label> <input type="text"
									class="form-control" id="routeStart" name="routeStart">
							</div>
							<div class="form-group">
								<label for="routeEnd"> 산책 종료장소 </label> <input
									type="text" class="form-control" id="routeEnd" name="routeEnd">
							</div>
							<div class="form-group">
								<label for="routeDistance"> 산책 거리(단위:m) </label> <input
									type="text" class="form-control" id="routeDistance" name="routeDistance">
							</div>
							<div class="form-group">
								<label for="routeDescription">산책경로 설명 </label>
								<textarea cols="30" rows="7" class="form-control"
									id="routeDescription" name="routeDescription"></textarea>
							</div>

							<div class="form-group">
								<input type="submit" value="등록하기"
									class="btn btn-primary py-3 px-5">
							</div>

						</form>
						</div>

					</div>
				</div>
				<!— .col-md-8 —>
				<div class="col-lg-4 sidebar ftco-animate">
					<div class="sidebar-box">
						<form action="#" class="search-form">
							<div class="form-group">
								<span class="icon ion-ios-search"></span> <input type="text"
									class="form-control" placeholder="펫 이름으로 검색하기">
							</div>
						</form>
					</div>
					<div class="sidebar-box ftco-animate">
						<h3 class="heading">Categories</h3>
						<ul class="categories">
							<li><a href="/petShow">펫 자랑하기 </a></li>
							<li><a href="/petWalkingInfo">펫 산책정보</a></li>
							<li><a href="#">자유 게시판</a></li>
						</ul>
					</div>
				</div>

			</div>
		</div>
	</section>
	<!-- section -->

	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=cf8b7ba0abffd17bceb9460dc4ac1c7a"></script>
	<script src="js/google-map.js"></script>
	<script src="js/html2canvas.js"></script>
	<script src="js/screenshot.js"></script>
</body>
</html>
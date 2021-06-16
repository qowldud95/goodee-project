<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
</head>
<body>

	<section class="ftco-section ftco-degree-bg">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 order-lg-last ftco-animate">
					<div class="row">
						<div class="col-xl-10 ftco-animate">
							<h3 class="mb-4 billing-heading">펫 산책정보 수정하기</h3>
							<form action=petWalkingUpdateAction method="post"  enctype="multipart/form-data" class="billing-form">
							<div class="form-group">
										<label for="routeImage"> 산책경로 사진 </label> <input type="file"
											class="form-control" id="routeImage" name="routeImage">
									</div>
							<div class="form-group">
								<label for="writer"> 작성자 </label> <input type="text"
									class="form-control" id="writer" name="writer"
									value=${route.writer} >
							</div>
							<div class="form-group">
								<label for="routeNumber"> 산책번호 </label> <input type="text"
									class="form-control" id="routeNumber" name="routeNumber"
									value=${route.routeNumber } readOnly >
							</div>
							<div class="form-group">
								<label for="routeName"> 산책경로 제목 </label> <input type="text"
									class="form-control" id="routeName" name="routeName"
									value=${route.routeName } >
							</div>
							<div class="form-group">
								<label for="routeStart"> 산책 시작장소 </label> <input type="text"
									class="form-control" id="routeStart" name="routeStart"
									value=${route.routeStart } >
							</div>
							<div class="form-group">
								<label for="routeEnd"> 산책 종료장소 </label> <input type="text"
									class="form-control" id="routeEnd" name="routeEnd"
									value=${route.routeEnd } >
							</div>
							<div class="form-group">
								<label for="routeDescription">산책경로 설명 </label>
								<textarea cols="30" rows="7" class="form-control"
									id="routeDescription" name="routeDescription" >${route.routeDescription}</textarea>
							</div>
							<div class="form-group">
									<input type="submit" value="수정하기"
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

</body>
</html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<section class="ftco-section ftco-degree-bg">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 order-lg-last ftco-animate">
				<div class="row">

					<div class="col-xl-10 ftco-animate">
						<h3 class="mb-4 billing-heading">펫 상세보기</h3>
						<section class="ftco-section">
							<div class="container">
								<div class="row">
									<div class="col-lg-6 mb-5 ftco-animate">
										<a href="images/${pet.petImage}"
											class="image-popup prod-img-bg"><img
											src="images/${pet.petImage}" class="img-fluid"
											alt="Colorlib Template"></a>
									</div>
									<div class="col-lg-6 product-details pl-md-5 ftco-animate">

										<h3>펫 이름 : ${pet.petName}</h3>
										<h4>
											<span>펫 종 : ${pet.petBreed}</span>
										</h4>
										<div class="rating d-flex">
											<p class="text-left mr-4">펫 타입 : ${pet.petType}</p>
										</div>
										<p>${pet.petDiscription}</p>

									</div>
								</div>
								<div class="pt-5 mt-5">
									<h3 class="mb-5">Comments</h3>
									<ul class="comment-list">
										<li class="comment">
											<div class="vcard bio">
												<img src="images/person_1.jpg" alt="Image placeholder">
											</div>
											<div class="comment-body">
												<h3>가격흥정왕 네오집사</h3>
												<div class="meta">June 27, 2018 at 2:21pm</div>
												<p>조금만 깎아주세요 제발요 이것은 더미텍스트입니다. 댓글테스트중</p>
											</div>
										</li>
										<li class="comment">
											<div class="vcard bio">
												<img src="images/person_1.jpg" alt="Image placeholder">
											</div>
											<div class="comment-body">
												<h3>스트롱베이비</h3>
												<div class="meta">June 27, 2018 at 2:21pm</div>
												<p>새우밥 찾고있습니다 연락주세요</p>
											</div>
										</li>
									</ul>
									<!-- END comment-list -->

									<div class="comment-form-wrap pt-5">
										<h3 class="mb-5">Leave a comment</h3>
										<form action="commentAction" method="post"
											class="p-5 bg-light">
											<div class="form-group" style="display: none">
												<input type="text" class="form-control" id="memberId"
													name="memberId" value=${list[0].seller} > <input
													type="text" class="form-control" id="productName"
													name="productName" value=${list[0].productName} >
											</div>
											<div class="form-group">
												<label for="name">NickName *</label> <input type="text"
													class="form-control" id="memberNickname"
													name="memberNickname" value=${loginedMemberName } readOnly>
											</div>
											<div class="form-group">
												<label for="message">Message *</label>
												<textarea name="message" id="message" cols="30" rows="10"
													class="form-control" placeholder="Message"></textarea>
											</div>
											<div class="form-group">
												<input type="submit" value="Post Comment"
													class="btn py-3 px-4 btn-primary">
											</div>

										</form>
									</div>
								</div>
						</section>
						<!-- END -->
					</div>
				</div>
			</div>
			<!-- .col-md-8 -->
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
<!-- .section -->

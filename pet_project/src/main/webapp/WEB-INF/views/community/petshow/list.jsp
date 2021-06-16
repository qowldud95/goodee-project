<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<section class="ftco-section ftco-degree-bg">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 order-lg-last ftco-animate">
			<h3 class="mb-4 billing-heading">펫 자랑하기 </h3>
				<div class="row">
					<c:forEach var="n" items="${list}">
						<div class="col-lg-8 order-lg-last ftco-animate">
							<div class="row">
								<div class="col-md-12 d-flex ftco-animate">
									<div class="blog-entry align-self-stretch d-md-flex">
										<a class="block-20"
											style="background-image: url('images/${n.petImage}');"> </a>
										<div class="text d-block pl-md-4">
											<div class="meta mb-3">
												<div>${n.petType}</div>
												<div>펫나이 : ${n.petAge}</div>
											</div>
											<h3 class="heading">${n.petName}</h3>
											<p>${n.petDiscription}</p> 
											<p>
												<a href="/petShowDetail?petName=${n.petName}"
													class="btn btn-primary py-2 px-3">상세보기</a>
											</p>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- .col-md-8 -->
					</c:forEach>
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

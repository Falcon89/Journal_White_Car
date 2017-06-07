<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="UTF-8" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700"
	rel="stylesheet" type="text/css">
<link href="pages/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="pages/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link href="pages/css/templatemo_style.css" rel="stylesheet"
	type="text/css">
<link href="pages/css/style_prod.css" rel="stylesheet" type="text/css">
<style>
.uploadButton {
	display: block;
	width: 150px;
	background: #212121;
	padding: 5px;
	color: #FFF;
	font-size: 16px;
	font-weight: bold;
	font-family: Tahoma;
	text-align: center;
	border-radius: 10px;
	cursor: pointer;
}

.uploadButton:hover {
	background: #3071a9;
}
</style>
</head>
<body>
	<div class="templatemo-logo visible-xs-block">
		<div
			class="col-lg-6 col-md-6 col-sm-6 col-xs-12 black-bg logo-left-container">
			<h1 class="logo-left">Black</h1>
		</div>
		<div
			class="col-lg-6 col-md-6 col-sm-6 col-xs-12 white-bg logo-right-container">
			<h1 class="logo-right">White</h1>
		</div>
	</div>
	<div class="templatemo-container">
		<div
			class="col-lg-6 col-md-6 col-sm-6 col-xs-12 black-bg left-container">
			<h1 class="logo-left hidden-xs margin-bottom-60">Journal</h1>
			<div class="tm-left-inner-container">
				<ul class="nav nav-stacked templatemo-nav">
					<li><a href="${pageContext.servletContext.contextPath}/"><i
							class="fa fa-home fa-medium"></i>Homepage</a></li>
					<li><a
						href="${pageContext.servletContext.contextPath}/products"
						class="active"><i class="fa fa-shopping-cart fa-medium"></i>Journals</a></li>
					<li><a
						href="${pageContext.servletContext.contextPath}/services"><i
							class="fa fa-send-o fa-medium"></i>Services</a></li>
					<li><a href="${pageContext.servletContext.contextPath}/about"><i
							class="fa fa-gears fa-medium"></i>About Us</a></li>
					<li><a
						href="${pageContext.servletContext.contextPath}/contact"><i
							class="fa fa-envelope-o fa-medium"></i>Contact</a></li>
					<br>
					<br>
					<li><a href="${pageContext.servletContext.contextPath}/login"><i
							class="fa fa-sign-in fa-medium"></i>Login in/Registration</a></li>
					<li><a href="${pageContext.servletContext.contextPath}/admin"><i
							class="fa fa-briefcase fa-medium"></i>Admin panel</a></li>
				</ul>
			</div>
		</div>
		<!-- left section -->
		<div
			class="col-lg-6 col-md-6 col-sm-6 col-xs-12 white-bg right-container">
			<h1 class="logo-right hidden-xs margin-bottom-60">White Car</h1>
			<div class="tm-right-inner-container">
				<h1 class="templatemo-header">Our Products</h1>
				<!--Edit Prodict  -->
				<div class="modal fade" id="settings">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title">UPADE PRODUCR</h4>
							</div>
							<form action="update-product" method="POST">
								<div class="modal-body">
									<div class="form-group">
										<label for="inputDomain" class="control-label">Name</label>
										<div>
											<!--  -->
											<!--  -->
											<input type="text" class="form-control" name="product-name"
												placeholder="product name" ng-model="setting_domain"
												value="${currentPeriodical.name}">

										</div>
									</div>
									<div class="form-group">
										<label for="inputDomain" class="control-label">Description</label>
										<div>
											<input type="text" class="form-control"
												name="product-description" placeholder="description"
												value="${currentPeriodical.description}">
										</div>
									</div>

									<div class="form-group">
										<label for="inputDomain" class="control-label">Image</label>
										<div>
											<!--    <label for="uploadbtn" class="uploadButton">Загрузить файл</label> -->
											<input type="file" id="product-image" name="product-image"
												value="${currentPeriodical.image}">
											<%-- <input type="type" id="product-image"
										name="product-image"
										value="${currentPeriodical.image}"> --%>
											<!--   <input type="text" class="form-control"  placeholder="image"> -->
										</div>
									</div>
									<div class="form-group">
										<label for="inputApiKey" class="control-label">Periodicity</label>
										<div>
											<input type="text" class="form-control" id="inputApiKey"
												placeholder="periodicity" name="product-periodicity"
												value="${currentPeriodical.periodicity}">
										</div>
									</div>
									<div class="form-group">
										<label for="inputApiKey" class="control-label">Price</label>
										<div>
											<input type="text" class="form-control" id="inputApiKey"
												placeholder="price" name="product-priceForPublishment"
												value="${currentPeriodical.priceForPublishment}">
										</div>
									</div>
									<div class="form-group">
										<label for="inputApiKey" class="control-label">Data
											Last Modified</label>
										<div>
											<input type="text" class="form-control" id="inputApiKey"
												placeholder="Data Last Modified" name="product-lastModified"
												value="${currentPeriodical.lastModified}">
										</div>
									</div>
									<div class="form-group">
							<!-- 
										<p>
											<input name="product-delete" type="radio" value="delete"> Delete
										</p> -->
										<p>
											<input name="product-delete" type="radio"
												value="updateDelete"> Update Delete
										</p>
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										ng-click="dismissSettings()">Close</button>
									<input type="hidden" name="id" value="${currentPeriodical.id}">

									<input type="submit" value="Save changes"
										class="btn btn-primary">
								</div>
							</form>
						</div>
					</div>
				</div>
				<!--end edit product  -->
				<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
					<header role="banner" aria-label="Heading">
					<div class="breadcrumb" role="navigation" aria-label="Breadcrumbs">
						<div class="_cont">
							<ol>
								<li><a href="${pageContext.servletContext.contextPath}/">Home</a></li>
								<li><a
									href="${pageContext.servletContext.contextPath}/products">Journal</a></li>
								<li>${currentPeriodical.name}</li>
							</ol>
						</div>
					</div>
					</header>
					<section aria-label="Main content" role="main"
						class="product-detail">
					<div itemscope itemtype="#">
						<div class="shadow">
							<div class="_cont detail-top">
								<div class="cols">
									<div class="left-col">
										<div class="big">
											<span> <img src="${currentPeriodical.image}"
												width="90%" class="img-thumbnail"></span>
										</div>
									</div>
									<div class="right-col">
										<h1 itemprop="name">${currentPeriodical.name}</h1>
										<div itemprop="offers" itemscope
											itemtype="http://schema.org/Offer">
											<meta itemprop="priceCurrency" content="USD">
											<link itemprop="availability"
												href="http://schema.org/InStock">
											<div class="price-shipping">
												<div class="price price-total price-pay-as-go">$
													${currentPeriodical.priceForPublishment}</div>
												<!--                <a>Free shipping</a>-->
											</div>
											<div class="swatches">
												<div class="swatch clearfix" data-option-index="0">
													<div class="header">mounth</div>
													<div class="price-radios">
														<div class="swatch-element plain m available">
															<label> <input type="radio" name="paygo"
																value="30" data-val="$30" checked> 1
															</label>
														</div>
														<div class="swatch-element plain m available">
															<label> <input type="radio" name="paygo"
																value="80" data-val="$80" checked> 3
															</label>
														</div>
														<div class="swatch-element plain m available">
															<label> <input type="radio" name="paygo"
																value="160" data-val="$160" checked> 6
															</label>
														</div>
														<div class="swatch-element plain m available">
															<label> <input type="radio" name="paygo"
																value="320" data-val="$320" checked> 12
															</label>
														</div>
													</div>
												</div>
											</div>
											<!-- <form method="post" enctype="multipart/form-data" id="AddToCartForm"> -->
											<form id="AddToCartForm">
												<select name="id" id="productSelect" quickbeam="product"
													class="product-single__variants">
													<option selected="selected" data-sku="" value="1">
														1 month $ ${currentPeriodical.priceForPublishment} USD</option>
													<option data-sku="" value="3">3 month $85 USD</option>
													<option data-sku="" value="6">6 month $160 USD</option>
													<option data-sku="" value="12">6 month $300 USD</option>

												</select>
											</form>
											<div style="clear: both;"></div>
											<!--</div>-->
											<script
												src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

											<script>
												(function($) {
													// Handles the radio pay-as-you-go choice
													$(
															".price-radios input[type='radio']")
															.click(
																	function() {
																		var dataValue = $(
																				this)
																				.attr(
																						"data-val");
																		$(
																				".price-pay-as-go")
																				.text(
																						dataValue);
																	});

													// Handles the monthly subscription drop down box
													$("#pick-package-dd")
															.change(
																	function() {
																		$(
																				".price-sub")
																				.text(
																						$(
																								"option:selected",
																								this)
																								.attr(
																										"data-val"));
																	});
												})(jQuery);
											</script>
											<div class="btn-and-quantity-wrap">
												<div class="btn-and-quantity">

													<div id="AddToCart" quickbeam="add-to-cart">
														<span id="AddToCartText">Add to Cart</span>
													</div>
													<br> <br> <br>


												</div>
											</div>



											</form>
											<div class="tabs">
												<div class="tab-labels">
													<span data-id="1" id="tab-slide-1" class="active">Info</span>

													<!-- 	<a href="#" class="btn btn-success" data-toggle="modal"
															data-target="#settings"> <i
															class="fa fa-pencil-square-o"></i>
														</a>
													 -->



												</div>

												<div class="tab-slides">
													<div id="tab-slide-1" itemprop="description"
														class="slide active">${currentPeriodical.description}
													</div>

												</div>
												<br>
												<!--edit  -->
												<c:if test="${userRole eq 'ADMIN'}">
													<button type="button" class="btn btn-warning"
														data-toggle="modal" data-target="#settings">Edit
														Description</button>
												</c:if>
												<!--  -->
												<!--delete  -->
												<br> <br>
												<c:if test="${userRole eq 'ADMIN'}">
													<form action="delete-product" id="delete-product"
														method="POST">
														<button type="button" class="btn btn-danger"
															href="javascript:;"
															onclick="document.getElementById('delete-product').submit();">
															<b> <input type="hidden" name="productId"
																value="${currentPeriodical.id}">
															</b>Delete
														</button>
													</form>
												</c:if>
												<!--end delete  -->
											</div>
											<div class="social-sharing-btn-wrapper">
												<span id="social_sharing_btn">Share</span>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					</section>

					<div id="quick-cart" quickbeam="cart">
						<a id="quick-cart-pay" quickbeam="cart-pay" class="cart-ico">
							<span> <strong class="quick-cart-text"
								href="/payment.html">Pay<br></strong> <span
								id="quick-cart-price">0</span> <span
								id="quick-cart-pay-total-count">0</span>
						</span>
						</a>
					</div>

				</div>
				<h1 class="templatemo-header"></h1>






			</div>
		</div>
		<!-- right section -->
	</div>

	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.14/angular.min.js'></script>
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.5/js/bootstrap.min.js'></script>
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/ngStorage/0.3.6/ngStorage.min.js'></script>




	<!-- Quickbeam cart end -->
	<script
		src='http://raw.githubusercontent.com/greenwoodents/quickbeam.js/master/dist/quickbeam.min.js'></script>
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/gsap/1.18.2/TweenMax.min.js'></script>
	<script src="pages/js/index_prod.js"></script>
	<script src="pages/js/edit_product.js"></script>
</body>
</html>
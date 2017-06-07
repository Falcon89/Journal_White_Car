<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<link href="pages/css/style_add.css" rel="stylesheet" type="text/css">

<!-- 	  <link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css'>
<link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap-theme.min.css'> -->
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
		<!--  -->
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
								<label for="inputApiKey" class="control-label">Data Last
									Modified</label>
								<div>
									<input type="text" class="form-control" id="inputApiKey"
										placeholder="Data Last Modified" name="product-lastModified"
										value="${currentPeriodical.lastModified}">
								</div>
							</div>
							<input type="hidden" value="${currentPeriodical.id}" name="id">
							<input type="text" value="${currentPeriodical.id}" name="id">
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								ng-click="dismissSettings()">Close</button>
							<input type="hidden" name="id" value="${currentPeriodical.id}">

							<input type="submit" value="Save changes" class="btn btn-primary">
						</div>
					</form>
				</div>
			</div>
		</div>
		<!--end edit product  -->
		<!--  -->
		<!-- left section -->
		<div
			class="col-lg-6 col-md-6 col-sm-6 col-xs-12 white-bg right-container">
			<h1 class="logo-right hidden-xs margin-bottom-60">White Car</h1>
			<div class="tm-right-inner-container">
				<!--  -->
				<div class="container">
					<header class="page-header">
					<div class="branding">
						<img src="https://vuejs.org/images/logo.png" alt="Logo"
							title="Home page" class="logo" />
						<h1>Our Products</h1>
					</div>
					</header>
					<main id="app"> <router-view></router-view> </main>
				</div>
				<c:if test="${userRole eq 'ADMIN'}">
					<template id="product-list">
					<div class="actions">
						<a class="btn btn-default" v-link="{path: '/add-product'}"> <span
							class="glyphicon glyphicon-plus"></span> Add product
						</a>
					</div>
					</template>
					<template id="add-product">
					<h2>Add new product</h2>
					<form action="create-product" method="POST">
						<!-- <form v-on:submit="createProduct"> -->
						<div class="form-group">
							<label for="add-name">Name</label> <input class="form-control"
								id="add-name" v-model="product.name" name="product-name"
								required />
						</div>
						<div class="form-group">
							<label for="add-description">Description</label>
							<textarea class="form-control" id="add-description" rows="5"
								v-model="product.description" name="product-description"></textarea>
							<!--  -->
							<br> <label for="add-description">Image</label> <input
								type="file" id="product-image" name="product-image"
								value="${currentPeriodical.image}">

							<!--  -->
						</div>

						<div class="form-group left-col">
							<label for="add-priority">Periodicity</label>
							<textarea class="form-control" id="add-periodicity" rows="1"
								name="product-periodicity"></textarea>
						</div>
						<div class="form-group left-col">
							<div class="form-group">
								<label for="add-devArea">Price</label>
								<textarea class="form-control" rows="1"
									name="product-priceForPublishment"></textarea>
							</div>
						</div>
						<!-- end of left col -->

						<div class="clear-col">
							<button type="submit" class="btn btn-primary">Create</button>
							<a v-link="'/'" class="btn btn-default">Cancel</a>
						</div>
						<!-- end of clear -->

					</form>
					</template>
				</c:if>
				<template id="product">
				<h2>{{ product.name }}</h2>
				<b>Description: </b>
				<div>{{ product.description }}</div>
				<b>Price:</b>
				<div>
					{{ product.price }}<span class="glyphicon glyphicon-euro"></span>
				</div>
				<br />
				<span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span>
				<a v-link="'/'">Backt to product list</a> </template>

				<template id="product-edit">
				<h2>Edit product</h2>
				<form v-on:submit="updateProduct">
					<div class="form-group">
						<label for="edit-name">Name</label> <input class="form-control"
							id="edit-name" v-model="product.name" required />
					</div>
					<div class="form-group">
						<label for="edit-description">Description</label>
						<textarea class="form-control" id="edit-description" rows="3"
							v-model="product.description"></textarea>
					</div>
					<div class="form-group">
						<label for="edit-price">Price, <span
							class="glyphicon glyphicon-euro"></span></label> <input type="number"
							class="form-control" id="edit-price" v-model="product.price" />
					</div>
					<button type="submit" class="btn btn-primary">Save</button>
					<a v-link="'/'" class="btn btn-default">Cancel</a>
				</form>
				</template>

				<template id="product-delete">
				<h2>Delete product {{ product.name }}</h2>
				<form v-on:submit="deleteProduct">
					<p>The action cannot be undone.</p>
					<button type="submit" class="btn btn-danger">Delete</button>
					<a v-link="'/'" class="btn btn-default">Cancel</a>
				</form>
				</template>
				</template>
				<!--  -->
				<c:forEach var="periodical" items="${allProducts}">
					<a href="DescriptionProduct?id=${periodical.id}">

						<div class="card" id="${periodical.id}">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<article class="templatemo-item"> <!-- <h2>Green Car, may 2017</h2> -->
								<h2>
									<c:out value="${periodical.name}" />
								</h2>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"></div>

								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"></div>
								<img src="${periodical.image}" width="90%" alt="Gutman Island"
									class="img-thumbnail"> <a
									href="${pageContext.servletContext.contextPath}/DescriptionProduct?id=${periodical.id}"
									class="btn btn-warning">Subscription</a> <a
									href="${pageContext.servletContext.contextPath}/PaymentServlet"
									class="btn btn-warning">Buy</a> </article>

							</div>
						</div>
					</a>
				</c:forEach>
				<hr>
				<br>
			</div>
			<div class="tm-right-inner-container">
				<h1 class="templatemo-header"></h1>
				<hr>
				<ul class="pagination">

					<li class="active"><a
						href="#">1</a></li>
				<%-- 	<li class="waves-effect"><a
						href="${pageContext.servletContext.contextPath}/products2">2</a></li> --%>

				</ul>
				<footer>
				<p
					class="col-lg-6 col-md-6 col-sm-12 col-xs-12 templatemo-copyright">
					Copyright &copy; 2017 Black White
					<!-- Credit: www.templatemo.com -->
				</p>
				<p class="col-lg-6 col-md-6 col-sm-12 col-xs-12 templatemo-social">
					<a href="#"><i class="fa fa-facebook fa-medium"></i></a> <a
						href="#"><i class="fa fa-twitter fa-medium"></i></a> <a href="#"><i
						class="fa fa-google-plus fa-medium"></i></a> <a href="#"><i
						class="fa fa-youtube fa-medium"></i></a> <a href="#"><i
						class="fa fa-linkedin fa-medium"></i></a>
				</p>
				</footer>
			</div>
		</div>
		<!-- right section -->
	</div>
	<script src="pages/js/vue.min.js"></script>
	<script src="pages/js/vue-router.min.js"></script>
	<script src="pages/js/index_add.js"></script>
</body>
</html>
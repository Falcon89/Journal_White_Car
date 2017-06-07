<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="UTF-8" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="pages/css/styleadmin.css">
<link rel="stylesheet" href="pages/css/style_users.css">
<link rel="stylesheet" href="pages/css/style_users2.css">
<link rel="stylesheet" href="pages/css/font-awesome.min.css">
<link rel="stylesheet" href="pages/css/smart-forms.css">
<script src="https://use.fontawesome.com/b86b29d1d4.js"></script>

<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no">
</head>
<body>


	<div class="sidebar">
		<nav class="navbar-default navbar-side" role="navigation">
		<div class="sidebar-collapse">
			<ul class="nav" id="main-menu">
				<li><img src="pages/images/find_user.png" width="65%"
					class="user-image img-responsive" />
					<p>Admin</p></li>
			</ul>
		</div>
		</nav>
		<br> <br>
		<div class="item pointer">
			<i class="fa fa-envira" aria-hidden="true"></i>

			<div class="title">
				<a href="${pageContext.servletContext.contextPath}/">Home</a>
			</div>
		</div>


		<div class="item pointer" data-target="connections">
			<i class="fa fa-connectdevelop" aria-hidden="true"></i>
			<div class="title">All Product</div>
		</div>

		<div class="item pointer" data-target="connections2">
			<i class="fa fa-connectdevelop" aria-hidden="true"></i>
			<div class="title">All Dell Product</div>
		</div>




		<div class="item pointer" data-target="Users"
			data-tooltip="Users ALL FROM BD">
			<i class="fa fa-cog" aria-hidden="true"></i>
			<div class="title">All Users</div>
		</div>
		<!-- 		<div class="item pointer" data-target="AddProduct"
			data-tooltip="Users ALL FROM BD">
<i class="fa fa-refresh fa-spin fa-3x fa-fw" aria-hidden="true"></i>
<span class="sr-only">Refreshing...</span>
			<div class="title">Add Product</div>
		</div> -->
		<c:choose>
			<c:when test="${userRole eq 'ADMIN'}">
				<div class="item pointer" data-target="subscription"
					data-tooltip="all the financial stuff">
					<i class="fa fa-credit-card-alt" aria-hidden="true"></i>
					<div class="title">Subscription</div>

				</div>
			</c:when>
		</c:choose>
		<%-- 	<form action="${pageContext.request.contextPath}/loginpage" method="post">
    <input type="submit" value="Logout" />
</form> --%>

		<!-- 		<div class="item pointer" data-target="analytics"
			data-tooltip="Logout">
			<i class="fa fa-sign-out" aria-hidden="true"></i>

<span
				class="pull-right hidden-xs showopacity glyphicon glyphicon-envelope">
					<i class="material-icons title">Logout</i>
			</span> 
		</div> -->

		<form action="logout" id="logoutform">
			<a href="javascript:;"
				onclick="document.getElementById('logoutform').submit();"><b>
					${LOGOUT} </b><span>
					<div class="item pointer" data-target="settings"
						data-tooltip="LOGOUT">
						<i class="fa fa-sign-out" aria-hidden="true"></i>
						<div class="title">Settings</div>
					</div>
			</span> </a>
		</form>
	</div>

	<div class="container">
		<div class="page" id="dashboard">

			<h2>
				Dashboard
				<h2>
					<input>
		</div>


		<div class="page" id="connections">
			<div class="table-users">
				<div class="header">Products</div>
				<table cellspacing="0">
					<tr>
						<th><strong>Id</strong></th>
						<th><strong>Name</strong></th>
						<th><strong>Description</strong></th>
						<th><strong>Image</strong></th>
						<th><strong>Price</strong></th>
						<th><strong>Delete</strong></th>

					</tr>
					<c:forEach var="listperiodicals" items="${listperiodicals}">
						<tr>
							<th><c:out value="${listperiodicals.id}" /></th>
							<th><c:out value="${listperiodicals.name}" /></th>
							<th><c:out value="${listperiodicals.description}" /></th>
							<th><img src="${listperiodicals.image}" width="80%"></th>
							<th><c:out value="${listperiodicals.priceForPublishment}" /></th>
							<th><c:out value="${listperiodicals.isDeleted}" /></th>
						</tr>
					</c:forEach>

				</table>
			</div>
		</div>
	</div>
	<!--  -->

	<div class="container">
		<div class="page" id="dashboard"></div>
		<div class="page" id="connections2">
			<div class="table-users">
				<div class="header">Products</div>
				<table cellspacing="0">
					<tr>
						<th><strong>Id</strong></th>
						<th><strong>Name</strong></th>
						<th><strong>Description</strong></th>
						<th><strong>Image</strong></th>
						<th><strong>Price</strong></th>
						<th><strong>Delete</strong></th>
						<th><strong>Status</strong></th>
					

					</tr>
					<c:forEach var="alldeleteProduct" items="${alldeleteProduct}">
							<a href="DescriptionProduct?id=${alldeleteProduct.id}">
						<tr>
							<th>
							<c:out value="${alldeleteProduct.id}" /></th>
							<th><c:out value="${alldeleteProduct.name}" /></th>
							<th><c:out value="${alldeleteProduct.description}" /></th>
							<th><img src="${alldeleteProduct.image}" width="80%"></th>
							<th><c:out value="${alldeleteProduct.priceForPublishment}" /></th>
							<th><c:out value="${alldeleteProduct.isDeleted}" /></th>
							<th>	<a href="${pageContext.servletContext.contextPath}/DescriptionProduct?id=${alldeleteProduct.id}"
							class="btn btn-warning">Subscription</a> </th>
						</tr>
					</c:forEach>

				</table>
			</div>
		</div>
	</div>

	<!--  -->
<!--  -->
	<div class="page" id="Users">
		<h2>
			Users
			<h2>
				<div class="table-users">
					<div class="header">Users</div>
					<table cellspacing="0">
						<tr>
							<th>ID</th>
							<th>LastName</th>
							<th>Email</th>
							<th>Password</th>
							<th>Role</th>
							<th>User Image</th>
						</tr>
						<c:forEach var="user" items="${listOfUsers}">
							<tr>
								<th><c:out value="${user.id}" /></th>
								<th><c:out value="${user.lastName}" /></th>
								<th><c:out value="${user.email}" /></th>
								<th><c:out value="${user.password}" /></th>
								<th><c:out value="${user.role}" /></th>
								<th><img src="${user.userImage}" width="100%"></th>
							</tr>
						</c:forEach>
					</table>
				</div>
	</div>
	<div class="page" id="subscription">
		<h2>
			Subscription
			<h2>
				<input>
	</div>
	<div class="page" id="AddProduct">

		<!--  -->
		<div class="tm-right-inner-container">
			<h1 class="templatemo-header">Our Products</h1>

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
		<!--  -->
	</div>
	<div class="page" id="analytics">
		<h2>
			Analytics
			<h2>
	</div>
	</div>
</body>
<script
	src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js'></script>
<script src="pages/js/indexadmin.js"></script>
</body>
</html>
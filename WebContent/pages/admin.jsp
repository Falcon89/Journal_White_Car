<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="pages/css/styleadmin.css">
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
		<div class="item pointer" data-target="dashboard"
			data-tooltip="all you wanna know">
			<i class="fa fa-envira" aria-hidden="true"></i>
			<div class="title">Logo/Dash</div>
		</div>
		<c:if test="${role eq 'admin'}">
			<div class="item pointer" data-target="connections"
				data-tooltip="manage your social media connections">
				<i class="fa fa-connectdevelop" aria-hidden="true"></i>
				<div class="title">Connections</div>
			</div>
		</c:if>

		<div class="item pointer" data-target="settings"
			data-tooltip="the settings we dont have a place for">
			<i class="fa fa-cog" aria-hidden="true"></i>
			<div class="title">Settings</div>
		</div>



		<div class="item pointer" data-target="settings">
			<a href="${pageContext.servletContext.contextPath}/"> <i
				class="fa fa-home fa-medium"></i>Homepage
			</a>
		</div>






		<c:if test="${role eq 'user'}">
			<div class="item pointer" data-target="subscription"
				data-tooltip="all the financial stuff">
				<i class="fa fa-credit-card-alt" aria-hidden="true"></i>
				<div class="title">Subscription</div>

			</div>
		</c:if>
		<div class="item pointer" data-target="analytics"
			data-tooltip="Logout">
			<i class="fa fa-sign-out" aria-hidden="true"></i>
			<%-- 	<form action="${pageContext.request.contextPath}/loginpage" method="post">
    <input type="submit" value="Logout" />
</form> --%>


			<!-- <div class="title">Logout</div> -->
		</div>
		<form action="logout" id="logoutform">
			<a href="javascript:;"
				onclick="document.getElementById('logoutform').submit();"><b>
					${LOGOUT} </b><span
				class="pull-right hidden-xs showopacity glyphicon glyphicon-envelope">
					<i class="material-icons title">Logout</i>
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
			<div class="claim">
				<div class="title">Connections</div>
				<div class="description">Hier kannst du die automatisch
					geladenen Inhalte deiner Webseite verwalten und einstellen was auf
					deiner Seite sichtbar sein soll. Jedes einzelne Modul ist eine
					eigene Unterseite.</div>
				<button class="addConnection">New Connection</button>
			</div>

		</div>
		<div class="page" id="settings">
			<h2>
				Settings
				<h2>
					<input>
		</div>
		<div class="page" id="subscription">
			<h2>
				Subscription
				<h2>
					<input>
		</div>

		<div class="page" id="analytics">
			<h2>
				Analytics
				<h2>
					<input>
		</div>
	</div>
</body>
<script
	src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js'></script>

<script src="pages/js/indexadmin.js"></script>

</body>
</html>
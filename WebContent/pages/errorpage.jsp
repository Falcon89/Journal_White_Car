<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<%-- <%@ page import="com.epam.lab.i18n.LocaleSingleton"%>

<%
	LocaleSingleton.getInstance().setLocale(request);
%> --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h1 style="text-align: center;">Sorry my friend, but u have no access to this URL! First try Login.</h1>
	<a href="login" style="float:right">Go back to main page</a>
	<img  src="images/ban.jpg" style="margin-left: 450px">
</body>
</html>
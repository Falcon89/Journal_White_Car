<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet" type="text/css">
	<link href="pages/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="pages/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="pages/css/templatemo_style.css" rel="stylesheet" type="text/css">	
	  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
  <link rel='stylesheet prefetch' href='http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css'>
  <link href="pages/css/stylelogin.css" rel="stylesheet" type="text/css">	
</head>
<body>
	<div class="templatemo-logo visible-xs-block">
		<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 black-bg logo-left-container">
			<h1 class="logo-left">Black</h1>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 white-bg logo-right-container">
			<h1 class="logo-right">White</h1>
		</div>			
	</div>
	<div class="templatemo-container">
		<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 black-bg left-container">
			<h1 class="logo-left hidden-xs margin-bottom-60">Journal</h1>			
			<div class="tm-left-inner-container">
	<ul class="nav nav-stacked templatemo-nav">
				  <li><a href="${pageContext.servletContext.contextPath}/"><i class="fa fa-home fa-medium"></i>Homepage</a></li>
				  <li><a href="${pageContext.servletContext.contextPath}/products"><i class="fa fa-shopping-cart fa-medium"></i>Journals</a></li>
				  <li><a href="${pageContext.servletContext.contextPath}/services"><i class="fa fa-send-o fa-medium"></i>Services</a></li>
				  <li><a href="${pageContext.servletContext.contextPath}/about"><i class="fa fa-gears fa-medium"></i>About Us</a></li>
				  <li><a href="${pageContext.servletContext.contextPath}/contact"><i class="fa fa-envelope-o fa-medium"></i>Contact</a></li>
				  <br><br>
				   <li><a href="${pageContext.servletContext.contextPath}/login" class="active"><i class="fa fa-sign-in fa-medium"></i>Login in/Registration</a></li>
				   <li><a href="${pageContext.servletContext.contextPath}/admin"><i class="fa fa-briefcase fa-medium"></i>Admin panel</a></li>
				</ul>
			</div>
		</div> <!-- left section -->
		<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 white-bg right-container">
			<h1 class="logo-right hidden-xs margin-bottom-60">White Car</h1>		
			<div class="tm-right-inner-container">
<!--				<h1 class="templatemo-header">Comapany</h1>-->
				
<div id="page-wrapper">
      <div id="modal-wrapper">
        <div id="modal">
          <div id="cards">
            <div class="card" id="login">
              <div class="box">
                <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="84px" height="70px" viewBox="0 0 600 332" enable-background="new 0 0 600 332" xml:space="preserve">
                  <path id="SVGID_1_" d="M48.207,322.346H2.201l195.546-296.91l29.083,24.881L48.207,322.346L48.207,322.346z M366.916,323.3L184.581,45.545l22.235-34.362l182.337,277.754L366.916,323.3L366.916,323.3z M206.816,322.346c0,0-32.511-50.283-67.621-102.999c-7.233-10.859-14.576-21.821-21.768-32.47c-0.586-0.867,14.985-46.926,21.658-36.678c7.217,11.086,14.388,22.232,21.347,33.138c36.734,57.58,67.509,108.465,67.509,108.465L206.816,322.346L206.816,322.346z M313.043,162.238l-39.053,59.399c-31.744,48.284-57.467,87.41-57.467,87.41l-31.942-22.019c0,0,29.998-44.644,67.215-101.253c5.132-7.806,10.351-15.742,15.577-23.694c4.91-7.47,9.831-14.953,14.699-22.356C321.356,79.969,366.42,11.184,366.42,11.184h45.049C411.469,11.184,353.769,100.292,313.043,162.238L313.043,162.238z M375.986,309.048l-29.083-24.882L526.486,11.184h45.046L375.986,309.048L375.986,309.048z"></path>
                </svg>
              </div>
              <form id="login-form" action="cabinet" method="POST">
                <label>Email
                 
                </label>
                <input type="email" id="login-email"  name="login-email" class="textbox" required>
                <label>Password
       
                </label>
                <input type="password" id="login-password" name="login-password" class="textbox" required>
              <button type="submit" class="proceed">Log-in to your account <i class="ion-ios-arrow-thin-right"></i></button>
              </form>
            </div>
            <div class="card" id="register">
              <div class="box">
              <div id="branding-small">
                <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="42px" height="35px" viewBox="0 0 600 332" enable-background="new 0 0 600 332" xml:space="preserve">
                  <path id="SVGID_1_" d="M48.207,322.346H2.201l195.546-296.91l29.083,24.881L48.207,322.346L48.207,322.346z M366.916,323.3L184.581,45.545l22.235-34.362l182.337,277.754L366.916,323.3L366.916,323.3z M206.816,322.346c0,0-32.511-50.283-67.621-102.999c-7.233-10.859-14.576-21.821-21.768-32.47c-0.586-0.867,14.985-46.926,21.658-36.678c7.217,11.086,14.388,22.232,21.347,33.138c36.734,57.58,67.509,108.465,67.509,108.465L206.816,322.346L206.816,322.346z M313.043,162.238l-39.053,59.399c-31.744,48.284-57.467,87.41-57.467,87.41l-31.942-22.019c0,0,29.998-44.644,67.215-101.253c5.132-7.806,10.351-15.742,15.577-23.694c4.91-7.47,9.831-14.953,14.699-22.356C321.356,79.969,366.42,11.184,366.42,11.184h45.049C411.469,11.184,353.769,100.292,313.043,162.238L313.043,162.238z M375.986,309.048l-29.083-24.882L526.486,11.184h45.046L375.986,309.048L375.986,309.048z"></path>
                </svg>
              </div>
              
              
              
              
                <div class="box-header">Register</div>
                <form id="register-form" action="register" method="POST">
	                <label>First Name</label>
	                <input type="text" class="textbox" name="register-firstname">
	                
	                <label>Last Name</label>
	                <input type="text" class="textbox" name="register-lastname">
                  
                  <label>Email</label>
                  <input type="email" id="register-email" class="textbox" name="register-email">
                  <label>Password</label>
                  <input type="password" id="register-password" class="textbox" name="register-password">
                  <label>Confirm Password</label>
                  <input type="password" id="register-password-conf" class="textbox">
              <button type="submit" class="proceed">Create an account <i class="ion-ios-arrow-thin-right"></i></button>
                </form>
                
                
                
              </div>
            </div>
          </div>
          <div id="toggle-tabs">
            <div class="tab" id="toggle-login">Sign In</div>
            <div class="tab" id="toggle-register">Register</div>
          </div>
        </div>
      </div>
    </div>
			</div>	
		</div> <!-- right section -->
	</div>	
	  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script src="pages/js/indexlogin.js"></script>
</body>
</html>
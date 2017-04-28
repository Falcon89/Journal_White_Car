<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<title>Contact - Black White HTML5 Template</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet" type="text/css">
	<link href="pages/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="pages/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="pages/css/templatemo_style.css" rel="stylesheet" type="text/css">	
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
				  <li><a href="${pageContext.servletContext.contextPath}/contact" class="active"><i class="fa fa-envelope-o fa-medium"></i>Contact</a></li>
				  <br><br>
				   <li><a href="${pageContext.servletContext.contextPath}/login"><i class="fa fa-sign-in fa-medium"></i>Login in/Registration</a></li>
				   <li><a href="${pageContext.servletContext.contextPath}/admin"><i class="fa fa-briefcase fa-medium"></i>Admin panel</a></li>
				</ul>
			</div>
		</div> <!-- left section -->
		<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 white-bg right-container">
			<h1 class="logo-right hidden-xs margin-bottom-60">White Car</h1>
			<div class="tm-right-inner-container">
				<h1 class="templatemo-header">Contact</h1>
				<div class="row">
                    <div class="col-sm-12 col-md-12">
                        <div id="map-canvas"></div>
                        <address>
						  <strong>Black White Company</strong><br>
						  180 Aenean Quis Semper<br>
						  Maecenas Adipiscing, Feugiat 10450<br><br>
						  Phone: 010-060-0160<br>
                          Email: info@company.com<br><br>
						</address>
                    </div>

                    <div class="col-sm-12 col-md-12">
                        <form action="#" method="post">

                            <div class="form-group">
                                <input type="text" id="contact_name" class="form-control" placeholder="Name" />
                            </div>
                            <div class="form-group">
                                <input type="text" id="contact_email" class="form-control" placeholder="Email Address" />
                            </div>
                            <div class="form-group">
                                <input type="text" id="contact_subject" class="form-control" placeholder="Subject" />
                            </div>
                            <div class="form-group">
                                <textarea id="contact_message" class="form-control" rows="9" placeholder="Write a message"></textarea>
                            </div>
                            <button type="submit" class="btn btn-warning">Send</button>

                        </form>
                    </div>

                    <div class="clearfix"></div>
                </div>
				<footer>
					<p class="col-lg-6 col-md-6 col-sm-12 col-xs-12 templatemo-copyright">Copyright &copy; 2017 Black White <!-- Credit: www.templatemo.com --></p>
					<p class="col-lg-6 col-md-6 col-sm-12 col-xs-12 templatemo-social">
						<a href="#"><i class="fa fa-facebook fa-medium"></i></a>
						<a href="#"><i class="fa fa-twitter fa-medium"></i></a>
						<a href="#"><i class="fa fa-google-plus fa-medium"></i></a>
						<a href="#"><i class="fa fa-youtube fa-medium"></i></a>
						<a href="#"><i class="fa fa-linkedin fa-medium"></i></a>
					</p>
				</footer>
			</div>	
		</div> <!-- right section -->
	</div>
	<script src="pages/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript">
		var map = '';
		var center;

		function initialize() {
		    var mapOptions = {
		      zoom: 16,
		      center: new google.maps.LatLng(16.8496189,96.1288854)
		  	};
		  
		  	map = new google.maps.Map(document.getElementById('map-canvas'),  mapOptions);

		  	google.maps.event.addDomListener(map, 'idle', function() {
			  calculateCenter();
			});
			
			google.maps.event.addDomListener(window, 'resize', function() {
			  map.setCenter(center);
			});
		}

		function calculateCenter() {
		  center = map.getCenter();
		}

		function loadGoogleMap(){
		    // load google map
		    var script = document.createElement('script');
		    script.type = 'text/javascript';
		    script.src = 'https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&' +
		    'callback=initialize';
		    document.body.appendChild(script);
		}

		$(document).ready( function() {
			loadGoogleMap();
		});

	</script>	
</body>
</html>
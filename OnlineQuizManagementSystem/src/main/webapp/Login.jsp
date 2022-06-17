<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="Aviato E-Commerce Template">

<meta name="author" content="Themefisher.com">

<title>Login</title>


<!-- Main Stylesheet -->
<link rel="stylesheet" href="css/style">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link rel="shortcut icon" href="/images/favicon.png" />

<link rel="dns-prefetch" href="//cdnjs.cloudflare.com">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" href="css1/style1.css" />


<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>

</head>

<body
	style="background-image: url('image/Backgroundpage.jpg'); background-repeat: no-repeat; background-size: 1500px;">
	<%@include file="Header.jsp"%>
	<div class="container">


		<div class="back"
			style="background-color: #e5e5e5; margin-top: 20px; width: 650px; padding: 40px; margin-left: 250px; border-radius: 70px">

			<h4
				style="font-weight: bold; font-size: 20px; color: green; font-color: green; text-align: center"></h4>


			<h1
				style="font-weight: bold; font-size: 50px; text-align: center; margin-bottom: 40px;">Login</h1>

			<form class="form validity" method="post"
				action="LoginDetailsServlet">
				<%String ans =(String)request.getAttribute("message"); %>
					<%if(null!=ans){ %>
						<h4 style=" font-weight:bold; font-size:15px; color:green; text-align: center"><%=ans %></h4>
					<%} %>
				<div class="form-group">

					<div></div>

					<input id="mail" name="email" placeholder="Enter EmailId"
						pattern="^(?![\.\-_])((?![\-\._][\-\._])[a-z0-9\-\._]){0,63}[a-z0-9]@(?![\-])((?!--)[a-z0-9\-]){0,63}[a-z0-9]\.(|((?![\-])((?!--)[a-z0-9\-]){0,63}[a-z0-9]\.))(|([a-z]{2,14}\.))[a-z]{2,14}$"
						class="form-control" data-missing="This field is required"
						type="email" required>
				</div>

				<div class="form-group simple">

					<input type="password" name="password" class="form-control"
						id="myInput" placeholder="Enter Password" required> <br>
					<!-- An element to toggle between password visibility -->
					<input type="checkbox" style="font-size: 17px"
						onclick="myFunction()"><label style="padding: 10px;">Show
						Password</label>

				</div>



				<button class="btn btn-block btn-primary" type="submit">Login</button>
				<br>
				<div>
					<h4
						style="font-weight: bold; font-size: 15px; color: red; text-align: center"></h4>
				</div>
				<p class="mt-20">
					Forget Password<a href="ForgetPassword.jsp" style="color: blue"> Forget Password</a>
				</p>
				<p class="mt-20">
					New in this site ?<a href="SignUp.jsp" style="color: blue"> Create New Account</a>
				</p>
				<p class="mt-20">
					Go to home<a href="Index.jsp" style="color: blue"> Back to Home</a>
				</p>
			</form>

		</div>
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="js1/jquery.validity.min.js"></script>
	<script src="js1/script.js"></script>
	<script>
		function myFunction() {
			var x = document.getElementById("myInput");
			if (x.type === "password") {
				x.type = "text";
			} else {
				x.type = "password";
			}
		}
	</script>
</body>
</html>
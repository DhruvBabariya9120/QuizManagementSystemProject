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

<title>Forget password</title>


<!-- Main Stylesheet -->
<link rel="stylesheet" href="css/style">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" href="css1/style1.css" />

<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<script src="js1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$("input[type=email]").change(function() {
			var str = $("#mail").val();
			$.get("ForgetpasswordServlet", {
				email : str
			}).done(function(data) {

				if (data == 'true') {
					$('#email-error').html("This email id not exist");
					$(document).ready(function() {
						$("input[type=email]").val('').focus();
					});

				}
			});
		});
	});
</script>
</head>
<body style="background-image:url('image/Backgroundpage.jpg'); background-repeat: no-repeat; background-size: 1500px">
<%@include file="Header.jsp" %>
	<div class="container">
		<div class="back"
			style="background-color: #e5e5e5;margin-top: 60px; width: 650px; padding: 40px; margin-left: 270px; border-radius: 70px">
			<form class="form validity" method="post"
				action="ForgetpasswordServlet">
				<h1
					style="font-weight: bold; font-size: 50px; text-align: center; margin-bottom: 40px;">Forget
					password</h1>
				<div class="form-group">

					<div class="form-group">
						<p>Please enter the email address for your account. A
							Password will be sent to you. Once you have Enter the
							your valid Email. you will be able to show a password of
							your account.</p>
						<br> <input id="mail" name="email" placeholder="Enter Email"
							class="form-control" data-mismatch="Please include a valid email"
							type="email" required> <span id="email-error"
							style="color: red; font-weight: bold; font-size: 12px;"></span>
					</div>

				</div>
				<p class="mt-20">
					<a href="Login.jsp" style="color: blue">Back to log in</a>
				</p>
				<button class="btn btn-block btn-primary" type="submit">Forget Password</button>

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
		
	</script>
</body>
</html>

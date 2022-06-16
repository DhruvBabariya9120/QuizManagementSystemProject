<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Signin Page</title>
<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link rel="shortcut icon" href="/images/favicon.png" />

<link rel="dns-prefetch" href="//cdnjs.cloudflare.com">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" href="css1/style1.css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>

<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<!-- Title -->
<title>Registration</title>

<!-- Favicon -->
<link rel="icon" href="img/core-img/favicon.ico">

<!-- Core Stylesheet -->

<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body
	style="background-image: url('image/Backgroundpage.jpg'); background-repeat: no-repeat; background-size: 1500px">
	<%@include file="Header.jsp"%>
	<div class="container">
		<div class="back"
			style="background-color: #FFFFFF; margin-top: 20px; width: 650px; padding: 40px; margin-left: 250px; border-radius: 70px">

			<form class="form validity" action="UserRegistrationServlet"
				method="post">
				<h1
					style="font-weight: bold; font-size: 50px; margin-top: 0px; text-align: center; margin-bottom: 30px;">Sign
					Up</h1>
					
				<div class="form-group">

					<input id="name2" name="name" class="form-control"
						placeholder="Enter Fullname" data-missing="This field is required"
						type="text" required>
				</div>
				<div class="form-group">
					<input id="mail" name="email" class="form-control"
						placeholder="Enter Emailid"
						data-mismatch="Please include a valid email"
						pattern="^(?![\.\-_])((?![\-\._][\-\._])[a-z0-9\-\._]){0,63}[a-z0-9]@(?![\-])((?!--)[a-z0-9\-]){0,63}[a-z0-9]\.(|((?![\-])((?!--)[a-z0-9\-]){0,63}[a-z0-9]\.))(|([a-z]{2,14}\.))[a-z]{2,14}$"
						class="form-control" type="email" required> <span
						id="email-error"
						style="color: red; font-weight: bold; font-size: 12px;"></span>
				</div>

				<div class="form-group simple">

					<input id="contact" name="phoneno" class="form-control"
						placeholder="Enter Phoneno" pattern="[6789][0-9]{9}"
						data-mismatch="Enter 10 digit only" type="text" maxlength="10"
						required>
				</div>
				<span id="errmsg"
					style="color: red; font-weight: bold; font-size: 12px"> </span>
				<div class="form-group simple">

					<select required class="form-control" name="gender">

						<option value="" disabledselectedhidden">Select Gender</option>
						<option value="Male">Male</option>
						<option value="Female">Female</option>
						<option value="Others">Others</option>

					</select>

				</div>



				<div class="form-group simple">

					<!--        <input id="phone2" name="phone" class="form-control" pattern="\d{3}[\-]\d{3}[\-]\d{4}" data-mismatch="Please match the requested format" type="tel" required> -->
					<input type="password" class="form-control" name="password"
						id="myInput" placeholder="Enter password"
						data-mismatch="Password Contail atleast 1 special character and 1 digit and Uppercase also"
						pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required><br>

					<input type="checkbox" onclick="myFunction()"> Show
					Password <a href="Login.jsp" style="color: blue">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
						&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
						Already have an Account?</a>
				</div>


				<button class="btn btn-block btn-primary" type="submit">Submit</button>
			</form>
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

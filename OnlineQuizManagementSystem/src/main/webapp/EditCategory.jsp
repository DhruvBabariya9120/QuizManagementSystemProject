<%@page import="com.quizmanagementsystem.bean.Category"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>


<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<!-- Title -->

<title>Edit Category</title>


<!-- Favicon -->
<link rel="icon" href="img/core-img/favicon.ico">
<link rel="dns-prefetch" href="//cdnjs.cloudflare.com">

<link rel="stylesheet" href="css1/style1.css" />

<!-- Core Stylesheet -->
<link rel="stylesheet" href="css/style.css">
<script src="js1/jquery.min.js"></script>
</head>

<body>


<%Category cat=(Category)request.getAttribute("categoryList");
	System.out.println("category editing "+cat);%>
	
	<!-- Preloader -->
	<div class="preloader d-flex align-items-center justify-content-center">
		<div class="preloader-circle"></div>
		<div class="preloader-img">
			<img src="img/core-img/leaf.png" alt="">
		</div>
	</div>

	<!-- ##### Header Area Start ##### -->
	<%@include file="Header.jsp"%>
	<!-- ##### Header Area End ##### -->

	<!-- ##### Breadcrumb Area Start ##### -->
	<div class="breadcrumb-area">
		<!-- Top Breadcrumb Area -->
		<div
			class="top-breadcrumb-area bg-img bg-overlay d-flex align-items-center justify-content-center "
			style="background-image: url(img/bg-img/24.jpg);"></div>


	<div class="container">

		<div class="back"
			style="background-color: white; margin-top: auto; width: 650px; padding: auto; border-radius: 70px; margin-left: 200px;">

			<form class="form validity" action="EditCategoryServlet" method="post">
				
				<h1 style="font-weight: bold; font-size: 30px; text-align: center; margin-top:30px; margin-bottom: 30px;">Edit Category</h1>
				
				
				
				<div class="form-group">

						<input type="hidden" name="categoryid" value="<%=cat.getCat_id() %>">
					<div class="col-12 mb-4">
						
						<label  style="font-size: 20px; margin-right: 200px; padding: 2px;">Enter Category Name</label> 
						
						<input id="name2" name="categoryname" class="form-control input-group-lg reg_name" data-missing="This field is required" type="text" value="<%=cat.getName() %>" required style="width: 500px;">
				
					</div>
				</div>
				
				
					<%
						String s = (String) request.getAttribute("message");
					if (null != s) {
					%>
					<h4
						style="font-weight: bold; font-size: 20px; color: green; font-color: green; margin-left: 150px;"><%=s%></h4>
					<%
						}
					%>
				</div>

				<div class="checkout-btn mt-30">
					<button class="btn btn-primary" style="margin-left: 300px;">Update Category</button>
					<a href="DisplaycategoryServlet" type="button" class="btn btn-primary" style="margin-left: 20px;">Back</a>
				</div>
			</form>
		</div>
	</div>



	<!-- ##### Breadcrumb Area End ##### -->

	<!-- ##### About Area Start ##### -->

	<!-- ##### About Area End ##### -->

	<!-- ##### Service Area Start ##### -->

	<!-- ##### Service Area End ##### -->

	<!-- ##### Testimonial Area Start ##### -->
	<section class="testimonial-area section-padding-100" style="background-color: white;">
		<div class="container">
			
		</div>
	</section>
	<!-- ##### Testimonial Area End ##### -->

	<!-- ##### Cool Facts Area Start ##### -->
	<!-- ##### Cool Facts Area End ##### -->

	<!-- ##### Team Area Start ##### -->

	<!-- ##### Team Area End ##### -->


	<!-- ##### Footer Area Start ##### -->
	<%@include file="Footer.jsp"%>
	<!-- ##### Footer Area End ##### -->

	<!-- ##### All Javascript Files ##### -->
	<!-- jQuery-2.2.4 js -->
	<script src="js1/jquery-2.2.4.min.js"></script>
	<!-- Popper js -->
	<script src="plugins/bootstrap/popper.min.js"></script>
	<!-- Bootstrap js -->
	<script src="plugins/bootstrap/bootstrap.min.js"></script>
	<!-- All Plugins js -->
	<script src="js1/plugins.js"></script>
	<!-- Active js -->
	<script src="js1/active.js"></script>
	<script src="js1/jquery.validity.min.js"></script>
	<script src="js1/script.js"></script>

	<script>
		
	</script>
</body>

</html>
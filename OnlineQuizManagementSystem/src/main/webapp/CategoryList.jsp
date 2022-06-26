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
<title>Display All Category</title>

<!-- Favicon -->
<link rel="icon" href="img/core-img/favicon.ico">

<!-- Core Stylesheet -->
<link rel="stylesheet" href="style.css">
<script src="js1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.22/css/dataTables.bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/fixedheader/3.1.7/css/fixedHeader.bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/responsive/2.2.6/css/responsive.bootstrap.min.css" />




<link rel="stylesheet" href="css1/style.css">

<style type="text/css" class="init">

</style>
<style type="text/css">

</style>
<script type="text/javascript" lang="javascript"
	src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script src="js1/jquery-2.2.4.min.js"></script> 
 	<script src="js1/plugins.js"></script>
<script type="text/javascript" lang="javascript"
	src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" lang="javascript"
	src="https://cdn.datatables.net/1.10.22/js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" lang="javascript"
	src="https://cdn.datatables.net/fixedheader/3.1.7/js/dataTables.fixedHeader.min.js"></script>
<script type="text/javascript" lang="javascript"
	src="https://cdn.datatables.net/responsive/2.2.6/js/dataTables.responsive.min.js"></script>
<script type="text/javascript" lang="javascript"
	src="https://cdn.datatables.net/responsive/2.2.6/js/responsive.bootstrap.min.js"></script>

<script type="text/javascript" class="init">
	$(document).ready(function() {
		var table = $('#example').DataTable({
			responsive : true
		});

	});
	
	
</script>
<script type="text/javascript">
		
	function getid(catid){
				
		var cid=catid;
		var strLink="deleteCategoryServlet?id="+cid;
		document.getElementById("acceptid").setAttribute("href",strLink);

	}
	
</script>

</head>

<body>

<%List<Category> categoryList=(List)request.getAttribute("Displaycategory"); %>

<!-- ##### Header Area Start ##### -->
	<%@include file="Header.jsp"%>
	<!-- ##### Header Area End ##### -->
	

	<!-- Preloader -->
	<div class="preloader d-flex align-items-center justify-content-center">
		<div class="preloader-circle"></div>
		<div class="preloader-img">
			<img src="img/core-img/leaf.png" alt="">
		</div>
	</div>


	<!-- ##### Breadcrumb Area Start ##### -->
	<div class="breadcrumb-area">
		<!-- Top Breadcrumb Area -->
		<div>
			<h2 style="margin-left: 500px; margin-top: 20px">Category Details</h2>
		</div>
		
	</div>
		<div style="margin-left: 100px;">
		<a href="InsertCategory.jsp" id="#btn"><button class="btn btn-primary">Add Category</button></a>
		</div>
		
	<div style="padding: 50px;">
	
		<table id="example" class="table table-striped table-bordered nowrap" style="width: 100%; padding: 10px; margin-right: 200px;">
			<thead>
				<tr>
					<th>Category Id</th>
					<th>Category Name</th>
				<%-- 	<th>Category Status</th>  --%>
					<th>Edit Category</th>
					<th>Change Status</th>	
				</tr>
			</thead>
						<%int cnt=0; %>
					
			<tbody>
				<%
					for (Category cat1 : categoryList) {	
				%>
				<tr>
				<%cnt=cnt+1; %>
					<td><%=cnt%></td>
					<td><%=cat1.getName() %></td>
					<td><a type="button" href="EditCategoryServlet?id=<%=cat1.getCat_id() %>"><i class="fa fa-edit" aria-hidden="true" style="color:green; cursor: pointer; font-size: 25px;"></i></a></td>
					
			<h1 id="id" style="backgroundcolor: black; "></h1>
			<%if(cat1.getStatus()==1){ %>
			<td>	<a type="button" data-toggle="modal" data-target="#exampleModalCenter" onclick="getid(<%=cat1.getCat_id() %>);"><button class="btn btn-success" style="width: 100px; height: 30px; background-color:#70c745;">InActive</button></a></td>
		<%}else{ %>
					<td>	<a type="button" data-toggle="modal" data-target="#exampleModalCenter" onclick="getid(<%=cat1.getCat_id() %>);"><button class="btn btn-success" style="width: 100px; height: 30px; background-color:#ff0000;">Active</button></a></td>
		
		<%} %>
		<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle">ARE YOU SURE YOU WANT TO CHANGE STATUS ??</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">Your All SubCategory and Product Status will be Change?</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal" style="color:white; height: 30px; width: 50px; font-size: 15px;">Close</button>
							
							
						<button   type="button" class="btn btn-primary">
						<a style=" color: white; " id="acceptid">Change</a>
						</button>
					</div>
				</div>
			</div>
		</div>
		<%--<td><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">DELETE</button></td> --%>
		<%--<td><button type="button" class="fa fa-trash" data-toggle="modal" data-target="#exampleModalCenter" aria-hidden="true" ></button></td> --%>
	 <%-- 	<td class="action"><i class="fa fa-trash" data-toggle="modal" data-target="#exampleModalCenter" aria-hidden="true" style="color:red;cursor: pointer; font-size: 25px;"></i></td> --%>
									
	</tr>
		<%}%>
			</tbody>
		</table>
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
	<%--<script src="js/jquery/jquery-2.2.4.min.js"></script>--%>
	<!-- Popper js -->
	<%-- <script src="js/bootstrap/popper.min.js"></script>--%>
	<!-- Bootstrap js -->
	<%--<script src="js/bootstrap/bootstrap.min.js"></script> --%>
	<!-- All Plugins js -->
	<%-- <script src="js/plugins/plugins.js"></script>--%>
	<!-- Active js -->
	<script src="js1/active.js"></script>
</body>

</html>
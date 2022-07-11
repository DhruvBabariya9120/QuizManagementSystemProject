<%@page import="com.quizmanagementsystem.bean.ResultDetails"%>
<%@page import="com.quizmanagementsystem.service.Impl.UserServiceImpl"%>
<%@page import="com.quizmanagementsystem.service.UserService"%>
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
<title>Display All Result Details</title>

<!-- Favicon -->
<link rel="icon" href="img/core-img/favicon.ico">

<style type="text/css" class="init">

</style>
<style type="text/css">

</style>
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
<script src="js1/jquery-2.2.4.min.js"></script> 
<script type="text/javascript" lang="javascript"
	src="https://code.jquery.com/jquery-3.5.1.js"></script>
	
 	<script src="js1/plugins.js"></script>


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

<jsp:include page="/DisplayAllQuizResultServlet"/>

<%UserService userService = new UserServiceImpl();
 List<User> users = userService.selectUserDetails();
 
 List<ResultDetails> resultList =(List)request.getAttribute("resultList");
 List<Category> categoryList = (List) request.getAttribute("CategoryList");
%>

<!-- ##### Header Area Start ##### -->
	<%@include file="Header.jsp"%>
	<!-- ##### Header Area End ##### -->

	<!-- ##### Breadcrumb Area Start ##### -->
	<div class="breadcrumb-area">
		<!-- Top Breadcrumb Area -->
		<div>
			<h2 style="margin-left: 500px; margin-top: 20px">Result Details</h2>
		</div>
	</div>
		
	<div style="padding: 50px;">
	
		<table id="example" class="table table-striped table-bordered nowrap" style="width: 100%; padding: 10px; margin-right: 200px;">
			<thead>
				<tr>
					<th>Sr. no</th>
					<th>User Name</th>
				 	<th>Category Name</th> 
					<th>Right Answer</th>
					<th>Total Marks</th>
					<th>Performance</th>
				</tr>
			</thead>
						<%int cnt=0; %>
					
			<tbody>
				<%
					for (ResultDetails resultDetails : resultList) {	
				%>
				<tr>
				<%cnt=cnt+1; %>
					<td><%=cnt%></td>
					<%for(User user : users){
					    if(user.getId()==resultDetails.getUserId()){%>
					<td><%=user.getName() %></td>
					<%} }%>
					<%for(Category cat: categoryList){ 
					if(cat.getCat_id() == resultDetails.getCatId()){ %>			
					<td><%=cat.getName()%></td>
					<%}} %>
					<td><%=resultDetails.getObtainmarks() %> </td>
					<td><%=resultDetails.getTotalmarks() %></td>
					<td><%=resultDetails.getPerformance() %></td>							
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
	<script src="js1/active.js"></script>

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

</body>

</html>
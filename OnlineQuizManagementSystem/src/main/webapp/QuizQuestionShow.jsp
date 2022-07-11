<%@page import="com.quizmanagementsystem.bean.Question"%>
<%@page import="com.quizmanagementsystem.bean.Category"%>
<%@page import="java.util.List"%>
<%@page
	import="com.quizmanagementsystem.service.Impl.CategoryServiceImpl"%>
<%@page import="com.quizmanagementsystem.service.CategoryService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>View Question Paper</title>
<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link rel="shortcut icon" href="/images/favicon.png" />

<link rel="dns-prefetch" href="//cdnjs.cloudflare.com">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" href="css1/style1.css" />
<link rel="stylesheet" href="css/style.css" />
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
<title>View Quiz</title>

<!-- Favicon -->
<link rel="icon" href="img/core-img/favicon.ico">

<script src="js1/jquery.min.js"></script>
<script>
	var count = 20;
	var a;
	var interval = setInterval(function() {
		document.getElementById('count').innerHTML = count;
		count--;
		if (count === -1) {
			$(document).ready(function() {
				a = $("#lastquestion").val();
				clearInterval(interval);
				if(a == 0){
					alert(a);
					jQuery(function(){
						   jQuery('#next').click();
						});
				}else{
					jQuery(function(){
						   jQuery('#submit').click();
						});
				}
			});
		}
	}, 1000);
</script>

</head>

<body
	style="background-image: url('image/image1.jpg'); background-repeat: no-repeat; background-size: 1400px;">
	<%-- <%@include file="Header.jsp"%> --%>
	<div class="container">
		<div class="back"
			style="background-color: #A6F0F7; margin-top: 20px; width: 650px; padding: 30px; margin-left: 250px; border-radius: 70px">
			
			<%
			Question question = (Question) request.getAttribute("SelectedQuestion");
			%>
			<%
			int id = (int) request.getAttribute("CategoryId");
			int cnt = (int) request.getAttribute("counter");
			cnt = cnt + 1;
			%>
			<form class="form validity" action="PageinationServlet" method="post">
				<%
				int lastQuestion = (int) request.getAttribute("LastQuestion");
				%>
				<h1
					style="font-weight: bold; font-size: 50px; margin-top: 0px; text-align: center; margin-bottom: 30px;">

					<%
					CategoryService catService = new CategoryServiceImpl();
					List<Category> categorylist = catService.selectCategoryDetails();
					%>
					<%
					for (int i = 0; i < categorylist.size(); i++) {
						Category category = categorylist.get(i);
						if (category.getCat_id() == id) {
					%>
					<%=category.getName()%>
					Quiz Questions
					<%
					}
					}
					%>
				</h1>

				<%
				String s = (String) request.getAttribute("message");
				if (null != s) {
				%>
				<h4
					style="font-weight: bold; font-size: 20px; color: red; font-color: red; margin-left: 150px;"><%=s%></h4>
				<%
				} else {
				%>
				<div id="count" class="btn btn-primary" style="margin-left: 500px"></div>
				<div class="form-group">
					<label id="name"
						style="color: black; border: none; font-size: medium;"
						class="form-control"><%=cnt%>)  <%=question.getQuestion()%></label>
					
				</div>
				<br>
				<div class="form-check">
					<input class="form-check-input" type="radio"
						value='<%=question.getOption1()%>' name="Answer"
						id="flexRadioDefault1"> <label style="color: black;"
						class="form-check-label" for="flexRadioDefault1">&emsp;<%=question.getOption1()%></label>
				</div>
				<br>
				<div class="form-check">
					<input class="form-check-input" type="radio"
						value='<%=question.getOption2()%>' name="Answer"
						id="flexRadioDefault2"> <label style="color: black;"
						class="form-check-label" for="flexRadioDefault2">&emsp;<%=question.getOption2()%>
					</label>
				</div>
				<br>
				<div class="form-check">
					<input class="form-check-input" type="radio"
						value='<%=question.getOption3()%>' name="Answer"
						id="flexRadioDefault2"> <label style="color: black;"
						class="form-check-label" for="flexRadioDefault2">&emsp;<%=question.getOption3()%>
					</label>
				</div>
				<br>
				<div class="form-check">
					<input class="form-check-input" type="radio"
						value='<%=question.getOption4()%>' name="Answer"
						id="flexRadioDefault2"> <label style="color: black;"
						class="form-check-label" for="flexRadioDefault2">&emsp;<%=question.getOption4()%>
					</label>
				</div>
				<br> <input type="hidden" name="id"
					value='<%=question.getCat_id()%>'> <input type="hidden"
					name="qid" value='<%=question.getQuestion_id()%>'>

				<input type="hidden" id="lastquestion" value=<%=lastQuestion%>>
				<%
				if (lastQuestion == 0) {
				%>
				<br>
				<br>
				<div class="form-group row">
					<button class="btn btn-primary" type="submit" id="next"
						style="margin-left: 250px">Next</button>
				</div>
				<%
				}
				if (lastQuestion == 1) {
				%>
				<input type="hidden" value="submit" name="submitbutton"> <br>
				<br>
				<div class="form-group row">
					<button class="btn btn-primary" style="margin-left: 250px"
					id="submit"	type="submit">Submit</button>
				</div>
				<%
				}
				%>
				<%
				}
				%>
			</form>

		</div>


		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script>
			src = "https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js" >
		</script>
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
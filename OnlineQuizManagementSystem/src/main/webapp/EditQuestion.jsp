<%@page import="com.quizmanagementsystem.bean.Question"%>
<%@page import="com.quizmanagementsystem.bean.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.quizmanagementsystem.service.Impl.CategoryServiceImpl"%>
<%@page import="com.quizmanagementsystem.service.CategoryService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Edit Question Page</title>
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
<title>Edit Question</title>

<!-- Favicon -->
<link rel="icon" href="img/core-img/favicon.ico">

<script src="js1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$("#name").change(function() {
			var str = $("#name").val();
			$.get("InsertQuestionServlet", {
				question : str
			}).done(function(data) {

				if (data == 'true') {
					//alert("This email id is already exist");
					$('#errmsg').html("This Question Already Exist");
					$(document).ready(function() {
						$("#name").val('').focus();
					});
				}
			});
		});
			
	});
</script>

</head>

<body>
	<%@include file="Header.jsp"%>
	<div class="container">
		<div class="back"
			style="background-color: #FFFFFF; margin-top: 20px; width: 650px; padding: 40px; margin-left: 250px; border-radius: 70px">

			<form class="form validity" action="EditQuestionServlet"
				method="post">
				<h1
					style="font-weight: bold; font-size: 50px; margin-top: 0px; text-align: center; margin-bottom: 30px;">Edit Question</h1>
					
					
					<div class="form-group simple">
					<%Question question =(Question) request.getAttribute("QuestionDetails");
					List<Category> categorylist =(List) request.getAttribute("CategoryDetails");%>
					
					<input type="hidden" name="questionid" value=<%=question.getQuestion_id() %>>
					<select required class="form-control" name="categoryid">
		
					<% for(Category cat : categorylist){ 
					if(question.getCat_id()==cat.getCat_id()){%>
						<option value=<%=cat.getCat_id()%>><%=cat.getName()%></option>
					<%}} %>

					<% for(Category cat : categorylist){ 
					if(question.getCat_id()!=cat.getCat_id()){%>
						<option value=<%=cat.getCat_id()%>><%=cat.getName()%></option>
					<%}} %>

					</select>

				</div>
				<div class="form-group">
					<input id="name2" name="question" class="form-control" value = '<%=question.getQuestion()%>'
						placeholder="Enter Full Question" data-missing="This field is required"
						type="text" required>
					</div>
					<span id="errmsg"
					style="color: red; font-weight: bold; font-size: 12px"> </span>
				<div class =form-inline>
				<div class="form-group">
					<div class="col-12 mb-4">
					<input id="name2" name="option1" class="form-control" value = '<%=question.getOption1() %>'
						placeholder="Enter Option no-1" data-missing="This field is required"
						type="text" required>
					</div>
				</div>
				<div class="form-group">
					<div class="col-12 mb-4">
					<input id="name2" name="option2" class="form-control"  value = '<%=question.getOption2() %>'
						placeholder="Enter Option no-2" data-missing="This field is required"
						type="text" required>
						</div>
				</div>
				</div>				
				<div class =form-inline>
				<div class="form-group">
					<div class="col-12 mb-4">
					<input id="name2" name="option3" class="form-control" value = '<%=question.getOption3() %>'
						placeholder="Enter Option no-3" data-missing="This field is required"
						type="text" required>
						</div>
				</div>
				<div class="form-group">
				<div class="col-12 mb-4">
					<input id="name2" name="option4" class="form-control" value = '<%=question.getOption4() %>'
						placeholder="Enter Option no-4" data-missing="This field is required"
						type="text" required>
						</div>
				</div>
				</div>				
				<div class="form-group">

					<input id="name2" name="answer" class="form-control" value = '<%=question.getAnswer()%>'
						placeholder="Enter right answer" data-missing="This field is required"
						type="text" required>
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

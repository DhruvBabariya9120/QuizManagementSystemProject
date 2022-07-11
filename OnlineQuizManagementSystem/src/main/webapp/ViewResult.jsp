<%@page import="com.quizmanagementsystem.bean.ResultDetails"%>
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
<title>View Result</title>

<!-- Favicon -->
<link rel="icon" href="img/core-img/favicon.ico">

<script src="js1/jquery.min.js">
</script>
<script type="text/javascript">

function switchVisible() {
    if (document.getElementById('result')) {

        if (document.getElementById('result').style.display == 'none') {
            document.getElementById('result').style.display = 'block';
        }
        else {
            document.getElementById('result').style.display = 'none';
        }
    }
}



</script>

</head>

<body>
<jsp:include page="/CategoryDetailsServlet" />
	<%@include file="Header.jsp"%>
	<div class="container">
		<div class="back"
			style="background-color: #A6F0F7; margin-top: 20px; width: 650px; padding: 40px; margin-left: 250px; border-radius: 70px">
			<%
			ResultDetails resultDetails = (ResultDetails)request.getAttribute("ResultData");
			   List<Question> questionList = (List)request.getAttribute("QuestionList");
			%>
			<%int id = resultDetails.getCatId(); %>
			<form class="form validity" action="PageinationServlet"
				method="post">
				<h3
					style="font-weight: bold; font-size: 50px; margin-top: 0px; text-align: center; margin-bottom: 30px;">

					<%
					List<Category> categorylist =(List)request.getAttribute("CategoryDetails");
					
					%>
					<%
					for (int i = 0; i < categorylist.size(); i++) {
						Category category = categorylist.get(i);
						if (category.getCat_id() == id) {
					%>
					<%=category.getName()%>
					Quiz Result
					<%
					}
					}
					%>
				</h3>
		<h2>TOtal Marks = <%=resultDetails.getObtainmarks()%>/<%=resultDetails.getTotalmarks() %> </h2>	
		<h2>Performance = <%=resultDetails.getPerformance()%></h2>	
		<br><input id="Button1" class="btn btn-primary" type="button" style="margin-left: 100px" value="Show All Right Answer" onclick="switchVisible();"/>
	
	<div id="result" style="display: none; ">	
		<%int cnt = 0; %>
		<%for(Question question : questionList){ %>
			<%cnt++; %>
				<br><div class="form-group">
				<label style="color: black;" class="form-control"><%=cnt%>&emsp;<%=question.getQuestion()%></label>
				</div>
				<div class="form-check" <%if(question.getAnswer().equalsIgnoreCase(question.getOption1())){ %>
				style="background-color: #AFFF33;"<%} %>>
				 <label	class="form-check-label" style="color: black;" for="flexRadioDefault1">A)&emsp;<%=question.getOption1()%></label>
				</div>
				<div class="form-check" <%if(question.getAnswer().equalsIgnoreCase(question.getOption2())){ %>
				style="background-color: #AFFF33;"<%} %>>
				 <label
						class="form-check-label" style="color: black;" for="flexRadioDefault2">B)&emsp;<%=question.getOption2()%>
					</label>
				</div>
				<div class="form-check" <%if(question.getAnswer().equalsIgnoreCase(question.getOption3())){ %>
				style="background-color: #AFFF33;"<%} %>>
					 <label
						class="form-check-label" style="color: black;" for="flexRadioDefault2">C)&emsp;<%=question.getOption3()%>
					</label>
				</div>
				<div class="form-check"  <%if(question.getAnswer().equalsIgnoreCase(question.getOption4())){ %>
				style="background-color: #AFFF33;"<%} %>>
				 <label style="color: black;"
						class="form-check-label" for="flexRadioDefault2">D)&emsp;<%=question.getOption4()%>
					</label>
				</div>
				<br>
			<%} %>
				<br><br><div class="form-group row">
				<a class="btn btn-primary" type="submit" style="margin-left: 240px" href="Index.jsp">Back</a>
				</div>
				</form>
	</div>			
		</div>


		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script>
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
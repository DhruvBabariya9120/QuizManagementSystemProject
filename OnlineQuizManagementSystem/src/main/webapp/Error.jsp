<%@page import="com.quizmanagementsystem.bean.Category"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
       <meta http-equiv="X-UA-Compatible" content="IE=edge" />
       <meta name="viewport" content="width=device-width, initial-scale=1.0" />
       <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Question Not found</title>
</head>
<body>
<jsp:include page="/CategoryDetailsServlet"/>
<%@include file="Header.jsp"%>
<% int id=(int)request.getAttribute("CatId"); 
   String message =(String)request.getAttribute("message");%>
<div class="d-flex align-items-center justify-content-center vh-100">
            <div class="text-center">
                <h1 class="display-1 fw-bold"
					style="font-weight: bold; font-size: 50px; margin-top: 0px; text-align: center; margin-bottom: 30px;">

					<%
					List<Category> categorylist = (List)request.getAttribute("CategoryDetails");
					
					%>
					<%
					for (int i = 0; i < categorylist.size(); i++) {
						Category category = categorylist.get(i);
						if (category.getCat_id() == id) {
					%>
					<%=category.getName()%>
					Quiz
					<%
					}
					}
					%>
                </h1>
                <p class="fs-3"> <span class="text-danger">Opps!...</span> <%=message %></p>
                <p class="lead">
                    The Questions youre looking for doesnt exist.
                  </p>
                <a href="Index.jsp" class="btn btn-primary">Go Home</a>
            </div>
        </div>
</body>
</html>
<%@page import="com.quizmanagementsystem.bean.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<!-- Basic Page Needs
================================================== -->
  <meta charset="utf-8">
  <title>HeaderPage</title>

  <!-- Mobile Specific Metas
================================================== -->
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="description" content="Construction Html5 Template">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=5.0">

  <!-- Favicon
================================================== -->
  <link rel="icon" type="image/png" href="image/Logo.png">

  <!-- CSS
================================================== -->
  <!-- Bootstrap -->
  <link rel="stylesheet" href="plugins/bootstrap/bootstrap.min.css">
  <!-- FontAwesome -->
  <link rel="stylesheet" href="plugins/fontawesome/css/all.min.css">
  <!-- Animation -->
  <link rel="stylesheet" href="plugins/animate-css/animate.css">
  <!-- slick Carousel -->
  <link rel="stylesheet" href="plugins/slick/slick.css">
  <link rel="stylesheet" href="plugins/slick/slick-theme.css">
  <!-- Colorbox -->
  <link rel="stylesheet" href="plugins/colorbox/colorbox.css">
  <!-- Template styles-->
  <link rel="stylesheet" href="css/style.css">

</head>
<body>

<%HttpSession httpSession = request.getSession(false);%>
<!-- Header start -->
<header id="header" class="header-two">
  <div class="site-navigation">
    <div class="container">
        <div class="row">
          <div class="col-lg-12">
              <nav class="navbar navbar-expand-lg navbar-light p-0">
                
                <div>
                    <a href="Index.jsp">
                      <img loading="lazy" style="margin-left: 40px" src="image/logo4.png" alt="Constra">
                    </a>
                </div><!-- logo end -->

                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".navbar-collapse" aria-controls="navbar-collapse" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                
                
                <div id="navbar-collapse" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav ml-auto align-items-center">
 					
                      <li class="nav-item dropdown active">
                          <a href="Index.jsp" class="nav-link">Home</a>
                      </li>
                      <li class="nav-item dropdown">
                          <a href="SignUp.jsp" class="nav-link">Sign Up</a>
                         
                      </li>
              
                      <li class="nav-item dropdown">
                          <a href="InsertCategory.jsp" class="nav-link">Insert Category<i class="fa fa-angle-down"></i></a>
                          <ul class="dropdown-menu" role="menu">
                            <li><a href="DisplaycategoryServlet">CategoryList</a></li>
                          </ul>
                      </li>
              
                      <li class="nav-item dropdown">
                          <a href="InsertQuestion.jsp" class="nav-link">Insert Questions <i class="fa fa-angle-down"></i></a>
                          <ul class="dropdown-menu" role="menu">
                            <li><a href="QuestionList.jsp">Question List</a></li>
                          </ul>
                      </li>
              
                      <li class="nav-item"><a class="nav-link" href="contact.html">Contact</a></li>
					<%if(null==httpSession.getAttribute("Logindetails")){ %>
                      <li class="header-get-a-quote">
                          <a class="btn btn-primary" href="Login.jsp">Log in</a>
                      </li>
                      <%}else{ %>
                      <li class="header-get-a-quote">
                          <a class="btn btn-primary" href="LoginDetailsServlet">Log out</a>
                      </li>
                      <%} %>
                    </ul>
                </div>
              </nav>
          </div>
          <!--/ Col end -->
        </div>
        <!--/ Row end -->
    </div>
    <!--/ Container end -->

  </div>
  <!--/ Navigation end -->
</header>
<!--/ Header end -->

 <!-- Javascript Files
  ================================================== -->

  <!-- initialize jQuery Library -->
  <script src="plugins/jQuery/jquery.min.js"></script>
  <!-- Bootstrap jQuery -->
  <script src="plugins/bootstrap/bootstrap.min.js" defer></script>
  <!-- Slick Carousel -->
  <script src="plugins/slick/slick.min.js"></script>
  <script src="plugins/slick/slick-animation.min.js"></script>
  <!-- Color box -->
  <script src="plugins/colorbox/jquery.colorbox.js"></script>
  <!-- shuffle -->
  <script src="plugins/shuffle/shuffle.min.js" defer></script>


  <!-- Google Map API Key-->
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCcABaamniA6OL5YvYSpB3pFMNrXwXnLwU" defer></script>
  <!-- Google Map Plugin-->
  <script src="plugins/google-map/map.js" defer></script>

  <!-- Template custom -->
  <script src="js/script.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>nav</title>
<style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
 </style>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">Portfolio</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="/nboard/board/main">Home</a></li>
        <li><a href="/nboard/board/articles/1/10">Articles</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="/nboard/user/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        <li><a onclick="document.getElementById('frm').submit();" href="#"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
        <li><a href="/nboard/user/main"><span class="glyphicon glyphicon-plus-sign"></span> Join</a></li>
      </ul>
    </div>
  </div>
  
  <form id="frm" action="/nboard/logout" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
  </form>
</nav>
</body>
</html>
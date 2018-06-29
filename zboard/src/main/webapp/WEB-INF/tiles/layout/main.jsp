<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<script src="/zboard/script/main.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ICIA Sensor Board</title>
<!-- 전체적인 기본 스타일 지정 -->
<link rel="stylesheet" href="/zboard/css/main.css">
<!--  모든 페이지를 위한 jQuery 가져오기 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<div id="wrap">
	<header>
		<tiles:insertAttribute name="header"/>    
	</header>
	<nav>
		<tiles:insertAttribute name="nav"/>    
	</nav>
	<div id="main">
		<aside>
			<tiles:insertAttribute name="aside"/>    
		</aside>
		<section>
			<tiles:insertAttribute name="section"/>    		
		</section>
	</div>
	<footer>
		<tiles:insertAttribute name="footer"/>    
	</footer>
</div>
</body>
</html>
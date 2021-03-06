<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>hb
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/template/nav.jsp"/>
	<p>${username}님 안녕하세요!</p>
	<p>CREATE</p>
	<form action="/nboard/board/create" method="POST">
		내용 : <input type="text" name="content">
		제목 : <input type="text" name="title">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<input type="submit">
	</form>


	<table class="highlight" style="width:70%; text-align:center; margin:0 auto;">
		<colgroup>
			<col width="10%">
			<col width="45%">
			<col width="10%">
			<col width="15%">
			<col width="10%">
			<col width="10%">
		</colgroup>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
			<th>좋아요</th>
		</tr>
		<c:forEach items="${list }" var="board">
			<tr>
				<td>${board.bno }</td>
				<td><a href="/nboard/board/read?bno=${board.bno }">${board.title }</a></td>
				<td>${board.writer }</td>
				<td><fmt:formatDate value="${board.writeDate }" pattern="yyyy.MM.dd"/></td>
				<td>${board.readCnt }</td>
				<td>${board.likeCnt }</td>
			</tr>
		</c:forEach>
	</table>
	
	<div class="container">
    <ul class="pagination">
        <li class="disabled"><a href="#!"><i class="mdi-navigation-chevron-left"> &lt </i></a></li>
        <li class="active"><a href="#!">1</a></li>
        <li class="waves-effect"><a href="#!">2</a></li>
        <li class="waves-effect"><a href="#!">3</a></li>
        <li class="waves-effect"><a href="#!">4</a></li>
        <li class="waves-effect"><a href="#!">5</a></li>
        <li class="waves-effect"><a href="#!"><i class="mdi-navigation-chevron-right"> &gt </i></a></li>
    </ul>          
</div>
</body>
</html>
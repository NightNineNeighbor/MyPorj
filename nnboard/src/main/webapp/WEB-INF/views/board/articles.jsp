<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
	$(function(){
		var countOfBoard = "${articleAmount}";
		var pageNo = location.pathname.split("/")[5] / 10;
		var endPageNo = Math.floor( (countOfBoard - 1)/10 +1 );
		var startPageNo = pageNo-(pageNo-1)%5;
		console.log(endPageNo)
		console.log(startPageNo)
			
		var text;
		if(startPageNo>5){
			text= "<li class='waves-effect'><a href='/nboard/board/articles/"+ ((startPageNo-1)*10-9) +"/"+ (startPageNo-1)*10 +"'>&lt</a></li>";
			$("#target").append(text);
		}
			
		for(var i = startPageNo; i < startPageNo + 5 && i <= endPageNo; i++){
			text= '<li class="waves-effect"><a href="/nboard/board/articles/'+ (i*10-9) +'/'+ (i*10) +'">'+ i + '</a></li>';
			if(i == pageNo){
				text= '<li class="active"><a href="/nboard/board/articles/'+ (i*10-9) +'/'+ (i*10) +'">'+ i + '</a></li>';
			}
			$("#target").append(text);
		}
			
		if(endPageNo >= startPageNo+5){
			text= "<li class='waves-effect'><a href='/nboard/board/articles/"+ ((startPageNo+5)*10-9) +"/"+ (startPageNo+5)*10 +"'>&gt</a></li>";
			$("#target").append(text);
		}
	})
</script>

</head>
<jsp:include page="/WEB-INF/views/template/nav.jsp"/>
<body>
	<form action="/nboard/logout" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<input type="submit" value="form Logout">
	</form>
	<a href="/nboard/user/login">login</a>
	<a href="/nboard/user/main">join</a>
	<p>${username}님 안녕하세요!</p>
	<%-- <c:import url="../template/header.jsp"></c:import> --%>

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
	
	<div id="pagination">
		<ul id="target" class="pagination">
    	</ul>  
	</div>
	
</body>
</html>
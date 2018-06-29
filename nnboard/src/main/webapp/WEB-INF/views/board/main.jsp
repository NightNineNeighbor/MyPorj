<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <c:import url="../template/header.jsp"></c:import> --%>
	<p>CREATE</p>
	<form action="/nboard/board/create" method="POST">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		내용 : <input type="text" name="content"> 
		제목 : <input type="text" name="title">
		<input type="submit">
	</form>

	
	<table>
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
				<td>${board.writeDate }</td>
				<td>${board.readCnt }</td>
				<td>${board.likeCnt }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
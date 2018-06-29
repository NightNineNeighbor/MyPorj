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
	<p>CREATE</p>
	<form action="/nboard/user/create" method="POST">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		아이디 : <input type="text" name="id"/>
		비번 : <input type="text" name="password"/>
		이름 : <input type="text" name="name"/>
		<input type="submit">
	</form>

	<p>UPDATE</p>
	<form action="/nboard/user/update" method="POST">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		아이디 : <input type="text" name="id"> 
		이름 : <input type="text"name="name"> 
		<input type="submit">
	</form>
	<p>DELETE</p>
	<form action="/nboard/user/delete" method="POST">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<input type="text" name="id">
		<input type="submit">
	</form>
	<table>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>비밀번호</th>
		</tr>
		<c:forEach items="${userList }" var="user">
			<tr>
				<td>${user.id }</td>
				<td>${user.name }</td>
				<td>${user.password }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
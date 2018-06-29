<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="writeForm" action="/zboard/user/update" method="post" class="col s12">
	<table class="striped">
		<tr>
			<td>이름</td>
			<td>${user.id }</td>
		</tr>
		<tr>
			<td>아이디</td>
			<td>${user.irum }</td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td><fmt:formatDate value="${user.birthDate}" type="date"/></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>${user.email }</td>
		</tr>
	</table>
</form>
</body>
</html>
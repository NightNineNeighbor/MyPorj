<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/zboard/script/jquery-dateFormat.min.js"></script>
<script>
	$(function() {
		var $birthDate = "${user.birthDate}";
		var $date = $.format.date($birthDate, "yyyy-MM-dd");
		$("#birthDate").val($date)
	});
</script>
</head>
<body>
<body>
	<form action="/zboard/user/update" method="post">
	<table class="highlight">
		<tr><td>아이디  : ${user.id} </td><td rowspan="4"><img src="/upload/${user.savedFileName}" width="300px"></td></tr>
		<tr><td>이름  : ${user.irum }</td></tr>
		<tr><td>이메일  : <input type="text" name="email" id="email" value="${user.email}"></td></tr>
		<tr><td>생일  : <input type="date" name="birthDate" id="birthDate"></td></tr>
	</table>
<c:if test="${update ne null}">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	<button class="btn waves-effect waves-light" type="button" id="update">변경하기
    	<i class="material-icons right">send</i>
  	</button>
</c:if>
	<button class="btn waves-effect waves-light" type="button" id="list">홈으로
    	<i class="material-icons right">send</i>
  	</button>
  	</form>
</body>
</body>
</html>
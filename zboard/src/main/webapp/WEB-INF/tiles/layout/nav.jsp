<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	$(function() {
		$("#logout").on("click", function(e) {
			e.preventDefault();
			var $form = $("<form></form>");
			$form.attr("action","/zboard/user/logout");
			$form.attr("method","post");
			$("<input>").attr("type","hidden").attr("name", "${_csrf.parameterName}").val("${_csrf.token}").appendTo($form);
			$form.appendTo("body");
			$form.submit();
		});
		$("#resign").on("click", function(e) {
			e.preventDefault();
			var $form = $("<form></form>");
			$form.attr("action","/zboard/user/resign");
			$form.attr("method","post");
			$("<input>").attr("type","hidden").attr("name", "${_csrf.parameterName}").val("${_csrf.token}").appendTo($form);
			$form.appendTo("body");
			$form.submit();
		});
	});
</script>
</head>
<body>
<div id="nav" class="nav-wrapper">
	<a href="#" class="brand-logo">ICIA</a>
	<sec:authorize access="isAnonymous()">
		<ul id="left" class="right hide-on-med-and-down">
			<li><a href="/zboard/user/login">로그인</a></li>
			<li><a href="/zboard/user/join">회원가입</a></li>
			<li><a href="/zboard/board/list">게시판</a></li>
		</ul>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_USER')">
		<ul id="left" class="right hide-on-med-and-down">
			<li><a href="/zboard/user/logout" id="logout">로그아웃</a></li>
			<li><a href="/zboard/user/read">내정보 보기</a></li>
			<li><a href="/zboard/board/list">게시판</a></li>
		</ul>
	</sec:authorize>
		<sec:authorize access="isAnonymous()">
		<ul id="left" class="right hide-on-med-and-down">
			<li><a href="/zboard/user/findId">아이디 찾기</a></li>
			<li><a href="/zboard/user/findPwd">비번 찾기</a></li>
		</ul>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_USER')">
		<ul id="left" class="right hide-on-med-and-down">
			<li><a href="/zboard/user/resign" id="resign">탈퇴</a></li>
		</ul>
	</sec:authorize>		
</div>
</body>
</html>
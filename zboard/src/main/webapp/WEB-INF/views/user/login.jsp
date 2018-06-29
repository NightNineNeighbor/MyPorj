<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
$(function() {
	var fail = location.search.substr(6, 9);
	if(fail=="true") {
		$("#helper-id").text("등록되지 않은 아이디이거나, 아이디 또는 비밀번호를 잘못 입력하셨습니다.").css("color","#ee6e73");
		$("#pwd").focus();
	}
})
</script>
</head>
<body>
	<form action="/zboard/user/login" method="post" class="col s12">
		<div class="row">
			<div class="input-field col s12">
				<i class="material-icons prefix">account_circle</i>
				<input id="id" type="text" name="loginid">
				<label for="id">아이디</label>
				<span class="helper-text" id="helper-id"></span>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<i class="material-icons prefix">create</i>
				<input id="pwd" type="password" name="loginpwd">
				<label for="pwd">비밀번호</label>
				<span class="helper-text" id="helper-pwd"></span>
			</div>
		</div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<button class="btn waves-effect waves-light" type="submit" id="action">로그인
    		<i class="material-icons right">send</i>
  		</button>
	</form>
</body>
</html>
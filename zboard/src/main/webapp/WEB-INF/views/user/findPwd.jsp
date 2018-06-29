<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/zboard/user/findPwd" method="post" class="col s12">
		<div class="row">
			<div class="input-field col s12">
				<i class="material-icons prefix">account_circle</i>
				<input id="id" type="text" name="id">
				<label for="id">아이디</label>
				<span class="helper-text" id="helper-id"></span>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<i class="material-icons prefix">create</i>
				<input id="email" type="text" name="email">
				<label for="email">이메일</label>
				<span class="helper-text" id="helper-pwd"></span>
			</div>
		</div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<button class="btn waves-effect waves-light" type="submit" id="action">임시비밀번호 발급
    		<i class="material-icons right">send</i>
  		</button>
	</form>
</body>
</html>
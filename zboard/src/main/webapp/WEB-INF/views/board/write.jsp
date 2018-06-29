<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#content {
		width: 95%;
		min-height: 400px;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function() {
	$("#write").on("click", function() {
		if($("#title").val().length==0) {
			$("#helper-title").text("비밀번호는 필수입력입니다").css("color","#ee6e73");
			$("#title").focus();
		}  else
			$("#writeForm").submit();
	});
});
</script>
</head>
<body>
	<form action="/zboard/board/write" method="post" id="writeForm" class="col s12">
		<div class="row">
			<div class="input-field col s9">
				<i class="material-icons prefix">account_circle</i>
				<input type="text" name="title" id="title">
				<label for="title">제목</label>
				<span class="helper-text" id="helper-title"></span>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<textarea id="content" class="materialize-textarea" name="content"></textarea>
				<label for="content">내용을 입력하세요</label>
			</div>
		</div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<button class="btn waves-effect waves-light" type="button" id="write">작성하기
    		<i class="material-icons right">send</i>
  		</button>
	</form>
</body>
</html>
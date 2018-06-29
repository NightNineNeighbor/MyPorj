<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/zboard/script/join.js"></script>
<script>
// csrf 토큰 때문에 함수를 분리못하고 join.jsp에 작성
$(function() {
	$("#idCheck").on("click", function() {
		var id_reg = /^[a-zA-Z0-9]{8,10}$/;
		if($("#id").val().length==0) {
			$("#helper-id").text("아이디를 입력하세요").css("color","#ee6e73");
			return;
		}
		else if(id_reg.test($("#irum").val())) {
			$("#helper-id").text("아이디는 영숫자 8~10자입니다").css("color","#ee6e73");
			return;
		}
		$.ajax({
			url: "/zboard/user/idCheck",
			type: "post",
			data: "id=" + $("#id").val() + "&${_csrf.parameterName}=" + "${_csrf.token}",
			success: function(result) {
				if(result=="true") {
					$("#helper-id").text("멋진 아이디네요").css("color","#05c8b4");
					$("#id").prop("readonly", true);
					$("#join").prop("disabled", false);
					$("#id").data("check","true");
				} else if(result=="false") {
					$("#helper-id").text("이미 사용중인 아이디입니다").css("color","red");
				}
			}
		});
	})
});
</script>
</head>
<body>
	<form id="joinForm" action="/zboard/user/join" method="post" enctype="multipart/form-data" class="col s12">
		<div class="row">
			<div class="input-field col s9">
				<i class="material-icons prefix">account_circle</i>
				<input id="id" type="text" name="id" data-check="false">
				<label for="id">아이디</label>
				<span class="helper-text" id="helper-id"></span>
			</div>
			<button class="btn waves-effect waves-light red" type="button" id="idCheck">
				<i class ="material-icons left">search</i>아이디 확인
			</button>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<i class="material-icons prefix">face</i>
				<input id="irum" type="text" name="irum">
				<label for="irum">이름</label>
				<span class="helper-text" id="helper-irum"></span>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<i class="material-icons prefix">create</i>
				<input id="pwd" type="password" name="pwd">
				<label for="pwd">비밀번호</label>
				<span class="helper-text" id="helper-pwd"></span>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<i class="material-icons prefix">create</i>
				<input id="pwd2" type="password">
				<label for="pwd2">비밀번호 확인</label>
				<span class="helper-text" id="helper-pwd2"></span>
			</div>
		</div>
		<div class="row">
			<label>프로필 사진 업로드</label>
			<div class="file-field input-field">
				<div class = "btn">
					<span>파일 찾기</span>
					<input type="file" name="sajin">
				</div>
				<div class="file-path-wrapper">
					<input class="file-path validate" type="text" placeholder="선택 파일 " />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<i class="material-icons prefix">email</i>
				<input id="email" type="text" name="email">
				<label for="email">이메일</label>
				<span class="helper-text" id="helper-email"></span>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<i class="material-icons prefix">child_friendly</i>
				<input id="birthDate" type="date" name="birthDate">
				<label for="birthDate">생년월일</label>
				<span class="helper-text" id="helper-birthDate"></span>
			</div>
		</div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
  		<button class="btn waves-effect waves-light" type="button" id="join" disabled="disabled">JOIN
    		<i class="material-icons right">send</i>
  		</button>
	</form>
</body>
</html>
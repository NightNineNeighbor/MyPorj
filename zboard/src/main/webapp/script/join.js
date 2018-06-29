$(document).ready(function() {
	function isIdCheck() {
		return $("#id").data("check");
	}
	function clear(inputNo) {
		var $except = $(".helper-text:first-of-type");
		$(".helper-text").not($except).text("");
	}
	$("#join").on("click", function() {
		if(isIdCheck()==false) {
			alert("아이디 사용가능여부를 확인해 주세요");
			return;
		}
		clear();
		var irum_reg = /^[가-힣]{2,5}$/;
		var pwd_reg = /^[a-zA-Z0-9!@#$]{8,10}$/;
		var email_reg = /^[0-9a-zA-Z]+@[0-9a-zA-Z]+\.[0-9a-zA-Z]+$/;
		console.log(irum_reg.test($("#irum").val()));
		console.log(pwd_reg.test($("#pwd").val()));
		console.log($("#irum").val().length)
		console.log($("#irum").val());
		if($("#irum").val().length==0)
			$("#helper-irum").text("이름은 필수입력입니다").css("color","#ee6e73");
		else if(irum_reg.test($("#irum").val())==false)
			$("#helper-irum").text("이름은 2~5자입니다").css("color","#ee6e73");
		else
			$("#helper-irum").text("정확합니다").css("color","#05c8b4");
		
		if($("#pwd").val().length==0)
			$("#helper-pwd").text("비밀번호는 필수입력입니다").css("color","#ee6e73");
		else if(pwd_reg.test($("#pwd").val())==false)
			$("#helper-pwd").text("비밀번호는 영숫자와 특수문자 !,@,#,$를 포함하며 8~10자입니다").css("color","#ee6e73");
		else
			$("#helper-pwd").text("정확합니다").css("color","#05c8b4");
		
		if($("#pwd2").val().length==0)
			$("#helper-pwd2").text("비밀번호를 확인해 주세요").css("color","#ee6e73");
		else if($("#pwd").val()!=$("#pwd2").val())
			$("#helper-pwd2").text("비밀번호가 불일치합니다").css("color","#ee6e73");
		else
			$("#helper-pwd2").text("정확합니다").css("color","#05c8b4");
		
		if($("#email").val().length==0)
			$("#helper-email").text("이메일은 필수입력입니다").css("color","#ee6e73");
		else if(email_reg.test($("#email").val())==false)
			$("#helper-email").text("올바른 이메일 주소를 입력해주세요").css("color","#ee6e73");
		else
			$("#helper-email").text("정확합니다").css("color","#05c8b4");
		
		
		if($("#birthDate").val().length==0)
			$("#helper-birthDate").text("생년월일은 필수입력입니다").css("color","#ee6e73");
		else
			$("#helper-birthDate").text("정확합니다").css("color","#05c8b4");
		
		$("#joinForm").submit();
	});
});
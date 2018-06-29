<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
$(function() {
	var msg = "${msg}";
	if(msg!="")
		alert(msg);
	location.href="/zboard/board/list";
})
</script>
</head>
<body>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<title>Insert title here!</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
    $("#ss").click(function(){
       $("#target").text("hihihihi");
       
       var token = $("meta[name='_csrf']").attr("content");
       var header = $("meta[name='_csrf_header']").attr("content");
       $.ajax({
			url: "/nboard/board/ajaxlikeup",
			type: "post",
			beforeSend: function (xhr) {
				xhr.setRequestHeader(header, token);
		    },
			data: /* "${_csrf.parameterName}=" + "${_csrf.token}" + "& */"bno=" + "${board.bno }",
			success: function(result) {
				if(result=="notLiked")
					$("#likeCnt").text( Number($("#likeCnt").text()) + 1 );
					
			}
		});
    });
});
</script>
</head>
<body>

<a href="/nboard/board/main">main</a>
<button id="ss">ResponseEntity</button>
<p id="target"></p>




<form action="/nboard/board/likeup" method="post">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	<input type="hidden" name="bno" value="${board.bno }">
	<input type="submit" value="likeUp">
</form>

<p>writer : ${board.writer}</p>
<p>user : ${username }</p>
<c:if test="${board.writer eq username}">

<p>UPDATE</p>
	<form action="/nboard/board/update" method="POST">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<input type="hidden" name="bno" value="${board.bno }"> 
		내용 : <input type="text" name="content">
		제목 : <input type="text" name="title">
		<input type="submit">
	</form>
	
	<p>DELETE</p>
	<form action="/nboard/board/delete" method="POST">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<input type="hidden" name="bno" value="${board.bno }"> 
		<input type="submit">
	</form>
</c:if>


	<table>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
			<th>좋아요</th>
		</tr>
		<tr>
			<td id="bno">${board.bno }</td>
			<td>${board.title }</td>
			<td>${board.writer }</td>
			<td>${board.writeDate }</td>
			<td>${board.readCnt }</td>
			<td id="likeCnt">${board.likeCnt }</td>
		</tr>
	</table>
	<p>내용</p>
	<p>${board.content }<p>
</body>
</html>
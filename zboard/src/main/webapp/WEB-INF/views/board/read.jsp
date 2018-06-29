<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	$(function(){
		var $state = "${state}";
		if($state=="update") {
			$("#title").prop("readonly", false);
			$("#content").prop("readonly", false);
		}
		$("#update").on("click", function() {
			var $updateForm = $("#updateForm");
			$updateForm.attr("action","/zboard/board/update");
			$updateForm.submit();
		});
		$("#delete").on("click", function() {
			var $updateForm = $("#updateForm");
			$updateForm.attr("action","/zboard/board/delete");
			$updateForm.submit();
		});
		$("#list").on("click", function() {
			location.href = "/zboard/board/list";
		});
	})
</script>
</head>
<body>
	<form id="updateForm" method="post" class="col s12">
		<table class="striped">
			<tr><td>글번호</td><td>${board.bno }</td></tr>
			<tr><td>작성자</td><td>${board.id }</td></tr>
			<tr><td>제목</td><td><input type="text" id="title" name="title" value="${board.title }" readonly="readonly"></td></tr>
			<tr><td>본문</td><td>
				<textarea id="content" name="content" readonly="readonly" class="materialize-textarea">${board.content }</textarea>
			</td></tr>
			<tr><td>작성일</td><td><fmt:formatDate value="${board.writeDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td></tr>
			<tr><td>조회수</td><td>${board.readCnt }</td></tr>
		</table>
	<!-- 서버에서 update 값을 보내왔을 경우 변경, 삭제 버튼 추가 -->
	<c:if test="${state ne null}">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<input type="hidden" name="id" value="${board.id}">
		<input type="hidden" name="bno" value="${board.bno}">
		<button class="btn waves-effect waves-light" type="button" id="update">변경하기
    		<i class="material-icons right">send</i>
  		</button>
  		<button class="btn waves-effect waves-light" type="button" id="delete">삭제하기
    		<i class="material-icons right">send</i>
  		</button>
	</c:if>	
	</form>
	
	
	<button class="btn waves-effect waves-light" type="button" id="list">홈으로
    	<i class="material-icons right">send</i>
  	</button>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
$(function() {
	$("#write").on("click", function() {
		location.href= "/zboard/board/write"
	});
})
</script>
<style>
	.pagination {
		text-align: center;
		margin-top: 20px;
		margin-bottom: 20px;
	}
</style>
</head>
<body>
	<table class="highlight">
		<colgroup>
			<col width="10%">
			<col width="55%">
			<col width="10%">
			<col width="15%">
			<col width="10%">
		</colgroup>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${map.list}" var="board">
			<tr>
				<td>${board.bno}</td>
				<td><a href="/zboard/board/read?bno=${board.bno}">${board.title}</a></td>
				<td>${board.id}</td>
				<td><fmt:formatDate value="${board.writeDate}" pattern="yyyy-MM-dd" /></td>
				<td>${board.readCnt}</td>
			</tr>
		</c:forEach>
	</table>
	<div class="pagination">
		<ul>
			<c:choose>
				<c:when test="${map.pagination.prev!=0}">
					<li class="disabled"><a href="#"><i class="material-icons">chevron_left</i></a></li>
				</c:when>
				<c:otherwise>
					 <li class="waves-effect"><a href="/zboard/board/list?pageNo=${map.pagination.prev}"><i class="material-icons">chevron_left</i></a></li>
				</c:otherwise>
			</c:choose>
			<c:forEach begin="${map.pagination.startPageNo}" end="${map.pagination.endPageNo}" var="i">
				<c:choose>
					<c:when test="${map.pagination.pageNo eq i }">
						<li class="active"><a href="/zboard/board/list?pageNo=${i}">${i}</a></li>
					</c:when>
					<c:otherwise>
						<li class="waves-effect"><a href="/zboard/board/list?pageNo=${i}">${i}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:choose>
				<c:when test="${map.pagination.next!=0}">
					<li class="disabled"><a href="#"><i class="material-icons">chevron_right</i></a></li>
				</c:when>
				<c:otherwise>
					 <li class="waves-effect"><a href="/zboard/board/list?pageNo=${map.pagination.next}"><i class="material-icons">chevron_right</i></a></li>
				</c:otherwise>
			</c:choose>
		</ul>
		</div>
		<button class="btn waves-effect waves-light" type="button" id="write">글쓰기
    		<i class="material-icons right">send</i>
  		</button>
</html>
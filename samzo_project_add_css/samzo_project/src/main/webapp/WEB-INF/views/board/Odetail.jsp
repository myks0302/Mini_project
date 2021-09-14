<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="incss.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
td{
	padding-left: 10px;
}
</style>
</head>
<body>
	<h1>게시판 상세 정보</h1>
	<table border="1" width="70%">
		<tr>
			<th>글 번호</th>
			<td>${board.bbs_number }</td>
		</tr>
		<tr>
			<th>말머리</th>
			<td>${board.hh_head }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${board.bbs_title }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${board.bbs_content }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${board.m_nickname }</td>
		</tr>
		<tr>
			<th>날짜</th>
			<td>${board.bbs_date }</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${board.bbs_views }</td>
		</tr>
	</table>
	<a href="modify.do?bbs_number=${board.bbs_number}">수정하기</a>
	<a href="insert.do">생성하기</a>
	<a href="list.do">게시판 목록</a>
	<form action="delete.do?bbs_number=${board.bbs_number }" method="post">
		<%--    <input type="hidden" name="${board.bbs_number }" /> --%>
		<input type="submit" value="삭제" />
	</form>
</body>
</html>
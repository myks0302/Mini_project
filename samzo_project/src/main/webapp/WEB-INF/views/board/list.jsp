<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="incss.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시판 목록</h1>
	<table border="1" width="70%">
		<tr>
			<th>번호</th>
			<th>항목</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="board" items="${boardList }">
			<tr>
				<td>${board.bbs_number }</td>
				<td>${board.bbs_category }</td>
				<td><a href="detail.do?bbs_number=${board.bbs_number}">(${board.hh_head })${board.bbs_title }</a></td>
				<td>${board.m_nickname }</td>
				<td>${board.bbs_date }</td>
				<td>${board.bbs_views }</td>
			</tr>
		</c:forEach>
	</table>
	<a href="insert.do">게시판 생성</a>

</body>
</html>
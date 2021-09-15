<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="incss.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" width="70%">
		<h1>게시판 목록</h1>
		<tr>
			<th>번호</th>
			<th>항목</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="categorylist" items="${categorylist }">
			<tr>
				<td>${categorylist.bbs_number }</td>
				<td>${categorylist.bbs_category }</td>
				<td><a href="detail.do?bbs_number=${categorylist.bbs_number}">(${categorylist.hh_head })${categorylist.bbs_title }</a></td>
				<td>${categorylist.m_nickname }</td>
				<td>${categorylist.bbs_date }</td>
				<td>${categorylist.bbs_views }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
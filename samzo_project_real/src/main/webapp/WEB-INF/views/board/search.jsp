<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="incss.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href=${pageContext.request.contextPath}/resources/css/search_style.css>


</head>
<body>

	<div class="search">
	<검색 했을때>
	<form action ="search.do" method = "post">
		<table border="1" width = "70%">
			<select name = "searchCondition">
				<option value = "title">제목
				<option value = "content">내용
			</select>
			<input name = "searchKeyword" type = "text"/>
			<input type = "submit" value = "검색"/>
		</table>
	</div>
	
	<div class="section_board">
	<table width="70%">
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
		<button onclick="location.href = '../login.do'">메인 페이지</button>
		<button onclick="location.href = 'insert.do'">글쓰기</button>
	
	</div>

	<div class="page">
		<ul>
			<c:if test="${pageMaker.prev}">
				<li><a
					href="search.do${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a></li>
			</c:if>

			<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}"
				var="idx">
				<li><a href="search.do${pageMaker.makeQuery(idx)}">${idx}</a></li>
			</c:forEach>

			<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				<li><a href="search.do${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음</a></li>
			</c:if>
		</ul>
	</div>

</body>
</html>
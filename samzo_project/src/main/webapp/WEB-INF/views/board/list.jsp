<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="../resources/css/board_style.css?v=3">

</head>
<body>
<div class="section_welcome"> <img src="../resources/photo/header1.png" alt="header1" height="250px" width="100%" ></div>
<h1>게시판 목록</h1>

<%if(session.getAttribute("member") != null) {%>
<div class="section_content">
		
	<div class="asd">
		<p><strong>전체글보기</strong></p> 
			<table class="section_board">
		
			<c:forEach var="board" items="${boardList }">
				<tr>
					<td>${board.bbs_number }</td>
					<td><a href="category.go?bbs_category=${board.bbs_category}">${board.bbs_category }</a></td>
					<td><a href="detail.do?bbs_number=${board.bbs_number}">(${board.hh_head })${board.bbs_title }</a></td>
					<td>${board.m_nickname }</td>
					<td>${board.bbs_date }</td>
					<td>${board.bbs_views }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
		<div class="search_part">
			<form action ="search.do" method = "post"   class="box">
				<table>
					<select name = "searchCondition" class="searchbar_option">
						<option value = "title">제목
						<option value = "content">내용
					</select>
					<input name = "searchKeyword" type = "text" class="searchbar_input"/>
					<input type = "submit" value = "검색" class="searchbar_button"/>
				</table>
			</form>
		</div>

</div>

<div class="board_min">
	
	
	<button onclick="location.href = 'insert.do'">글쓰기</button>
	<button onclick="location.href = '../login.do'">메인 페이지</button>
	
	<!-- 
		<a href="insert.do">게시판 생성</a>
		<a href = "../login.do">메인페이지</a>
	 -->
	
		
</div>
	
<%}else{%>
<div class="section_content">
		
	<div class="asd">
			<p><strong>전체글보기</strong></p> 
				<table class="section_board">
				
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
	</div>
		<div class="search_part">
			<form action ="search.do" method = "post">
				<table  >
					<select name = "searchCondition">
						<option value = "title">제목
						<option value = "content">내용
					</select>
					<input name = "searchKeyword" type = "text"/>
					<input type = "submit" value = "검색"/>
				</table>
			</form>
		</div>
		
		<div class="board_min">
			<button onclick="location.href = '../login.do'">메인 페이지</button>
		</div>
	<!-- 
		<a href = <%=request.getContextPath()%>>메인페이지</a>
	 -->
	
	
	
	
<%}%>

<div class="page">
		<ul>
			<c:if test="${pageMaker.prev}">
				<li><a
					href="list.do${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a></li>
			</c:if>

			<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}"
				var="idx">
				<li><a href="list.do${pageMaker.makeQuery(idx)}">${idx}</a></li>
			</c:forEach>

			<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				<li><a href="list.do${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음</a></li>
			</c:if>
		</ul>
	</div>


</body>
</html>
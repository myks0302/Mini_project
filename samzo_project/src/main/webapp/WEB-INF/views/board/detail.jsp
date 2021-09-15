<%@page import="org.samzo.cafe.board.ReplyDTO"%>
<%@page import="org.samzo.cafe.board.BoardDTO"%>
<%@page import="org.samzo.cafe.member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="incss.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href=${pageContext.request.contextPath}/resources/css/detail_style.css>

</head>
<body>
 	<div>
		<header onclick="location.href='list.do'">
			<img src="../resources/photo/header1.png" alt="header1" height="100%" width="100%" >
		</header>
		
		<div class="container">
		
	
			<h1>게시판 상세 정보</h1>
			<%
			MemberDTO member = (MemberDTO)session.getAttribute("member");
			BoardDTO board = (BoardDTO)request.getAttribute("board");
		
			if(member.getM_nickname().equals(board.getm_nickname())){
			%>
			
			<button onclick="location.href = 'list.do'">게시판 목록</a></button>
			
			<button onclick="location.href = 'modify.do?bbs_number=${board.bbs_number}'">수정하기</button>
			
			<form action="delete.do?bbs_number=${board.bbs_number }" method="post">
				<%--    <input type="hidden" name="${board.bbs_number }" /> --%>
				<input type="submit" value="삭제" />
			</form>
			
			<!--  
			<a href="modify.do?bbs_number=${board.bbs_number}">수정하기</a>
			<a href="insert.do">생성하기</a>
			<a href="list.do">게시판 목록</a>
			<form action="delete.do?bbs_number=${board.bbs_number }" method="post">
				<%--    <input type="hidden" name="${board.bbs_number }" /> --%>
				<input type="submit" value="삭제" />
			</form> 
			-->
			
			<table width="70%">
				<tr>
					<th>글 번호</th>
					<td>${board.bbs_number }</td>
					<th>작성자</th>
					<td>${board.m_nickname }</td>
					<th>날짜</th>
					<td>${board.bbs_date }</td>
				</tr>
				<tr>
					<th>제목</th>
					<td colspan="5">(${board.hh_head })${board.bbs_title }</td>
				</tr>
				
				<tr>
					<th>내용</th>
					<td colspan="5" height="100px">${board.bbs_content }</td>
				</tr>
				<tr>
					<th>조회수</th>
					<td colspan="5">${board.bbs_views }</td>
				</tr>
			</table>
		
		</div>
		
		<div class="reply">
		
			<table width="70%">
			<tr>
				<th>댓글번호</th>
				<th>작성자</th>
				<th>내용</th>
				<th>작성일자</th>
			</tr>
				<c:forEach var="repl" items="${ReplyList }">
					<tr >
						<td>${repl.r_number }</td>
						<td>${repl.m_nickname }</td>
						<td>${repl.r_content }</td>
						<td>${repl.r_date }</td>
					</tr>
				</c:forEach>
			</table>
			<%}else{ %>
				<table border="1" width="70%">
				<tr>
					<th>글 번호</th>
					<td>${board.bbs_number }</td>
					<th>작성자</th>
					<td>${board.m_nickname }</td>
					<th>날짜</th>
					<td>${board.bbs_date }</td>
				</tr>
				<tr>
					<th>제목</th>
					<td colspan="5">(${board.hh_head })${board.bbs_title }</td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="5" height="100px">${board.bbs_content }</td>
				</tr>
				<tr>
					<th>조회수</th>
					<td colspan="5">${board.bbs_views }</td>
				</tr>
			</table>
			<a href="list.do">게시판 목록</a>
		
		
		
			<table border="1" width="70%">
			<tr>
				<th>댓글번호</th>
				<th>작성자</th>
				<th>내용</th>
				<th>작성일자</th>
			</tr>
				<c:forEach var="repl" items="${ReplyList }">
					<tr >
						<td>${repl.r_number }</td>
						<td>${repl.m_nickname }</td>
						<td>${repl.r_content }</td>
						<td>${repl.r_date }</td>
					</tr>
				</c:forEach>
			</table>
		
		</div>
	</div>
	
<%} %>
</body>
</html>

















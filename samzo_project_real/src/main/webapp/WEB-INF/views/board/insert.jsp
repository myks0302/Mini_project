<%@page import="org.samzo.cafe.member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="incss.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href=${pageContext.request.contextPath}/resources/css/insert_style.css>

</head>
<body>
	<%
		MemberDTO mdto = (MemberDTO)session.getAttribute("member");
	%>
	<div>
		<header onclick="location.href='list.do'">
			<img src="../resources/photo/header1.png" alt="header1" height="100%" width="100%" >
		</header>
		
		<div class="container">
			
			<form action="insert.do" method="post">
				<table >	
					<tr>
						<th colspan="4">
							<h3>카페 글쓰기</h3>
							<input type="submit" value="저장" />
							<input type="reset" value="취소" />
						</th>
					</tr>
					<tr>
						<th>게시판</th>
						<td>
							<select name="bbs_category">
								<c:forEach var="cat" items="${categorylist }">
									<option value="${cat }">${cat }</option>
								</c:forEach>
							</select>
						</td>
						<th>말머리</th>
						<td>
							<select name="bbs_head">
								<c:forEach var="horse" items="${horseList }">
									<option value="${horse.hh_number }">${horse.hh_head }</option>
								</c:forEach>
							</select>
						</td>
					</tr>
				
					<tr>
						<th>글 제목</th>
						<td colspan="3">
							<input type="text" name="bbs_title" value="" />
						</td>
					</tr>

					<tr>
						<th>내용</th>
						<td colspan="3">
							<textarea rows="10" cols="50" name="bbs_content">내용</textarea>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>

</body>
</html>
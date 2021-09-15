<%@page import="org.samzo.cafe.member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		MemberDTO mdto = (MemberDTO)session.getAttribute("member");
	%>

	<div class="container">
		<h1>입력</h1>
		<form action="category.go" method="post">
			<table border="1">
				<tr>
					<th>게시판</th>
					<td><select name="bbs_category">
							<c:forEach var="cat" items="${categorylist }">
								<option value="${cat }">${cat }</option>
							</c:forEach>
					</select></td>
				</tr>
			</table>
			<input type="submit" value="저장" />
			<input type="reset" value="취소" />
		</form>
	</div>


</body>
</html>
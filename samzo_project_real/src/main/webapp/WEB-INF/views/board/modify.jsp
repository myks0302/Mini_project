<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="incss.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href=${pageContext.request.contextPath}/resources/css/modify_board_style.css>

</head>
<body>
	<!-- enctype="multipart/form-data" -->
	<div>
		<header onclick="location.href='list.do'">
			<img src="../resources/photo/header1.png" alt="header1" height="100%" width="100%" >
		</header>
		
		<div class="container">
			<form action="modify.do" method="post">
				<table>		
					<tr>
						<th colspan="4">
							<h3>글 수정</h3>
							<input type="submit" value="수정" />
							<input type="reset" value="취소" />
						</th>
					</tr>			
					<tr>
						
						<th>게시판</th>
						<td>
							<input type="hidden" value="${board.bbs_number }" name="bbs_number" />
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
							<input type="text" value="${board.bbs_title }" name="bbs_title" />
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3">
							<textarea rows="10" cols="50" name="bbs_content">${board.bbs_content }</textarea>
						</td>
					</tr>
				</table>
			</form>
		</div>	
	</div>
</body>
</html>
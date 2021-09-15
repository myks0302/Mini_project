<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>

<link rel="stylesheet" href=${pageContext.request.contextPath}/resources/css/memberList_style.css>


<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

</head>
<body>
<div class="memberlist_box">
		<h1>회원목록 조회 페이지</h1>
		<table>
			<tr>
				<th>회원번호</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>닉네임</th>
				<th>이메일</th>
				<th>삭제</th>
			</tr>
			<c:forEach items="${list}" var="member">
				<form action="remove.do" method = "post">
					<tr>
						<td>${member.m_number }</td>
						<td>${member.m_id }</td>
						<td>${member.m_pw }</td>
						<td>${member.m_nickname }</td>
						<td>${member.m_email }</td>
						<td>
							<input type="hidden" name="m_number" value="${member.m_number }"/></input>
							<input type="submit" value="회원삭제" class="remove"/></input>
						</td>
					</tr>
				</form>
			</c:forEach>
			<tr>
				<td colspan="6">
				<input type="button" value="돌아가기" onclick="location.href = 'login.do'"/></input>						
				</td>
			</tr>
		</table>
		
		<!-- 
			<a href = "login.do">메인페이지</a>	
		 -->
		 
		 <script type="text/javascript">
		$(".remove").on("click",function() {
			alert("진짜로 해당 계정을 삭제시키겠습니까?");
			$(this).off();
		});
	</script>
		 
	</div>



</body>
</html>
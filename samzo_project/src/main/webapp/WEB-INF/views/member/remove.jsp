<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
       
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원 탈퇴 페이지</title>

<link rel="stylesheet" href=${pageContext.request.contextPath}/resources/css/remove_style.css>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

</head>
<body>
	<div>
		<h1>회원탈퇴 하시겠습니까?</h1>
		<form action = "remove.do" method = "POST">
			<input type="button" value="돌아가기" onclick="location.href = 'login.do'"/></input>
			<input type="submit" value = "탈퇴하기" class="remove">
		</form>
		
		<!-- 
			<a href = "login.do">메인페이지</a>
		 -->
	</div>
	
	<script type="text/javascript">
		$(".remove").on("click",function() {
			alert("진짜로 탈퇴 하시겠습니까?");
			$(this).off();
		});
	</script>
</body>
</html>
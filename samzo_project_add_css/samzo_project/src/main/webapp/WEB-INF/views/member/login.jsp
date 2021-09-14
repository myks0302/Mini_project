<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>

<link rel="stylesheet" href="../resources/css/login_style.css">

</head>
<body>
	<div class="login_box">
		<h1>로그인 페이지</h1>
		<form action="login.do" method="post">
			<table border="1">
				<tr>
					<th>아이디</th>
					<td><input type="text" name="m_id" /></td>
				</tr>
				<tr>
					<th>패스워드</th>
					<td><input type="password" name="m_pw" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="button" value="회원가입" onclick="location.href = 'join.do'"/>
						<input type="submit"value="로그인" />
					</td>
				</tr>
				
			</table>
		</form>
		
		<!--
			<a href="join.do" style="text-decoration-line: none">회원가입</a>
		 -->
	</div>
</body>
</html>
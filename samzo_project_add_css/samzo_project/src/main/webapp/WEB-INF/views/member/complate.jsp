<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 완료</title>

<link rel="stylesheet" href="../resources/css/complete_style.css">
</head>
<body>
	<h1>관리자 로그인 완료 페이지</h1>
	
	<div class="self_menu">
		<h3>개인관리</h3>
		<button onclick="location.href = 'remove.do'">회원 탈퇴</button>
		<button onclick="location.href = 'modify.do'">회원 정보 수정</button>	
	</div>
	
	<div class="return_menu">
		<h3>돌아가기</h3>
		<button onclick="location.href = 'board/list.do'">게시판 목록</button>
		<button onclick="location.href = 'logout.do'">로그아웃</button>	
	</div>
	
	<div class="admin_menu">
		<h3>관리자 기능</h3>
		<button onclick="location.href = 'memberList.do'">회원 목록</button>
	</div>
	
	<!-- <button onclick="location.href = 'modify.do?bbs_number=${board.bbs_number}'">수정하기</button> -->
	
	<!-- 
		<a href = "remove.do">회원탈퇴</a>
		<a href = "modify.do">회원정보 수정</a>
		<br>
		<a href= "board/list.do">게시판 목록</a>
		<a href= "logout.do">로그아웃</a>
		<br>
		<a href= "memberList.do">회원목록</a>
	 -->
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<ul>
	<li><a href="board/list.do${pageMaker.makeQuery(idx)}">게시판 목록</a></li>
	<li><a href="login.do">로그인 페이지</a></li>
	<li><a href="aside.do">aside 페이지</a></li>
	<li><a href="footer.do">footer 페이지</a></li>
	<li><a href="header.do">header 페이지</a></li>
	<li><a href="mainsection.do">mainsection 페이지</a></li>
</ul>
</body>
</html>

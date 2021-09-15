<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<link rel="stylesheet" href=${pageContext.request.contextPath}/resources/css/login_style.css>
</head>
<body>
	<div class="login_box">
        <div class="login_h1">
         <h1><a href="../cafe/">samzo</a></h1>

        </div>
        
	<!-- 	<h1>로그인 페이지</h1> -->
		<form action="login.do" method="post">
		<h2>Login</h2>
            <div class="input_box">
                <input type="text" id="m_id"  name="m_id" placeholder="id">
                <input type="password"  id="m_pw" name="m_pw"  placeholder="password" class="loginInput" >
                
                <input id="btn_login" type="submit" value="로그인">
            </div>
                
                <div class="join">
                   <a href="join.do"  >회원가입</a>
                </div>
        </form>
                
	
	  </div>
</body>
</html>
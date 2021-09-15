<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script
  src="https://code.jquery.com/jquery-3.6.0.slim.js"
  integrity="sha256-HwWONEZrpuoh951cQD1ov2HUK5zA5DwJ1DNUXaM6FsY="
  crossorigin="anonymous"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login_style.css">

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
	  
	  <script type="text/javascript">
	 	$(function(){
	  		$('#btn_login').on("click",function(){
	  			submitCheck();
	  		});
	  	});
	  	
	  	function submitCheck(){
	  	 	 /* alert("클릭 성공");   */
	   var m_id  = $('#m_id' ).val() ;
            var m_pw = $('#m_pw').val() ;
	 
	    $.ajax({
	  		type:"POST",
	  		url:'/login.do', //접속을 하겠다
	  	  data: {m_id:m_id, m_pw:m_pw},    /*  $("#loginForm").serialize() */
	  		success: function(data){
	  			if(data == "false")
	  				alert('잘 못된 아이디거나 비밀번호가 틀렸습니다');
	  				else
	  					 location.href="login.do" ; 
	  		}
	  	});
	  	}
	  	
	  /*   $('.loginInput').keydown(function(key) {
            if(key.keyCode == 13) {
                $('#submitBtn').click() ;
            }
        }) ; */
	  </script>
	  
</body>
</html>
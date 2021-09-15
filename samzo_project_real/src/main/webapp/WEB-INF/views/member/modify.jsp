<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<link rel="stylesheet" href=${pageContext.request.contextPath}/resources/css/modify_member_style.css>

<script type="text/javascript">
	window.onload = function() {
		var overlab = '<c:out value = "${overlab}"/>';
		if(overlab === 'true'){
			alert("아이디, 닉네임, 이메일 중 중복되는 값이 있습니다.")
		}
	}
</script>
</head>
<body>
	<div>
		<h1>수정 페이지</h1>
		
		<form name = "frm" action = "modify.do" method = "post" onSubmit = "return check()">
		<input type = "hidden" name = "m_number" value = "${member.m_number }">
		<table>
				<tr>
					<th>회원번호</th>
					<td colspan="2"><input type = "text" value = "${member.m_number }"  disabled></td>
				</tr>
				<tr>
					<th>아이디</th>
					<td><input id="m_id" type = "text" name = "m_id" value = "${member.m_id }"/></td>
					<td><button type="button" onclick="idCheck()">중복체크</button>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td colspan="2"><input id="m_pw" type = "text" name = "m_pw" value = "${member.m_pw }"/></td>
				</tr>
				<tr>
					<th>닉네임</th>
					<td><input id = "m_nickname" type = "text" name = "m_nickname" value = "${member.m_nickname }"/></td>
					<td><button type="button" onclick="nameCheck()">중복체크</button></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input id = "m_email" type = "text" name = "m_email" value = "${member.m_email }"/></td>
					<td><button type="button" onclick="mailCheck()">중복체크</button></td>
				</tr>
				<tr>
					<td colspan = "3" align = "center">
					<input type="button" value="돌아가기" onclick="location.href = 'login.do'"/>
					<input type = "submit" value = "수정하기"/>
					</td>
				</tr>
		</table>
		</form>
		
		<!-- 
			<a href = "login.do">메인페이지</a>
		 -->
	</div>
<script>
		var originalId = $("#m_id").val();
		var originalnickname = $("#m_nickname").val();
		var originalemail = $("#m_email").val();
		
		//아이디 중복체크 
		function idCheck() {
			var id = $("#m_id").val();
			id = id.replace(/(\s*)/g,"");
			var list = new Array();
			var checked = true;
			<c:forEach items = "${list}" var = "member">
			list.push("${member.m_id}");
			</c:forEach>
			for (var i = 0; i < list.length; i++) {
				if (id === list[i]) {
					checked = false;

					break;
				}
			}
			
			if (checked ) {
				if(id.replace(/(\s*)/g,"") == "" ){
					alert("아이디를 입력해주세요.");
				}else{
					alert("사용가능한 아이디입니다.");
				}
			} else {
				if(id.replace(/(\s*)/g,"") == ""){
					alert("아이디를 입력해주세요.");
				}else{
					if(originalId == id){
						alert("아이디가 변경되지 않았습니다.");
					}else{
						alert("중복된 아이디입니다.");
					}
				}
			}
		}
		
		
		//닉네임 중복체크
		function nameCheck(){
			var nickname = $("#m_nickname").val();
			nickname = nickname.replace(/(\s*)/g,"");
			var list = new Array();
			var checked = true;
			<c:forEach items = "${list}" var = "member">
				list.push("${member.m_nickname}");
			</c:forEach>
			for(var i = 0; i < list.length; i++){
				if(nickname === list[i]){
					checked = false;
					break;
				}
			}
			
			if(checked){
				if(nickname.replace(/(\s*)/g,"") == ""){
					alert("닉네임을 입력해주세요.")
				}else{
					alert("사용가능한 닉네임입니다.");
				}
			}else{
				if(nickname.replace(/(\s*)/g,"") == ""){
					alert("닉네임을 입력해주세요.")
				}else{
					if(originalnickname == nickname){
						alert("닉네임이 변경되지 않았습니다.");
					}else{
						alert("중복된 닉네임입니다.");
					}
				}
			}
		}
		
		
		//이메일 중복체크
		function mailCheck(){
			var email = $("#m_email").val();
			email = email.replace(/(\s*)/g,"");
			console.log(email);
			var list = new Array();
			var checked = true;
			<c:forEach items = "${list}" var = "member">
				list.push("${member.m_email}");
			</c:forEach>
			for(var i = 0; i < list.length; i++){
				if(email === list[i]){
					checked = false;
					break;
				}
			}
			
			if(checked){
				if(email.replace(/(\s*)/g,"") == ""){
					alert("이메일을 입력해주세요.");
				}else{
					alert("사용가능한 이메일입니다.");
				}
			}else{
				if(email.replace(/(\s*)/g,"") == ""){
					alert("이메일을 입력해주세요.");
				}else{
					if(originalemail == email){
						alert("이메일이 변경되지 않았습니다.");
					}else{
						alert("중복된 이메일입니다.");
					}
				}
			}
		}
		 
		
		//계정생성 누르면 빈칸이 있는지 체크해주는 함수
		function check(){
			var id = frm.m_id.value;
			var name = frm.m_nickname.value;
			var Email = frm.m_email.value;
			var pw = frm.m_pw.value;
			if(id.replace(/(\s*)/g,"") == ""){
				frm.m_id.focus();
				alert("ID를 입력해 주세요.");
				
				return false;
			}else if(pw.replace(/(\s*)/g,"") == ""){
				frm.m_pw.focus();
				alert("비밀번호를 입력해 주세요.");
				
				return false;
			}else if(name.replace(/(\s*)/g,"") == ""){
				frm.m_nickname.focus();
				alert("이름을 입력해 주세요.");
				
				return false;
			}else if(Email.replace(/(\s*)/g,"") == ""){
				frm.m_email.focus();
				alert("Email을 입력해 주세요.");
				
				return false;
			}else{
				frm.m_id.value = frm.m_id.value.replace(/(\s*)/g,"");
				frm.m_pw.value = frm.m_pw.value.replace(/(\s*)/g,"");
				frm.m_email.value = frm.m_email.value.replace(/(\s*)/g,"");
				frm.m_nickname.value = frm.m_nickname.value.replace(/(\s*)/g,"");
			}
		}
	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
       
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ�� Ż�� ������</title>

<link rel="stylesheet" href=${pageContext.request.contextPath}/resources/css/remove_style.css>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

</head>
<body>
	<div>
		<h1>ȸ��Ż�� �Ͻðڽ��ϱ�?</h1>
		<form action = "remove.do" method = "POST">
			<input type="button" value="���ư���" onclick="location.href = 'login.do'"/></input>
			<input type="submit" value = "Ż���ϱ�" class="remove">
		</form>
		
		<!-- 
			<a href = "login.do">����������</a>
		 -->
	</div>
	
	<script type="text/javascript">
		$(".remove").on("click",function() {
			alert("��¥�� Ż�� �Ͻðڽ��ϱ�?");
			$(this).off();
		});
	</script>
</body>
</html>
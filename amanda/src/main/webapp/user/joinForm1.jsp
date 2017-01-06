<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="../decorator/css/style.css">
<title>회원가입</title>
</head>
<body>
<div class="joinwrapper">
<div class="joinimg">

</div>	
	<table class="join02">
	<tr><th >email</th>
		<td><input type="text" id="email"/>
			</td>
	</tr>
	<tr><th>비밀번호</th>
		<td><input type="password" id="password"/>
			</td>
	</tr>
	<tr><th>닉네임</th>
		<td><input type="text" id="nickname"/>
			</td>
	</tr>
</table>
<br/>
<div class="joinbutton">
<input type="reset" class="jb" value="리셋">
<input type="button" class="jb" value="다음">
</div>
</div>
</body>
</html>
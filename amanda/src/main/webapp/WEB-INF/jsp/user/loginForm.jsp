<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="../decorator/css/style.css">
<title>�α���</title>
</head>
<body>
<form:form modelAttribute="user" method="post" action=".do">
<div class="loginwrapper">
<div id="loginlogo"><img alt="logo" src=""></div>
<table class ="join02">
	<thead>
		<tr><th>�α���</th><th></th>
	</thead>
	<tr><th>���̵�</th>
		<td><input type="text" id="email"/>
			</td>
	</tr>
	<tr><th>��й�ȣ</th>
		<td><input type="password" id="password"/>
			</td></tr>

</table>
<input type="button" class="jb" value="ȸ������" onclick="location.href='JoinForm1.do'">
<input type="submit" class="jb" value="�α���">
</div>
</form:form>
</body>
</html>
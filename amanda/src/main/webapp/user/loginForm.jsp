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
<div id="wrapper">
<div id="loginlogo"><img alt="logo" src="../img/logo.jsp"></div>
<table class ="logintab">
	<tr><td>���̵�</td>
		<td><input type="text" id="email"/>
			</td>
	</tr>
	<tr><td>��й�ȣ</td>
		<td><input type="password" id="password"/>
			</td>
	</tr>
	<tr><td><input type="button" value="ȸ������"/></td>
		<td><input type="button" value="�α���"/></td></tr>
</table>
</div>
</body>
</html>
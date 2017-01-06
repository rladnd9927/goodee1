<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="../decorator/css/style.css">
<title>로그인</title>
</head>
<body>
<div id="wrapper">
<div id="loginlogo"><img alt="logo" src="../img/logo.jsp"></div>
<table class ="logintab">
	<tr><td>아이디</td>
		<td><input type="text" id="email"/>
			</td>
	</tr>
	<tr><td>비밀번호</td>
		<td><input type="password" id="password"/>
			</td>
	</tr>
	<tr><td><input type="button" value="회원가입"/></td>
		<td><input type="button" value="로그인"/></td></tr>
</table>
</div>
</body>
</html>
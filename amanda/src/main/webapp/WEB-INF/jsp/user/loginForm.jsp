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
<form:form modelAttribute="user" method="post" action="login.do">
<div class="loginwrapper">
<div id="loginlogo"><img alt="logo" src=""></div>
<table class ="join02">
   <thead>
      <tr><th>�α���</th><th></th>
   </thead>
   <tr><th>���̵�</th>
      <td><form:input path="m_email"/><font color="red"><form:errors path="m_email"></form:errors></font>
         </td>
   </tr>
   <tr><th>��й�ȣ</th>
      <td><form:password  path="m_password"/><font color="red"><form:errors path="m_password"></form:errors></font>
         </td></tr>

</table>
<input type="button" class="jb" value="ȸ������" onclick="location.href='joinForm1.do'">
<input type="submit" class="jb" value="�α���">
</div>
</form:form>
</body>
</html>
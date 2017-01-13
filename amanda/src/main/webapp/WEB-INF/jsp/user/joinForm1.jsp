<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="../decorator/css/style.css">
<title>ȸ������</title>
</head>
<body>
	<form:form modelAttribute="semiuser" method="post" action="join1.do">
		<spring:hasBindErrors name="semiuser">
			<font color="red"> 
			<c:forEach items="${errors.globalErrors}" var="error">
					<spring:message code="${error.code}" />
				</c:forEach>
			</font>
		</spring:hasBindErrors>
		<div class="joinwrapper">
			<div class="joinimg"></div>
			<table class="join02">
				<tr>
					<th>email</th>
					<td><form:input path="s_email" /></td>
				</tr>
				<tr>
					<th>��й�ȣ</th>
					<td><form:password path="s_password" /></td>
				</tr>
				<tr>
					<th>�̸�</th>
					<td><form:input path="s_name" /></td>
				</tr>
				<tr>
					<th>����</th>
					<td><form:radiobutton path="gender" value="0" label="����" /> 
						<form:radiobutton path="gender" value="1" label="����" /></td>
				</tr>
			</table>
			<br />
			<div class="joinbutton">
				<input type="reset" class="jb" value="����"> 
				<input type="submit" class="jb" value="����">
			</div>
		</div>
	</form:form>
</body>
</html>
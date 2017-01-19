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
			<font color="red"> <c:forEach items="${errors.globalErrors}" var="error">
					<spring:message code="${error.code}" />
				</c:forEach>
			</font>
		</spring:hasBindErrors>
		<div class="joinwrapper">
			<div class="joinimg"></div>
			<table class="join02">
				<thead>
					<tr>
						<th colspan="6">�⺻ ȸ������ ����</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>email</th>
						<td>
							<%-- <form:input path="s_email" required/> --%>
							<input type="text" name="s_email" required>
							<%-- <font color="red"><form:errors path="s_email" /></font> --%>
						</td>
					</tr>
					<tr>
						<th>��й�ȣ</th>
						<td>
							<input type="password" name="s_password" required>
							<%-- <form:password path="s_password" /> --%>
							<%-- <font color="red"><form:errors path="s_password" /></font> --%>
						</td>
					</tr>
					<tr>
						<th>�̸�</th>
						<td>
							<input type="text" name="s_name" required>
							<%-- <form:input path="s_name" /> --%>
							<%-- <font color="red"><form:errors path="s_name" /></font> --%>
						</td>
					</tr>
					<tr>
						<th>����</th>
						<td><form:radiobutton path="gender" value="0" label="����" />
							<form:radiobutton path="gender" value="1" label="����" />
						</td>
					</tr>
				</tbody>
			</table>
			<br />
			<div class="joinbutton">
				<input type="reset" class="jb" value="����"> <input
					type="submit" class="jb" value="����">
			</div>
		</div>
	</form:form>
</body>
</html>
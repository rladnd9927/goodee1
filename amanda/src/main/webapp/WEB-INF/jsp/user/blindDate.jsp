<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Amanda</title>
</head>
<body>
	<!-- ����ε� ����Ʈ ������ -->
	<table border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td colspan="5">${USER.m_name}���� ���� ��õ ȸ��</td>
		</tr>
		<tr>
			<td>����</td>
			<td>���̵�</td>
			<td>�г���</td>
			<td>����</td>
			<td>����</td>
			<td>���ƿ�</td>
		</tr>
		<c:forEach items="${userList}" var="user">
			<tr>
				<td>${userprofile.m_picture1}</td>
				<td>${user.m_email}</td>
				<td>${userprofile.m_nickname}</td>
				<td>${userprofile.m_character}</td>
				<td>${userprofile.m_religion}</td>
				<td align="center">��</td>
			</tr>
		</c:forEach>
	</table>
	<br>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>������������</title>
</head>
<body>
<form action="mailForm.do" method = "post">
	<table border="1" cellpadding="0" cellspacing="0">
		<tr><td colspan="7">ȸ�����</td></tr>
		<tr><td>���̵�</td><td>�̸�</td><td>����</td>
			<td>��ȭ��ȣ</td><td>�̸���</td>
			<td>&nbsp;</td><td>&nbsp;</td></tr>
		<c:forEach items="${user.m_number}" var="user">
			<tr><td>${user.m_email}</td>
				<td>${user.m_name}</td>
				<%-- <td><f:formatDate value="${user.birthDay}" pattern="yyyy-MM-dd"/></td> --%>
				<td>${user.gender}</td>
				<td>
				<a href="userdateForm.do?id=${user.userId}">����</a>
				<a href="deleteForm.do?id=${user.userId}">Ż��</a>
				<a href="mypage.do?id=${user.userId}">ȸ��������</a>
				</td>
				<td><input type="checkbox" name="idchks" value="${user.m_email}"></td></tr>
		</c:forEach>
		<tr><td colspan="7" align="center">
			<input type="submit" value="���Ϻ�����"></td></tr>
	</table>
</form>
</body>
</html>
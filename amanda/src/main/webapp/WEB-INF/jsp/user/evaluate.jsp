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
	<h2>ȸ���ɻ�</h2>
	<table class="join02">
		<thead>
		<tr>
			<th>���̵�</th>
			<th>�̸�</th>
			<th>����</th>
			<th>����</th>
			<th>���� ��</th>
			<th>����</th>
			
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${semiuserList}" var="semiuser">
			<c:if test="${semiuser.s_usercount >= 5}"></c:if>
			<c:if test="${semiuser.s_usercount < 5}">
			<tr>
				<td><a href="semiDetail.do?m_number=${semiuser.m_number}">${semiuser.s_email}</a></td>
				<td>${semiuser.s_name}</td>
				<td>
					<c:if test="${semiuser.gender == 0}">����</c:if>
					<c:if test="${semiuser.gender == 1}">����</c:if>
				</td>
				<td>${semiuser.s_score}</td>
				<td>${semiuser.s_usercount}</td>
				<td>
					<c:if test="${semiuser.s_score/semiuser.s_usercount == 'NaN'}">X</c:if>
					<c:if test="${semiuser.s_score/semiuser.s_usercount != 'NaN'}">${semiuser.s_score/semiuser.s_usercount}</c:if>
				</td>
			</tr>
			</c:if>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>
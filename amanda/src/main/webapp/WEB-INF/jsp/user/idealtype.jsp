<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�̻��� ����</title>
</head>
<body>
<div class="IdealWrapper">
	<h2>�� �̻���</h2>
	<input type="button" value="����" onclick="location.href='idealtype2.do'" class="btn1">
	<table class="join02" align="center">
		<tr>
			<th>Ű</th>
			<td>${idealType.i_height}</td>
		</tr>
		<tr>
			<th>ü��</th>
			<td>
				<c:if test="${idealType.i_bodytype == 0}">����</c:if>
				<c:if test="${idealType.i_bodytype == 1}">����źź</c:if>
				<c:if test="${idealType.i_bodytype == 2}">����</c:if>
				<c:if test="${idealType.i_bodytype == 3}">������</c:if>
				<c:if test="${idealType.i_bodytype == 4}">��¦����</c:if>
				<c:if test="${idealType.i_bodytype == 5}">�۷���</c:if>
			</td>
		</tr>
		<tr>
			<th>����</th>
			<td>
				<c:if test="${idealType.i_character == 0}">������</c:if>
				<c:if test="${idealType.i_character == 1}">������</c:if>
				<c:if test="${idealType.i_character == 2}">�����ִ�</c:if>
				<c:if test="${idealType.i_character == 3}">��õ����</c:if>
				<c:if test="${idealType.i_character == 4}">��������</c:if>
				<c:if test="${idealType.i_character == 5}">��������</c:if>
				<c:if test="${idealType.i_character == 6}">��������</c:if>
				<c:if test="${idealType.i_character == 7}">�����</c:if>
				<c:if test="${idealType.i_character == 8}">�Ϳ���</c:if>
				<c:if test="${idealType.i_character == 9}">��������</c:if>
				<c:if test="${idealType.i_character == 10}">������</c:if>
				<c:if test="${idealType.i_character == 11}">�����ִ�</c:if>
			</td>
		</tr>
		<tr>
			<th>����</th>
			<td>
				<c:if test="${idealType.i_religion == 0}">��������</c:if>
				<c:if test="${idealType.i_religion == 1}">�⵶��</c:if>
				<c:if test="${idealType.i_religion == 2}">�ұ�</c:if>
				<c:if test="${idealType.i_religion == 3}">õ�ֱ�</c:if>
				<c:if test="${idealType.i_religion == 4}">���ұ�</c:if>
				<c:if test="${idealType.i_religion == 5}">�̽�����</c:if>
				<c:if test="${idealType.i_religion == 6}">����</c:if>
			</td>
		</tr>
		<tr>
			<th>��</th>
			<td>
				<c:if test="${idealType.i_smoking == 0}">����</c:if>
				<c:if test="${idealType.i_smoking == 1}">��</c:if>
			</td>
		</tr>
		<tr>
			<th>����</th>
			<td>
				<c:if test="${idealType.i_drinking == 0}">����������</c:if>
				<c:if test="${idealType.i_drinking == 1}">��������</c:if>
				<c:if test="${idealType.i_drinking == 2}">������� ������</c:if>
				<c:if test="${idealType.i_drinking == 3}">���ڸ��� ���</c:if>
			</td>
		</tr>
	</table>
</div>
</body>
</html>
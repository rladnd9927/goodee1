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
	<h2>ȸ�� ������</h2>
	<table border="1" cellpadding="0" cellspacing="0" class="join02">
		<tr>
			<td>
				���⿡ semi_member�� ����
				${semiuserProfile.m_pictureUrl1}
			</td>
			<td>
				<table border="1">
					<tr>
						<th>�г���</th>
						<td>${semiuserProfile.m_nickname}</td>
					</tr>
					<tr>
						<th>Ű</th>
						<td>${semiuserProfile.m_height}</td>
					</tr>
					<tr>
						<th>ü��</th>
						<td>
							<c:if test="${semiuserProfile.m_bodytype == 0}">����</c:if>
							<c:if test="${semiuserProfile.m_bodytype == 1}">����źź</c:if>
							<c:if test="${semiuserProfile.m_bodytype == 2}">����</c:if>
							<c:if test="${semiuserProfile.m_bodytype == 3}">������</c:if>
							<c:if test="${semiuserProfile.m_bodytype == 4}">��¦����</c:if>
							<c:if test="${semiuserProfile.m_bodytype == 5}">�۷���</c:if>
						</td>
					</tr>
					<tr>
						<th>����</th>
						<td>
							<c:if test="${semiuserProfile.m_character == 0}">������</c:if>
							<c:if test="${semiuserProfile.m_character == 1}">������</c:if>
							<c:if test="${semiuserProfile.m_character == 2}">�����ִ�</c:if>
							<c:if test="${semiuserProfile.m_character == 3}">��õ����</c:if>
							<c:if test="${semiuserProfile.m_character == 4}">��������</c:if>
							<c:if test="${semiuserProfile.m_character == 5}">��������</c:if>
							<c:if test="${semiuserProfile.m_character == 6}">��������</c:if>
							<c:if test="${semiuserProfile.m_character == 7}">�����</c:if>
							<c:if test="${semiuserProfile.m_character == 8}">�Ϳ���</c:if>
							<c:if test="${semiuserProfile.m_character == 9}">��������</c:if>
							<c:if test="${semiuserProfile.m_character == 10}">������</c:if>
							<c:if test="${semiuserProfile.m_character == 11}">�����ִ�</c:if>
						</td>
					</tr>
					<tr>
						<th>����</th>
						<td>
							<c:if test="${semiuserProfile.m_religion == 0}">��������</c:if>
							<c:if test="${semiuserProfile.m_religion == 1}">�⵶��</c:if>
							<c:if test="${semiuserProfile.m_religion == 2}">�ұ�</c:if>
							<c:if test="${semiuserProfile.m_religion == 3}">õ�ֱ�</c:if>
							<c:if test="${semiuserProfile.m_religion == 4}">���ұ�</c:if>
							<c:if test="${semiuserProfile.m_religion == 5}">�̽�����</c:if>
							<c:if test="${semiuserProfile.m_religion == 6}">����</c:if>
						</td>
					</tr>
					<tr>
						<th>��</th>
						<td>
							<c:if test="${semiuserProfile.m_smoking == 0}">����</c:if>
							<c:if test="${semiuserProfile.m_smoking == 1}">��</c:if>
						</td>
					</tr>
					<tr>
						<th>����</th>
						<td>
							<c:if test="${semiuserProfile.m_drinking == 0}">����������</c:if>
							<c:if test="${semiuserProfile.m_drinking == 1}">��������</c:if>
							<c:if test="${semiuserProfile.m_drinking == 2}">������� ������</c:if>
							<c:if test="${semiuserProfile.m_drinking == 3}">���ڸ��� ���</c:if>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<form:form modelAttribute="semiUser" method="post" action="semi1.do">
			<tr>
				<td colspan="3" align="right">
				<input type="hidden" name="m_number" value="${semiUser.m_number}">
					<form:select path="s_score">
						<form:option value="1">�ڡ١١١�</form:option>
						<form:option value="2">�ڡڡ١١�</form:option>
						<form:option value="3">�ڡڡڡ١�</form:option>
						<form:option value="4">�ڡڡڡڡ�</form:option>
						<form:option value="5">�ڡڡڡڡ�</form:option>
					</form:select>
					<input type="submit" class="btn1" value="�����ֱ�">
				</td>
			</tr>
		</form:form>
	</table>
</body>
</html>
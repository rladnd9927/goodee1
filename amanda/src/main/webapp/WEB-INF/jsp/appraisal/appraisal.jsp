<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="../decorator/css/style.css">
<title>Amanda</title>
</head>
<body>
<form:form modelAttribute="user" method="post" action="list.do">
<div class="appraisal_wrap"><!-- ���� �ٱ��� wrap -->
	<div class="appraisal_userInfo">
		<table class="join02" border="1">
			<tr>
				<td colspan="2" width="200" height="200" bgcolor="#bdbdbd">�����ڸ�</td>
				<td>
					<table>
					<!-- Ű ü�� ���� ���� �� ���� -->
					<thead>
					<tr>
						<th colspan="2">...���� ������</th>
					</tr>
					</thead>
						<tr>
							<th>�г���</th>
							<td>ĭ�� Ȯ���� ���� ���ǹ��� �ؽ�Ʈ${userProfile.m_nickname}</td>
						</tr>
						<tr>
							<th>Ű</th>
							<td>${userProfile.m_height}</td>
						</tr>
						<tr>
							<th>ü��</th>
							<td>${userProfile.m_bodytype}</td>
						</tr>
						<tr>
							<th>����</th>
							<td>${userProfile.m_character}</td>
						</tr>
						<tr>
							<th>����</th>
							<td>${userProfile.m_religion}</td>
						</tr>
						<tr>
							<th>��</th>
							<td>${userProfile.m_smoking}</td>
						</tr>
						<tr>
							<th>����</th>
							<td>${userProfile.m_drinking}</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="3" align="right">
					<select>
						<option>�ڡ١١١�</option>
						<option>�ڡڡ١١�</option>
						<option>�ڡڡڡ١�</option>
						<option>�ڡڡڡڡ�</option>
						<option>�ڡڡڡڡ�</option>
					</select>					
					<input type="submit" value="�����ֱ�" class="jb">
				</td>
			</tr>
		</table>
	</div>
</div>
</form:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="../decorator/css/style.css">
<title>����������</title>
</head>
<body>
<div class="mypage_wrap">
	<div class="mypage_myProfile">
		<table width="100%"> 
			<tr>
				<td width="50%" align="left">���� ����</td>
				<td width="50%" align="right"><a href="" class="more">���� ����</a></td>
			</tr>
		</table>
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>�̸��� / ID</td>
				<td>${user.m_email}</td>
			</tr>
			<tr>
				<td>�г���</td>
				<td>${userProfile.m_nickname}</td>
			</tr>
			<tr>
				<td>�̸�</td>
				<td>${user.m_name}</td>
			</tr>
			<tr>
				<td>�б�</td>
				<td>${userProfile.m_school}</td>
			</tr>
			<tr>
				<td>����</td>
				<td>${userProfile.m_major}</td>
			</tr>
			<tr>
				<td>����</td>
				<td>${userProfile.m_job}</td>
			</tr>
			<tr>
				<td>�������</td>
				<td>${userProfile.m_birthday}</td>
			</tr>
			<tr>
				<td>������</td>
				<td>${userProfile.m_bloodtype}</td>
			</tr>
			<tr>
				<td>��</td>
				<td>${userProfile.m_smoking}</td>
			</tr>
			<tr>
				<td>����</td>
				<td>${userProfile.m_drinking}</td>
			</tr>
			<tr>
				<td>ü��</td>
				<td>${userProfile.m_bodytype}</td>
			</tr>
			<tr>
				<td>����</td>
				<td>${userProfile.m_character}</td>
			</tr>
		</table>
	</div>
	<div class="mypage_I_Like">
		<table width="100%" border="1">
			<tr>
				<td width="50%" align="left">${userProfile.m_nickname}����"���ƿ�" �� ȸ��</td>
				<!-- <td width="50%" align="right"><a href="" class="more">������</a></td>  -->
			</tr>
			<c:forEach items="${userList}" var="user">
				<tr>
					<td>����</td>
					<td>�г���</td>
					<td>����</td>
				</tr>
				<tr>
					<td>${userProfile.m_picture}</td>
					<td>${userProfile.m_nickname}</td>
					<td>${userProfile.m_character}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="mypage_Y_Like">
		<table width="100%" border="1">
			<tr>
				<td width="50%" align="left">${userProfile.m_nickname}����"���ƿ�" �� ȸ��</td>
				<!-- <td width="50%" align="right"><a href="" class="more">������</a></td>  -->
			</tr>
			<c:forEach items="${userList}" var="user">
				<tr>
					<td>����</td>
					<td>�г���</td>
					<td>����</td>
				</tr>
				<tr>
					<td>${userProfile.m_picture}</td>
					<td>${userProfile.m_nickname}</td>
					<td>${userProfile.m_character}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>
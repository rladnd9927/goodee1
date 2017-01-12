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
	<!-- 블라인드 데이트 페이지 -->
	<table border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td colspan="5">${USER.m_name}님을 위한 추천 회원</td>
		</tr>
		<tr>
			<td>사진</td>
			<td>아이디</td>
			<td>닉네임</td>
			<td>성격</td>
			<td>종교</td>
			<td>좋아요</td>
		</tr>
		<c:forEach items="${userList}" var="user">
			<tr>
				<td>${userprofile.m_picture1}</td>
				<td>${user.m_email}</td>
				<td>${userprofile.m_nickname}</td>
				<td>${userprofile.m_character}</td>
				<td>${userprofile.m_religion}</td>
				<td align="center">♡</td>
			</tr>
		</c:forEach>
	</table>
	<br>
</body>
</html>
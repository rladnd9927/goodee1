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
	<h2>디테일페이지 Test</h2>
	<table border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td>
				여기에 semi_member의 사진
				${semiuserProfile.m_pictureUrl1}
			</td>
			<td>
				<table border="1">
					<tr>
						<td>닉네임</td>
						<td>${semiuserProfile.m_nickname}</td>
					</tr>
					<tr>
						<td>키</td>
						<td>${semiuserProfile.m_height}</td>
					</tr>
					<tr>
						<td>체형</td>
						<td>${semiuserProfile.m_bodytype}</td>
					</tr>
					<tr>
						<td>성격</td>
						<td>${semiuserProfile.m_character}</td>
					</tr>
					<tr>
						<td>종교</td>
						<td>${semiuserProfile.m_religion}</td>
					</tr>
					<tr>
						<td>흡연</td>
						<td>${semiuserProfile.m_smoking}</td>
					</tr>
					<tr>
						<td>음주</td>
						<td>${semiuserProfile.m_drinking}</td>
					</tr>
				</table>
			</td>
		</tr>
		<form:form modelAttribute="semiuser" method="post" action="semi1.do">
			<tr>
				<td>
				<input type="hidden" name="s_number" value="${semiuser.s_number}">
					<form:select path="s_score">
						<form:option value="1">★☆☆☆☆</form:option>
						<form:option value="2">★★☆☆☆</form:option>
						<form:option value="3">★★★☆☆</form:option>
						<form:option value="4">★★★★☆</form:option>
						<form:option value="5">★★★★★</form:option>
					</form:select>
				</td>
				<td>
					<input type="submit" class="jb" value="점수주기">
				</td>
			</tr>
		</form:form>
	</table>
</body>
</html>
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
	<h2>������������ Test</h2>
	<table border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td width="100" height="100">
				���⿡ semi_member�� ����
				${semiuserProfile.m_pictureUrl1}
			</td>
			<td>
				<table border="1">
					<tr>
						<td>�г���</td>
						<td>${semiuserProfile.m_nickname}</td>
					</tr>
					<tr>
						<td>Ű</td>
						<td>${semiuserProfile.m_height}</td>
					</tr>
					<tr>
						<td>ü��</td>
						<td>${semiuserProfile.m_bodytype}</td>
					</tr>
					<tr>
						<td>����</td>
						<td>${semiuserProfile.m_character}</td>
					</tr>
					<tr>
						<td>����</td>
						<td>${semiuserProfile.m_religion}</td>
					</tr>
					<tr>
						<td>��</td>
						<td>${semiuserProfile.m_smoking}</td>
					</tr>
					<tr>
						<td>����</td>
						<td>${semiuserProfile.m_drinking}</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<form action="../user/evaluate.do">
					<input type="hidden" name="s_number" value="${semiuserProfile.s_number}">
					<table>
						<tr>
							<td>
								<select name="m_score">
									<c:forEach begin="1" end="5" var="idx">
										<option>${idx}</option>
									</c:forEach>
								</select>
							</td>
							<td>
								<input type="submit" value="�����ֱ�">
							</td>
						</tr>
					</table>
				</form>
			</td>
			<!-- 
			<td>
				<select>
					<option>�ڡ١١١�</option>
					<option>�ڡڡ١١�</option>
					<option>�ڡڡڡ١�</option>
					<option>�ڡڡڡڡ�</option>
					<option>�ڡڡڡڡ�</option>
				</select>
			</td>
			<td>
				<input type="submit" value="�����ֱ�">
			</td>
			-->
		</tr>
	</table>
</body>
</html>
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
	<h2>ȸ���ɻ� ������</h2>
	<table class="join02">
		<thead>
		<tr>
			<th>���̵�</th>
			<th>�̸�</th>
			<th>����</th>
			<th>����</th>
			<td>�ɻ��� ��� ��</td>
			
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${semiuserList}" var="semiuser">
			<tr>
				<td><a href="semiDetail.do?s_number=${semiuser.s_number}">${semiuser.s_email}</a></td>
				<td>${semiuser.s_name}</td>
				<td>${semiuser.gender}</td>
				<td>${semiuser.s_score}</td>
				<td>${semiuser.s_usercount}</td>
			</tr>
			<!-- 
			<tr>
				<td colspan="5">
					<form action="detail.do">
						<input type="hidden" name="id" value="${item.id }">
						<table>
							<tr align="right">
								<td>
									<select name="quantity">
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
							</tr>
						</table>
					</form>
				</td>
			</tr>
			 -->
		</c:forEach>
		</tbody>
	</table>
</body>
</html>
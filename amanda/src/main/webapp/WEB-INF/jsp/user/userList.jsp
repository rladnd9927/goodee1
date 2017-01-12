<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="../decorator/css/style.css">
<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
<script>
$(document).ready(function(){
$('.user_btn').on('click',function(){
$('.in_table').toggle();
});
});
</script>
<title>ȸ�����</title>
</head>
<body>
<div class="container">
	<div class="searchuser">
		<form action="listsearch.do" method = "post" name="f">
		 ȸ�� �˻�:
			<select name="column">
				<option value="">�����ϼ���</option>
				<option value="region">����</option>
				<option value="age">����</option>
				<option value="height">Ű</option>
			</select>
			<script type="text/javascript">
				document.f.column.value="${param.column}";
			</script>
			<input type="text" name="find" size="50" value="${find}">
			<input type="submit" value="�˻�" class="search">
		</form>
	</div>

	<h2>���� ����</h2>
	<div class="userwrapper">
		<table class="join02">
			<thead>
			<tr><th colspan="7">ȸ�����</th></tr>
			<tr>
				<td>���̵�</td>
				<td>�̸�</td>
				<td>����</td>
			</tr>
			</thead>
			<tbody>

			</tbody>
		</table>

	</div>
	<hr/>
	<div class="userwrapper">
		<h2>ȸ������Ʈ</h2>
		<table class="join02">
		<thead>
			<tr><th colspan="7">ȸ�����</th></tr>
			<tr>
				<td>����</td>
				<td>�г���</td>
				<td>����</td>
			</tr>
		</thead>
		<tbody >
			<c:forEach items="${userList}" var = "user">
				<tr class= "user_btn">
					<td><a href="userDetail.do?m_number=${user.m_number}"> ${user.m_email}</a></td>
				</tr> 
				<tr class="in_table">
				<c:forEach items="${userProfile}" var="userProfile">
					<c:if test="${userProfile.m_number == user.m_number}">
					<td>${userProfile.m_nickname}</td>
					<td>${userProfile.m_height}</td>
					<td>${userProfile.m_nickname}</td>
					</c:if>
				</c:forEach>
				</tr>
			</c:forEach>
	</table>
</div>
</div> 
</body>
</html>

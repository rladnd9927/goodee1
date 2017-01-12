<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="../decorator/css/style.css">
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
			<tbody>

			<c:forEach items="${userList}" var="user">
				<tr>
					<td>${userProfile.m_picture1}</td>
					<td>${user.m_name}</td>
					<td><c:if test="${user.gender == 0 }">��</c:if>
						<c:if test="${user.gender == 1 }">��</c:if>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
<%-- 		<div class="user">
			<div class="usericon" ><img src="" alt="usericon" width="150" height="150"></div>
			<div class="userprofile">
				<font color="black">�̸�:${user.m_name}</font><br>
				<font color="black">����${user.gender}</font>
			</div>
		</div>
		<div class="user">
			<div class="usericon" ><img src="" alt="usericon" width="150" height="150"></div>
			<div class="userprofile"><font color="black">mem.id</font></div>
	</div> --%>
</div>
</div> 
</body>
</html>

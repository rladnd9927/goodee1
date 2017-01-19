<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript">
	function win_open() {
		var op = "width=300, height=50, scrollbars=yes,"
				+ "resizeable=yes,left=50,top=150";
		window.open("memberimg.do", "picture", op);
	}
</script>
<link rel="stylesheet" href="../decorator/css/style.css">
<title>ȸ������</title>
</head>
<body>
	<form:form modelAttribute="userprofile" method="post"
		action="joinForm2.do" enctype="multipart/form-data">
		<spring:hasBindErrors name="userprofile">
			<font color="red"> <c:forEach items="${errors.globalErrors}"
					var="error">
					<spring:message code="${error.code}" />
				</c:forEach>
			</font>
		</spring:hasBindErrors>
		<input type="hidden" name="m_number"
			value="${userprofile.semiuser.m_number}">
		<input type="hidden" name="s_email"
			value="${userprofile.semiuser.s_email }">
		<input type="hidden" name="s_password"
			value="${userprofile.semiuser.s_password }">
		<input type="hidden" name="s_name"
			value="${userprofile.semiuser.s_name }">
		<input type="hidden" name="gender"
			value="${userprofile.semiuser.gender }">
		<div class="joinwrapper">
			<div class="joinimg"></div>
			<table class="join02">
				<thead>
					<tr>
						<th colspan="6">�⺻ ȸ������ ����</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td align="right">
							<input type="file" name="m_picture1"> 
							<input type="file" name="m_picture2">
							<input type="file" name="m_picture3">
						</td>
					</tr>
					<tr>
						<th>�г���</th>
						<%-- <td><form:input path="m_nickname" /></td> --%>
						<td><input type="text" name="m_nickname" required></td>
					</tr>
					<tr>
						<th>�б�</th>
						<%-- <td><form:input path="m_school" /></td> --%>
						<td><input type="text" name="m_school" required></td>
					</tr>
					<tr>
						<th>����</th>
						<%-- <td><form:input path="m_major" /></td> --%>
						<td><input type="text" name="m_major" required></td>
					</tr>
					<tr>
						<th>����</th>
						<%-- <td><form:input path="m_job" /></td> --%>
						<td><input type="text" name="m_job" required></td>
					</tr>
					<tr>
						<th>����</th>
						<%-- <td><form:input path="m_area" /></td> --%>
						<td><input type="text" name="m_area" required></td>
					</tr>
					<tr>
						<th>�������</th>
						<%-- <td><form:input path="m_birthday" /></td> --%>
						<td><input type="text" name="m_birthday" required></td>
					</tr>
					<tr>
						<th>Ű</th>
						<%-- <td><form:input path="m_height" /></td> --%>
						<td><input type="text" name="m_height" required></td>
					</tr>
					<tr>
						<th>������</th>
						<td><form:select path="m_bloodtype">
								<form:option value="0">A</form:option>
								<form:option value="1">B</form:option>
								<form:option value="2">AB</form:option>
								<form:option value="3">O</form:option>
							</form:select></td>
					</tr>
					<tr>
						<th>����</th>
						<td><form:select path="m_religion">
								<form:option value="0">��������</form:option>
								<form:option value="1">�⵶��</form:option>
								<form:option value="2">�ұ�</form:option>
								<form:option value="3">õ�ֱ�</form:option>
								<form:option value="4">���ұ�</form:option>
								<form:option value="5">�̽�����</form:option>
								<form:option value="6">����</form:option>
							</form:select></td>
					</tr>
					<tr>
						<th>��</th>
						<td><form:radiobutton path="m_smoking" value="0" label="����" />
							<form:radiobutton path="m_smoking" value="1" label="��" /></td>
					</tr>
					<tr>
						<th>����</th>
						<td><form:select path="m_drinking">
								<form:option value="0">������ ����</form:option>
								<form:option value="1">���� ����</form:option>
								<form:option value="2">������� ������</form:option>
								<form:option value="3">���ڸ��� ���</form:option>
							</form:select></td>
					</tr>
					<tr>
						<th>ü��</th>
						<td><form:select path="m_bodytype">
								<form:option value="0">����</form:option>
								<form:option value="1">����źź</form:option>
								<form:option value="2">����</form:option>
								<form:option value="3">������</form:option>
								<form:option value="4">��¦����</form:option>
								<form:option value="5">�۷���</form:option>
							</form:select></td>
					</tr>
					<tr>
						<th>����</th>
						<td><form:checkbox path="m_character" value="0" label="������" />
							<form:checkbox path="m_character" value="1" label="������" /> <form:checkbox
								path="m_character" value="2" label="�����ִ�" /> <form:checkbox
								path="m_character" value="3" label="��õ����" /> <form:checkbox
								path="m_character" value="4" label="��������" /> <form:checkbox
								path="m_character" value="5" label="��������" /> <form:checkbox
								path="m_character" value="6" label="��������" /> <form:checkbox
								path="m_character" value="7" label="�����" /> <form:checkbox
								path="m_character" value="8" label="�Ϳ���" /> <form:checkbox
								path="m_character" value="9" label="��������" /> <form:checkbox
								path="m_character" value="10" label="������" /> <form:checkbox
								path="m_character" value="11" label="�����ִ�" /></td>
					</tr>
				</tbody>
			</table>
			<br />
			<div class="joinbutton">
				<input type="reset" class="jb" value="����"> <input
					type="submit" class="jb" value="ȸ������">
			</div>
		</div>
	</form:form>
</body>
</html>
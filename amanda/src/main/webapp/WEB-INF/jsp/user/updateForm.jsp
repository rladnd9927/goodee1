<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="../decorator/css/style.css">
<title>ȸ������ ����</title>
<script type="text/javascript">
	function file1_delete() {
		document.updateform.file4.value = "";
		document.getElementById("file1_desc").innerHTML = "";
	}
	function file2_delete() {
		document.updateform.file5.value = "";
		document.getElementById("file2_desc").innerHTML = "";
	}
	function file3_delete() {
		document.updateform.file6.value = "";
		document.getElementById("file3_desc").innerHTML = "";
	}
</script>
</head>
<body>
	<form:form modelAttribute="userProfile" method="post"
		action="update.do?m_number=${user.m_number}&" enctype="multipart/form-data" name="updateform">
		<input type="hidden" name="file4" value="${userProfile.m_pictureUrl1 }">
		<input type="hidden" name="file5" value="${userProfile.m_pictureUrl2 }">
		<input type="hidden" name="file6" value="${userProfile.m_pictureUrl3 }">
		<input type="hidden" name="user.m_number" value="${user.m_number }">
		<div class="joinwrapper">
			<div class="joinimg">
				<table class="join02">
					<thead>
						<tr>
							<th colspan="6">�⺻ ������</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th>email</th>
							<td>${user.m_email }</td> 
						</tr>
						<tr>
							<th>��й�ȣ</th>
							<td><form:password path="user.m_password" /></td>
						</tr>
						<tr>
							<th>�̸�</th>
							<td>${user.m_name }</td>
						</tr>
						<tr>
							<th>����</th>
							<td><c:if test="${user.gender == 0}">����</c:if>
								<c:if test="${user.gender == 1}">����</c:if></td>
						</tr>
					</tbody>
				</table>
				<br>
				<table class="join02">
					<thead>
						<tr>
							<th colspan="6">�� ������</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><img src="../../fileupload/${userProfile.m_pictureUrl1 }" id="pic"
								width="100" height="120">
							<img src="../fileupload/${userProfile.m_pictureUrl2 }" id="pic"
								width="100" height="120">
							<img src="../fileupload/${userProfile.m_pictureUrl3 }" id="pic"
								width="100" height="120"></td>
						</tr>
						<tr>
							<td>
								<c:if test="${not empty userProfile.m_pictureUrl1 }">
									<div id="file_desc1">
										${userProfile.m_pictureUrl1 } 
										<a href="javascript:file1_delete()">[÷�����ϻ���]</a>
									</div>
								</c:if> <input type="file" name="m_picture1"> 
								<c:if test="${not empty userProfile.m_pictureUrl2 }">
									<div id="file_desc2">
										${userProfile.m_pictureUrl2 } 
										<a href="javascript:file2_delete()">[÷�����ϻ���]</a>
									</div>
								</c:if> <input type="file" name="m_picture2"> 
								<c:if test="${not empty userProfile.m_pictureUrl3 }">
									<div id="file_desc3">
										${userProfile.m_pictureUrl3 } 
										<a href="javascript:file3_delete()">[÷�����ϻ���]</a>
									</div>
								</c:if> <input type="file" name="m_picture3">
							</td>
						</tr>
				</table>

				<table class="join02">
					<tr>
						<th>�г���</th>
						<td><form:input path="m_nickname" /></td>
					</tr>
					<tr>
						<th>�б�</th>
						<td><form:input path="m_school" /></td>
					</tr>
					<tr>
						<th>����</th>
						<td><form:input path="m_major" /></td>
					</tr>
					<tr>
						<th>����</th>
						<td><form:input path="m_job" /></td>
					</tr>
					<tr>
						<th>����</th>
						<td><form:input path="m_area" /></td>
					</tr>
					<tr>
						<th>�������</th>
						<td><form:input path="m_birthday" /></td>
					</tr>
					<tr>
						<th>Ű</th>
						<td><form:input path="m_height" /></td>
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
			</div>
			<br />
			<div class="joinbutton">
				<input type="button" class="jb" value="�ڷΰ���" onclick="history.back(-1);">
				<input type="submit" class="jb" value="����">
			</div>
		</div>
	</form:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�̻��� ����</title>
</head>
<body>
<div class="IdealWrapper">
	<h2>�̻��� ����</h2>
	<form:form modelAttribute="idealType" method="post" action="idealtype_update.do">
		<table class="join02">
			<tr>
				<th>Ű</th>
				<td>
					<form:input path="i_height" />
				</td>
			</tr>
			<tr>
				<th>����</th>
				<td>
					<form:select path="i_religion">
						<form:option value="0">��������</form:option>
						<form:option value="1">�⵶��</form:option>
						<form:option value="2">�ұ�</form:option>
						<form:option value="3">õ�ֱ�</form:option>
						<form:option value="4">���ұ�</form:option>
						<form:option value="5">�̽�����</form:option>
						<form:option value="6">����</form:option>
					</form:select>
				</td>
			</tr>
			<tr>
				<th>��</th>
				<td>
					<form:radiobutton path="i_smoking" value="0" label="����" />
					<form:radiobutton path="i_smoking" value="1" label="��" />
				</td>
			</tr>
			<tr>
				<th>����</th>
				<td>
					<form:select path="i_drinking">
						<form:option value="0">������ ����</form:option>
						<form:option value="1">���� ����</form:option>
						<form:option value="2">������� ������</form:option>
						<form:option value="3">���ڸ��� ���</form:option>
					</form:select>
				</td>
			</tr>
			<tr>
				<th>ü��</th>
				<td>
					<form:select path="i_bodytype">
						<form:option value="0">����</form:option>
						<form:option value="1">����źź</form:option>
						<form:option value="2">����</form:option>
						<form:option value="3">������</form:option>
						<form:option value="4">��¦����</form:option>
						<form:option value="5">�۷���</form:option>
					</form:select>
				</td>
			</tr>
			<tr>
				<th>����</th>
				<td>
					<form:checkbox path="i_character" value="0" label="������" />
					<form:checkbox path="i_character" value="1" label="������" /> 
					<form:checkbox path="i_character" value="2" label="�����ִ�" /> 
					<form:checkbox path="i_character" value="3" label="��õ����" /> 
					<form:checkbox path="i_character" value="4" label="��������" /> 
					<form:checkbox path="i_character" value="5" label="��������" /> 
					<form:checkbox path="i_character" value="6" label="��������" /> 
					<form:checkbox path="i_character" value="7" label="�����" /> 
					<form:checkbox path="i_character" value="8" label="�Ϳ���" /> 
					<form:checkbox path="i_character" value="9" label="��������" /> 
					<form:checkbox path="i_character" value="10" label="������" /> 
					<form:checkbox path="i_character" value="11" label="�����ִ�" />
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="����" class="btn1">
					<input type="reset" value="����" class="btn1">
				</td>
			</tr>
		</table>
	</form:form>
</div>
</body>
</html>
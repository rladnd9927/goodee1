<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�Խñ� ����ȭ��</title>
<script type="text/javascript">
	function file_delete(){
		document.updateform.file2.value="";
		document.getElementById("file_desc").innerHTML="";
	}
</script>
</head>
<body>
<form:form modelAttribute="board" action="update.shop" enctype="multipart/form-data" name="updateform">
	<input type="hidden" name="file2" value="${board.fileUrl}">
	<form:hidden path="num"/>
	<form:hidden path="name"/>
	<table border="1" cellpadding="0" cellspacing="0">
		<tr><td colspan="2">Spring�Խ���</td></tr>
		<tr><td>����</td>
			<td><form:input path="subject"/>
				<font color="red"><form:errors path="subject"></form:errors></font></td></tr>
		<tr><td>����</td>
			<td><form:textarea path="content" cols="67" row="15"/>
				<font color="red"><form:errors path="subject"></form:errors></font></td></tr>
			<tr><td>÷������</td>
				<td><c:if test="${not empty board.fileUrl}">
						<div id="file_desc">
							<a href="filedown.shop?filename=${board.fileUrl}">${board.fileUrl}</a>&nbsp;
							<a href="javascript:file_delete()">[÷�����ϻ���]</a>
						</div>
					</c:if> <input type="file" name="file1" id="file1"></td></tr>
		<tr><td>��й�ȣ</td>
			<td><form:password path="pass"/>
			<font color="red"><form:errors path="pass"></form:errors></font>
		</td></tr>
		<tr><td colspan="2"><a href="javascript:document.updateform.submit()">[����]</a>
							<a href="list.shop">[���]</a></td></tr>
		</table></form:form></body></html>
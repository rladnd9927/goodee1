<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>����������</title>
<script type="text/javascript">
	function disp_div(id){
		document.getElementById("minfo").style.display="none";
		document.getElementById(id).style.display="block";
	}
	function list_disp(id){
		var disp = document.getElementById(id);
		if(disp.style.display == 'block'){
			disp.style.display = "none";
		}else{
			disp.style.display="block";
		}
	}
</script>
</head>
<body>
<table>
	<tr><td><a href="javascript:disp_div('minfo')">ȸ����������</a></td>
	</tr>
</table>
<div id="minfo" style="display: block; width:100%">
	<table border="1" cellpadding="0" cellspacing="0">
		<tr><td>���̵�</td><td>${user.userId}</td></tr>
		<tr><td>�̸�</td><td>${user.userName}</td></tr>
		<tr><td>�����ȣ</td><td>${user.postCode}</td></tr>
		<tr><td>��ȭ��ȣ</td><td>${user.phoneNo}</td></tr>
		<tr><td>�̸���</td><td>${user.email}</td></tr>
		<tr><td>�������</td><td>${user.birthDay}</td></tr>
	</table>
</div>
</body>
</html>
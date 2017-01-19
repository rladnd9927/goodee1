<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="../decorator/css/style.css">
<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
function win_open(){
	var op = "width = 500, height = 540, scrollbars = yes, resizable = yes, left = 50, op = 150";
	window.open("userList.do", "picture", op);
}
</script>
<script>
/* function win_open(){
	var url = "userDtail.do?m_email="+document.f.m_email.value";
	var name="win_open";
	window.oepn(url,"ȸ�� �� ����","width=300,height=300,tollbar=no,location=no,resizable=yes,left=50,right=50");
    /* var op="width=300, height=250, scrollbars=yes, resizeable=no, left=50, top=10";
    window.open("userDetail.do?m_number="+document.f.m_number.value,"m_number",op)}
*/

$(document).ready(function(){
$('.user_btn').on('click',function(){
$('.in_table').toggle();
});
});
</script>
<title>������������</title>
</head>
<body>
<div class="container">
	<div class="searchuser">
		<form action="admin.do" method="post" name="f">
		 ȸ�� �˻�:
			<select name="column">
				<option selected="selected" value="">�����ϼ���</option>
				<option value="m_name">�̸�</option>
				<option value="m_bodytype">ü��</option>
			</select>
			<script type="text/javascript">
				document.f.column.value="${param.column}";
			</script>
			<input type="text" name="find" size="50" value="${find}">
			<input type="submit" value="�˻�">
		</form>
	</div>
	<hr/>
	<div class="userwrapper">
		<h2>ȸ������Ʈ</h2>
		<table class="join02">
		<thead>
			<tr><th colspan="4">ȸ�����</th></tr>
			</thead>
		<tbody >
			<tr>
				<th>ȸ����ȣ</th>
				<th>ID/EMAIL</th>
				<th>�̸�</th>
				<th>����</th>
				<th colspan="3" align="center">�����׸�</th>
			</tr>
			<c:forEach items="${userCount}" var = "user">
			<c:if test="${sessionScope.USER.m_email != user.m_email}">
				<tr>
					<td>${user.m_number}</td>
					<td>${user.m_email}</td>
					<td>${user.m_name}</td>
					<td><c:if test="${user.gender == 0}">����</c:if>
						<c:if test="${user.gender == 1}">����</c:if>
					</td>
										
					<td>
						<input type="button" 
							onclick="location.href='updateForm.do?m_number=${user.m_number}'" 
							class="white" value="ȸ������"></a></td>
					<td>
						<input type="button" 
							onclick="location.href='deleteForm.do?m_number=${user.m_number}'" 
							class="white" value="ȸ��Ż��"></a></td>	
					<td>
						<input type="button" 
							onclick="location.href='userDetail.do?m_number=${user.m_number}'" 
							class="white" value="ȸ��������"></a></td>		
				</tr>
				</c:if>
			</c:forEach>
	</table>
	</div>
</div>
</body>
</html>

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
<title>ȸ�����</title>
</head>
<body>
<div class="container">
	<div class="searchuser">
		<form action="userList.do" method = "post" name="f">
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

	
	<h2>���� ����</h2>
	<div class="userwrapper">
		<table class="join02">
			<thead>
			<tr><th colspan="7">ȸ�����</th></tr>
			</thead>
			<tbody>
			<tr>
				<th>���̵�</th>
				<th>�̸�</th>
				<th>����</th>
				
			</tr>

			</tbody>
		</table>

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
				<th>����</th>
				<th>�̸�</th>
				<th>������</th>
				<th>���ƿ�</th> 
			</tr>
			<c:forEach items="${userCount}" var = "user">
			<c:if test="${sessionScope.USER.m_email != user.m_email}">
				<tr >
					<td><c:if test="${user.gender == 0}">����</c:if>
						<c:if test="${user.gender == 1}">����</c:if>
					</td>
					<td >${user.m_name}</td>					
					<td><input type="button" onclick="location.href='userDetail.do?m_number=${user.m_number}'" class="white" value="������"></a></td>
					<td><a href="likelist.do?userNum=${user.m_number}" class="ovalbutton"><img src="../img/Heart.png" alt="���ƿ�" width="20px"/></a></td>
					<!-- <td><input type="button" name="m_email" onclick="win_oepn()" value="������ ����"></td> -->
				</tr>
<%-- 				 <tr class="userProfile">
 				  <c:forEach items="${userProfile}" var="userProfile">
				   <td>${userProfile.m_bodytype}</td>
				</c:forEach>
				 
				 </tr> --%>
				</c:if>
			</c:forEach>
	</table>
</div>
<hr>
<h2>�Ұ���</h2>
	<input type="button" value="�� �̻���" onclick="location.href='idealtype.do'" class="btn1">
	<div class="userwrapper">
		<table class="join02">
			<thead>
				<tr>
					<th colspan="7">ȸ�����</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>�г���</th>
					<th>Ű</th>
					<th>ü��</th>
					<th>����</th>
					<th>����</th>
					<th>��</th>
					<th>����</th>
				</tr>
				<c:forEach items="${idealList}" var = "ideal">
					<tr>
						<td>${ideal.m_nickname}</td>
						<td>${ideal.m_height}</td>
						<td>
							<c:if test="${ideal.m_bodytype == 0}">����</c:if>
							<c:if test="${ideal.m_bodytype == 1}">����źź</c:if>
							<c:if test="${ideal.m_bodytype == 2}">����</c:if>
							<c:if test="${ideal.m_bodytype == 3}">������</c:if>
							<c:if test="${ideal.m_bodytype == 4}">��¦����</c:if>
							<c:if test="${ideal.m_bodytype == 5}">�۷���</c:if>
						</td>
						<td>
							<c:if test="${ideal.m_character == 0}">������</c:if>
							<c:if test="${ideal.m_character == 1}">������</c:if>
							<c:if test="${ideal.m_character == 2}">�����ִ�</c:if>
							<c:if test="${ideal.m_character == 3}">��õ����</c:if>
							<c:if test="${ideal.m_character == 4}">��������</c:if>
							<c:if test="${ideal.m_character == 5}">��������</c:if>
							<c:if test="${ideal.m_character == 6}">��������</c:if>
							<c:if test="${ideal.m_character == 7}">�����</c:if>
							<c:if test="${ideal.m_character == 8}">�Ϳ���</c:if>
							<c:if test="${ideal.m_character == 9}">��������</c:if>
							<c:if test="${ideal.m_character == 10}">������</c:if>
							<c:if test="${ideal.m_character == 11}">�����ִ�</c:if>
						</td>
						<td>
							<c:if test="${ideal.m_religion == 0}">��������</c:if>
							<c:if test="${ideal.m_religion == 1}">�⵶��</c:if>
							<c:if test="${ideal.m_religion == 2}">�ұ�</c:if>
							<c:if test="${ideal.m_religion == 3}">õ�ֱ�</c:if>
							<c:if test="${ideal.m_religion == 4}">���ұ�</c:if>
							<c:if test="${ideal.m_religion == 5}">�̽�����</c:if>
							<c:if test="${ideal.m_religion == 6}">����</c:if>
						</td>
						<td>
							<c:if test="${ideal.m_smoking == 0}">����</c:if>
							<c:if test="${ideal.m_smoking == 1}">��</c:if>
						</td>
						<td>
							<c:if test="${ideal.m_drinking == 0}">����������</c:if>
							<c:if test="${ideal.m_drinking == 1}">��������</c:if>
							<c:if test="${ideal.m_drinking == 2}">������� ������</c:if>
							<c:if test="${ideal.m_drinking == 3}">���ڸ��� ���</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div> 
</body>
</html>

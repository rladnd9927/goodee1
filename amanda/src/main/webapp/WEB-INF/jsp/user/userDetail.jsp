<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp"%>
<%
	Date birthday = new Date();
	request.setAttribute("birthday", birthday);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div class="joinwrapper">
			<table class="join02">
				<thead>
				 <tr>
					<th colspan="6">ȸ��������</th>
				 </tr>
				</thead>
				<tbody>
				 <tr>
				 	<th>����</th>
				 	<td><img src="../img/${pictureUrl1}" alt="ȸ������"></td>
				 </tr>
				 <tr>
				 	<th>�г���</th>
				 	<td>${userProfile.m_nickname}</td>
				 	<th>����</th>
				 	<td>${userProfile.m_nickname}</td>
				 </tr>
				 <tr>
				 	<th>�б�</th>
				 	<td>${userProfile.m_school}</td>
				 	<th>����</th>
				 	<td>${userProfile.m_major}</td>
				 </tr>
				 <tr>
				 	<th>����</th>
				 	<td>${userProfile.m_area}</td>
				 	<th>�������</th>
				 	<td>${userProfile.m_birthday}</td>
				 </tr>
				 <tr>
				 	<th>Ű</th>
				 	<td>${userProfile.m_height}</td>
				 	<th>������</th>
				 	<td>
				 		<c:if test="${userProfile.m_bloodtype==0}" >A</c:if>
				 		<c:if test="${userProfile.m_bloodtype==1}" >B</c:if>
				 		<c:if test="${userProfile.m_bloodtype==2}" >AB</c:if>
				 		<c:if test="${userProfile.m_bloodtype==3}" >O</c:if>
				 	</td>
				 </tr>
				 <tr>
				 	<th>ü��</th>
				 	<td>
				 		<c:if test="${userProfile.m_bodytype==0}">����</c:if>
				 		<c:if test="${userProfile.m_bodytype==1}">���� źź</c:if>
				 		<c:if test="${userProfile.m_bodytype==2}">����</c:if>
				 		<c:if test="${userProfile.m_bodytype==3}">������</c:if>
				 		<c:if test="${userProfile.m_bodytype==4}">��¦����</c:if>
				 		<c:if test="${userProfile.m_bodytype==5}">�۷���</c:if>
				 	</td>
				 	<th>����</th>
				 	<td>
				 		<c:if test="${userProfile.m_religion==0}" >��������</c:if>
				 		<c:if test="${userProfile.m_religion==1}" >�⵶��</c:if>
				 		<c:if test="${userProfile.m_religion==2}" >�ұ�</c:if>
				 		<c:if test="${userProfile.m_religion==3}" >õ�ֱ�</c:if>
				 		<c:if test="${userProfile.m_religion==4}" >���ұ�</c:if>
				 		<c:if test="${userProfile.m_religion==5}" >�̽�����</c:if>
				 		<c:if test="${userProfile.m_religion==6}" >����</c:if>
				 	</td>
				 </tr>
				 <tr>
				 	<th>����</th>
				 	<td>
				 		<c:if test="${userProfile.m_drinking==0}">������ ����</c:if>
				 		<c:if test="${userProfile.m_drinking==1}">���� ����</c:if>
				 		<c:if test="${userProfile.m_drinking==2}">������� ���� ��</c:if>
				 		<c:if test="${userProfile.m_drinking==3}">���ڸ��� ���</c:if>
				 	</td>
				 	<th>����</th>
				 	<td>
				 		
				 		<c:if test="${userProfile.m_character==0}">������</c:if>
				 		<c:if test="${userProfile.m_character==1}">������</c:if>
				 		<c:if test="${userProfile.m_character==2}">�����ִ�</c:if>
				 		<c:if test="${userProfile.m_character==3}">��õ����</c:if>
				 		<c:if test="${userProfile.m_character==4}">��������</c:if>
				 		<c:if test="${userProfile.m_character==5}">��������</c:if>
				 		<c:if test="${userProfile.m_character==6}">��������</c:if>
				 		<c:if test="${userProfile.m_character==7}">�����</c:if>
				 		<c:if test="${userProfile.m_character==8}">�Ϳ���</c:if>
				 		<c:if test="${userProfile.m_character==9}">��������</c:if>
				 		<c:if test="${userProfile.m_character==10}">������</c:if>
				 		<c:if test="${userProfile.m_character==11}">�����ִ�</c:if>
				 	</td>
				 </tr>
				 <tr>
				 	<th>SNS</th>
				 	<td><a href="#">SNS ��������</a></td>
				</tbody>
			</table>
			<br />
<!-- 			<div class="joinbutton">
				<input type="reset" class="jb" value="����"> 
				<input type="submit" class="jb" value="ȸ������">
			</div> -->
		</div>
</body>
</html>
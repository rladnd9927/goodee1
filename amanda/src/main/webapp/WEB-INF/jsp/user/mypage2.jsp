<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- /WebContent/WEB-INF/jsp/board/detail.jsp --%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>����������</title>
</head>
<body>
<table class="join02">
	<thead>
   <tr>
      <th >���� ���ƿ��� ���</th>
      <th >���ƿ�</th>         
   </tr>
   </thead>
   <c:forEach items="${mypage}" var="chat">
   <tbody>
   <tr>
     <c:forEach items="${userList}" var="user">
  		<c:if test="${chat.y_number == user.m_number}">
   <c:if test="${chat.m_like!=1}">
      <td align="left">
      	<a href="userDetail.do?m_number=${user.m_number}">${user.m_name}</a>			
      </td>
      <td align="left"><a href="likelist.do?userNum=${chat.y_number}"><img src="../img/Heart2.png" alt="���ƿ�" width="20px"/></a></td>
   </c:if>
   <c:if test="${chat.m_like==1}">
      <td align="left">${user.m_name}</td>
      <td align="left"><a href="likelist.do?userNum=${chat.y_number}">�������ƿ䢾</a></td>
   </c:if>
   		</c:if>
      </c:forEach>
   </tr>
   	</tbody>
   </c:forEach> 
</table>

<table class="join02">
	<thead>
   <tr>
      <th colspan="4">���� ���ƿ��� ���</th>
      <th colspan="4">���ƿ�</th>         
   </tr>
   </thead>
   <tbody>
   <c:forEach items="${youpage}" var="chat">
   <tr>
   		<c:forEach items="${userList}" var="user">
   		<c:if test="${chat.m_number == user.m_number}">
   <c:if test="${chat.m_like!=1}">
      <td align="left">${user.m_name}</td>
      <td align="left"><a href="likelist.do?userNum=${chat.m_number}">���ƿ䢾</a></td>
   </c:if>
   <c:if test="${chat.m_like==1}">
      <td align="left">${user.m_name}</td>
      <td align="left"><a href="nolist.do?userNum=${chat.m_number}">�������ƿ䢾</a></td>
   </c:if>
   		</c:if>
   		</c:forEach> 
   </tr>
   </c:forEach>
   </tbody> 
</table>


</body> 
</html>
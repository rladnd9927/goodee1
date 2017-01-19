<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- /WebContent/WEB-INF/jsp/board/detail.jsp --%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>채팅방</title>
</head>
<body>
<table border="1" cellspacing="0" cellpadding="0" width="100%">
   <tr>
   	  <td>상대방 ID</td>
   	  <td>고유번호</td>
   </tr>
   <c:forEach items="${chatlist}" var="chat">
   <tr>
   <c:if test="${chat.m_number == USER.m_number&&chat.m_like==1}">
      <td align="left"><a href="detail.do?num=${chat.c_number}"> ${chat.y_number}</a></td>    
      <td align="left">${chat.c_number}</td> 
   </c:if> 
   <c:if test="${chat.y_number == USER.m_number&&chat.m_like==1}"> 
   	  <td align="left"><a href="detail.do?num=${chat.c_number}">${chat.m_number}</a></td>    
      <td align="left">${chat.c_number}</td> 
   </c:if>
   </tr>  
   </c:forEach>   
</table> 


</body> 
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- /WebContent/WEB-INF/jsp/board/detail.jsp --%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>마이페이지</title>
</head>
<body>
<table border="1" cellspacing="0" cellpadding="0" width="100%">
   <tr>
      <td>내가 좋아요한 사람</td>
      <td>좋아요</td>         
   </tr>
   <c:forEach items="${mypage}" var="chat">
   <tr>
   <c:if test="${chat.m_like!=1}">
      <td align="left">${chat.y_number}</td>
      <td align="left"><a href="likelist.do?userNum=${chat.y_number}">좋아요♥</a></td>
   </c:if>
   <c:if test="${chat.m_like==1}">
      <td align="left">${chat.y_number}</td>
      <td align="left"><a href="likelist.do?userNum=${chat.y_number}">서로좋아요♥</a></td>
   </c:if>
   </tr>
   </c:forEach> 
</table>

<table border="1" cellspacing="0" cellpadding="0" width="100%">
   <tr>
      <td>나를 좋아요한 사람</td>
      <td>좋아요</td>         
   </tr>
   <c:forEach items="${youpage}" var="chat">
   <tr>
   <c:if test="${chat.m_like!=1}">
      <td align="left">${chat.m_number}</td>
      <td align="left"><a href="likelist.do?userNum=${chat.m_number}">좋아요♥</a></td>
   </c:if>
   <c:if test="${chat.m_like==1}">
      <td align="left">${chat.m_number}</td>
      <td align="left"><a href="nolist.do?userNum=${chat.m_number}">서로좋아요♥</a></td>
   </c:if> 
   </tr>
   </c:forEach> 
</table>

</table>

</body> 
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- /WebContent/WEB-INF/jsp/board/detail.jsp --%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ä�ù�</title>
</head>
<body>
<table border="1" cellspacing="0" cellpadding="0" width="100%">
   <c:forEach items="${userlist}" var="chat">
   <c:if test="${chat.m_email != USER.m_email}">
   <tr>
      <td align="left">${chat.m_email}</td>

      <td align="left"><a href="likelist.do?m_email=${chat.m_email}">���ƿ�</a></td> 
   </tr>
   </c:if> 
   </c:forEach>  
</table>


</body> 
</html>
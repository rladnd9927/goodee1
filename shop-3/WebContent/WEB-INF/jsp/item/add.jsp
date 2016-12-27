<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
   <%@include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title><spring:message code="itemAdd.title"/></title>
</head>
<body>
<form:form modelAttribute="item" action="register.shop" enctype="multipart/form-data"> <%--원래 multipart/form-data방식의 method는 항상 post여야 하는데, 스프링에서 form:form태그를 사용하면 알아서 post로 강제로 맞춰준다. --%>
	<h2><font color="green"><spring:message code="itemAdd.title"/></font></h2>
	
	<table>
		<tr>
			<td>상품명</td>
			<td><form:input path="name" maxlength="20"/></td>
			<td><font color="red">
				<form:errors path="name"/>
			</font>
			</td>
		</tr>
		<tr>
			<td>가격</td>
			<td><form:input path="price" maxlength="6"/></td>
			<td><font color="red">
				<form:errors path="price"/>
			</font>
			</td>
		</tr>
		<tr>
			<td>상품이미지</td>
			<td colspan="2"><input type="file" name="picture"></td>
		</tr>
		<tr>
			<td>상품 설명</td>
			<td><form:textarea path="description" cols="50" rows="5"/></td>
			<td><font color="red">
				<form:errors path="description"/>
			</font>
			</td>
		</tr>
		<tr>
			<td colspan="3">
				<input type="submit" value="등록">&nbsp;
				<input type="button" value="목록보기" onclick="location.href='list.shop'">
			</td>
		</tr>
	</table>
</form:form>
</body>
</html>
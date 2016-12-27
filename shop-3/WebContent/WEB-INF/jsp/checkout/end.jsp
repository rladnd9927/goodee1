<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@include file = "/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>쇼핑완료</title>
</head>
<body>
<h2>주문해 주셔서 감사합니다.</h2>

<table border= "0" cellspacing="0" cellpadding="0">
	<tr>
		<td colspan="2">
			<font color="green">배송 받을 곳</font>
		</td>
	</tr>
	<tr>
		<td>사용자ID</td>
		<td>&nbsp;${loginUser.userId}</td>
	</tr>
	<tr>
		<td>이름</td>
		<td>&nbsp;${loginUser.userName}</td>
	</tr>
	<tr>
		<td>우편번호</td>
		<td>&nbsp;${loginUser.postCode}</td>
	</tr>
	<tr>
		<td>주소</td>
		<td>&nbsp;${loginUser.address}</td>
	</tr>
	<tr>
		<td>전화</td>
		<td>&nbsp;${loginUser.phoneNo}</td>
	</tr>
	<tr>
		<td>Email</td>
		<td>&nbsp;${loginUser.email}</td>
	</tr>
</table>
<br><br>
<table border= "0" cellspacing="0" cellpadding="0">
	<tr>
		<td colspan="4">
			<font color="green">주문완료 상품 목록</font>
		</td>
	</tr>
	<tr>
		<th>상품명</th>
		<th>가격</th>
		<th>수량</th>
		<th>소계</th>
	</tr>
	<c:forEach items="${sale.saleItemList}" var="saleItem">
		<tr>
			<td>${saleItem.item.name }</td>
			<td>${saleItem.item.price }원</td>
			<td>${saleItem.quantity }개</td>
			<td>${saleItem.quantity*saleItem.item.price }원</td>
		</tr>	
	</c:forEach>
</table>

<h2>총 주문 금액 : ${totalAmount }원</h2>
<a href = "../item/list.shop">목록 보기</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ include file = "/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>장바구니</title>
</head>
<body>
<h2>장바구니 물품 확인</h2>

<table>
	<tr>
		<th colspan="4">장바구니 상품</th>
	</tr>
	<tr>
		<td>상품명</td>
		<td>가격</td>
		<td>수량</td>
		<td>합계</td>
	</tr>
	<c:set var="tot" value="${0}"/>
	<c:forEach items="${cart.itemList}" var="itemSet" varStatus="stat"> <%--varStatus = 현재 반복문을 몇번째 돌고있는지 알려주는 값.(현재, 리스트를 찍어내고 있기에, varStatus를 해당 리스트의 index로 쓸수 있다.) --%>
		<tr>
			<td>
				${itemSet.item.name}
			</td>
			<td>
				${itemSet.item.price}
			</td>
			<td>
				${itemSet.quantity}
			</td>
			<td>
				${itemSet.item.price * itemSet.quantity}원
				<a href="cartDelete.shop?index=${stat.index}">ⓧ 장바구니에서 제거</a>
			</td>
		</tr>
		<c:set var="tot" value="${tot+(itemSet.item.price * itemSet.quantity)}"/>
		<tr>
			<td colspan="4" align="right">
				<font color="green">총 구입금액 : ${tot }원</font>
			</td>
		</tr>
	</c:forEach>
</table>

<br>${message }<br>
<a href = "../item/list.shop">상품목록</a><br>
<a href = "../checkout/checkout.shop">계산하기</a><br>
</body>
</html>
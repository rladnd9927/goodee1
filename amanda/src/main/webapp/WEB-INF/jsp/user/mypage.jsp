<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="../decorator/css/style.css">
<title>마이페이지</title>
</head>
<body>
	<table cellpadding="0" cellspacing="0" width="100%" class="join02">
		<tr>
			<td rowspan="2" width="30%">
				<table class="join02">
					<thead> 
						<tr>
							<th width="30%" align="left">유저 정보</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
					<tr>
						<th>이메일 / ID</th>
						<td>Test</td>
					</tr>
					<tr>
						<th>닉네임</th>
						<td>Test</td>
					</tr>
					<tr>
						<th>이름</th>
						<td>Test</td>
					</tr>
					<tr>
						<th>학교</th>
						<td>Test</td>
					</tr>
					<tr>
						<th>전공</th>
						<td>Test</td>
					</tr>
					<tr>
						<th>직업</th>
						<td>Test</td>
					</tr>
					<tr>
						<th>생년월일</th>
						<td>Test</td>
					</tr>
					<tr>
						<th>혈액형</th>
						<td>Test</td>
					</tr>
					<tr>
						<th>흡연</th>
						<td>Test</td>
					</tr>
					<tr>
						<th>음주</th>
						<td>Test</td>
					</tr>
					<tr>
						<th>체형</th>
						<td>Test</td>
					</tr>
					<tr>
						<th>성격</th>
						<td>Test</td>
					</tr>
					</tbody>
				</table>
				<a href="">정보수정</a>
			</td>
			<td>
				<table width="70%">
					<tr>
						<td width="50%" align="left">Test님께서"좋아요" 한 회원</td>
						<td width="50%" align="right"><a href="" class="more">더보기</a></td>
					</tr>
				</table>
				<div class="userwrapper">
					<div class="user">
						<div class="usericon" ><img src="" alt="usericon" width="150" height="150"></div>
						<div class="userprofile"><font color="black">mem.id</font></div>
					</div>
				</div>
			</td>
		<tr>
			<td>	
				<table width="70%">
					<tr>
						<td width="50%" align="left">Test님께서"좋아요" 한 회원</td>
						<td width="50%" align="right"><a href="" class="more">더보기</a></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

	<%-- <table border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td colspan="2">주문목록</td>
		</tr>
		<tr>
			<td>주문번호</td>
			<td>주문일자</td>
		</tr>
		<c:forEach items="${salelist}" var="sale" varStatus="stat">
			<tr>
				<td align="center"><a href="javascript:list_disp('saleLine${stat.index}')">${sale.saleId}</a></td>
				<td><f:formatDate value="${sale.updateTime}" pattern="yyyy-MM-dd" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<div id="saleLine${stat.index}" style="display: none;">
						<table border="1" cellpadding="0" cellspacing="0" width="100%">
							<tr>
								<th width="25%">상품명</th>
								<th width="25%">상품가격</th>
								<th width="25%">주문수량</th>
								<th width="25%">합계</th>
							</tr>
							<c:forEach items="${sale.saleItemList}" var="saleItem">
								<tr>
									<td>${saleItem.item.name}</td>
									<td>${saleItem.item.price}</td>
									<td>${saleItem.quantity}</td>
									<td>${saleItem.quantity * saleItem.item.price}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</td>
			</tr>
		</c:forEach>
	</table> --%>
</body>
</html>
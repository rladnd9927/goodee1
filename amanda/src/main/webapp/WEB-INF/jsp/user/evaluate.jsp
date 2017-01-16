<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Amanda</title>
</head>
<body>
	<h2>회원심사 페이지</h2>
	<table class="join02">
		<thead>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>성별</th>
			<th>점수</th>
			<td>심사한 사람 수</td>
			
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${semiuserList}" var="semiuser">
			<tr>
				<td><a href="semiDetail.do?s_number=${semiuser.s_number}">${semiuser.s_email}</a></td>
				<td>${semiuser.s_name}</td>
				<td>${semiuser.gender}</td>
				<td>${semiuser.s_score}</td>
				<td>${semiuser.s_usercount}</td>
			</tr>
			<!-- 
			<tr>
				<td colspan="5">
					<form action="detail.do">
						<input type="hidden" name="id" value="${item.id }">
						<table>
							<tr align="right">
								<td>
									<select name="quantity">
										<option>★☆☆☆☆</option>
										<option>★★☆☆☆</option>
										<option>★★★☆☆</option>
										<option>★★★★☆</option>
										<option>★★★★★</option>
									</select>
								</td>
								<td>
									<input type="submit" value="점수주기">
								</td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
			 -->
		</c:forEach>
		</tbody>
	</table>
</body>
</html>
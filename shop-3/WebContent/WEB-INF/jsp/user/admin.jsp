<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ include file = "/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>관리자 화면</title>
</head>
<body>
<form action="mailForm.shop" method="post">
	<table border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td colspan="7">회원 목록</td>
		</tr>
		<tr>
			<td>아이디</td>
			<td>이름</td>
			<td>생일</td>
			<td>전화번호</td>
			<td>이메일</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<c:forEach items="${userList }" var="user">
			<tr>
				<td>
					${user.userId }
				</td>
				<td>
					${user.userName }
				</td>
				<td>
					${user.birthDay }
				</td>
				<td>
					${user.phoneNo }
				</td>
				<td>
					${user.email }
				</td>
				<td>
					<a href = "updateForm.shop?id=${user.userId }">수정</a>
					<a href = "deleteForm.shop?id=${user.userId }">탈퇴</a>
					<a href = "mypage.shop?id=${user.userId }">회원 페이지</a>
				</td>
				<td>
					<input type="checkbox" name ="idchks" value="${user.userId }"> <%--idchks라는 체크박스를 선택하면 그 컬럼에 해당하는 userId의 value가 mailForm.shop으로 넘어감(유저컨트롤러 mailForm.shop확인) --%>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="7" align="center">
				<input type="submit" value="메일 보내기">
			</td>
		</tr>
	</table>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="../decorator/css/style.css">
<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
<script>
$(document).ready(function(){
$('.user_btn').on('click',function(){
$('.in_table').toggle();
});
});
</script>
<title>회원목록</title>
</head>
<body>
<div class="container">
	<div class="searchuser">
		<form action="listsearch.do" method = "post" name="f">
		 회원 검색:
			<select name="column">
				<option value="">선택하세요</option>
				<option value="region">지역</option>
				<option value="age">나이</option>
				<option value="height">키</option>
			</select>
			<script type="text/javascript">
				document.f.column.value="${param.column}";
			</script>
			<input type="text" name="find" size="50" value="${find}">
			<input type="submit" value="검색" class="search">
		</form>
	</div>

	<h2>명예의 전당</h2>
	<div class="userwrapper">
		<table class="join02">
			<thead>
			<tr><th colspan="7">회원목록</th></tr>
			<tr>
				<td>아이디</td>
				<td>이름</td>
				<td>나이</td>
			</tr>
			</thead>
			<tbody>

			</tbody>
		</table>

	</div>
	<hr/>
	<div class="userwrapper">
		<h2>회원리스트</h2>
		<table class="join02">
		<thead>
			<tr><th colspan="7">회원목록</th></tr>
			<tr>
				<td>사진</td>
				<td>닉네임</td>
				<td>성별</td>
			</tr>
		</thead>
		<tbody >
			<c:forEach items="${userList}" var = "user">
				<tr class= "user_btn">
					<td><a href="userDetail.do?m_number=${user.m_number}"> ${user.m_email}</a></td>
				</tr> 
				<tr class="in_table">
				<c:forEach items="${userProfile}" var="userProfile">
					<c:if test="${userProfile.m_number == user.m_number}">
					<td>${userProfile.m_nickname}</td>
					<td>${userProfile.m_height}</td>
					<td>${userProfile.m_nickname}</td>
					</c:if>
				</c:forEach>
				</tr>
			</c:forEach>
	</table>
</div>
</div> 
</body>
</html>

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
/* function win_open(){
	var url = "userDtail.do?m_email="+document.f.m_email.value";
	var name="win_open";
	window.oepn(url,"회원 상세 정보","width=300,height=300,tollbar=no,location=no,resizable=yes,left=50,right=50");
    /* var op="width=300, height=250, scrollbars=yes, resizeable=no, left=50, top=10";
    window.open("userDetail.do?m_number="+document.f.m_number.value,"m_number",op)}
*/

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
			</thead>
			<tbody>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>나이</th>
				
			</tr>
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
		</thead>
		<tbody >
			<tr>
				<th>성별</th>
				<th>이름</th>
				<th>상세정보</th>
				<th>좋아요</th> 
			</tr>
			<c:forEach items="${userList}" var = "user">
			<c:if test="${sessionScope.USER.m_email != user.m_email}">
				<tr >
					<td><c:if test="${user.gender == 0}">남자</c:if>
						<c:if test="${user.gender == 1}">여자</c:if>
					</td>
					<td >${user.m_name}</td>					
					<td><input type="button" onclick="location.href='userDetail.do?m_number=${user.m_number}'" class="white" value="상세정보"></a></td>
					<td><a href="likelist.do?userNum=${user.m_number}" class="ovalbutton"><img src="../img/Heart.png" alt="좋아요" width="20px"/></a></td>
					<!-- <td><input type="button" name="m_email" onclick="win_oepn()" value="상세정보 보기"></td> -->
				</tr> 
				</c:if>
			</c:forEach>
	</table>
</div>
</div> 
</body>
</html>

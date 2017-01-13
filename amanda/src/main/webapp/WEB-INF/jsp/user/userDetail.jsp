<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div class="joinwrapper">
			<table class="join02">
				<thead>
				 <tr>
					<th colspan="7">회원프로필</th>
				 </tr>
				</thead>
				<tbody>
				 <tr>
				 	<th>사진</th>
				 	<td>sss</td>
				 </tr>
				 <tr>
				 	<th>닉네임</th>
				 	<td>${userProfile.m_nickname}</td>
				 	<th>사진</th>
				 	<td>sss</td>
				 </tr>
				</tbody>
			</table>
			<br />
<!-- 			<div class="joinbutton">
				<input type="reset" class="jb" value="리셋"> 
				<input type="submit" class="jb" value="회원가입">
			</div> -->
		</div>
</body>
</html>
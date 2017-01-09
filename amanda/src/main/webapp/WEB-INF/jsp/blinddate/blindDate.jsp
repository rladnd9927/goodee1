<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="../decorator/css/style.css">
<title>Amanda</title>
</head>
<body>
<div class="blindDate_wrap"><!-- 가장 바깥쪽 wrap -->
	<h2>소개팅 페이지</h2><!-- 해당 페이지 이름(표시용) -> 나중에 생략 -->
	<div class="blindUser"><!-- 소개팅으로 소개되는 유저 -->
		<div class="blindUser_picture">
			<img src="${UserProfile.m_picture1}">
		</div><!-- 유저의 사진 -->
		<div class="blindUser_profile">
			닉네임 : ${UserProfile.m_nickname}<br>
			키 : ${UserProfile.m_height}<br>
			체형 : ${UserProfile.m_bodytype}<br>
			성격 : ${UserProfile.m_character}<br>
			종교 : ${UserProfile.m_religion}<br>
			흡연 : ${UserProfile.m_smoking}<br>
			음주 : ${UserProfile.m_drinking}
		</div><!-- 유저의  -->
		<div class="blindUser_like" align="center">
			<input type="button" value="♡">
		</div><!-- 좋아요 -->
	</div>
</div>
</body>
</html>
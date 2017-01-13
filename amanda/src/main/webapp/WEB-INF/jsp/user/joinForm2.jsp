<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript">
	function win_open() {
		var op = "width=300, height=50, scrollbars=yes,"
				+ "resizeable=yes,left=50,top=150";
		window.open("memberimg.do", "picture", op);
	}
</script>
<link rel="stylesheet" href="../decorator/css/style.css">
<title>회원가입</title>
</head>
<body>
	<form:form modelAttribute="userprofile" method="post" action="joinForm2.do" enctype="multipart/form-data">
		<spring:hasBindErrors name="userprofile">
			<font color="red"> <c:forEach items="${errors.globalErrors}" var="error">
					<spring:message code="${error.code}" />
				</c:forEach>
			</font>
		</spring:hasBindErrors>
		<input type="hidden" name="s_number" value="${userprofile.semiuser.s_number}">
		<input type="hidden" name="s_email" value="${userprofile.semiuser.s_email }">
		<input type="hidden" name="s_password" value="${userprofile.semiuser.s_password }">
		<input type="hidden" name="s_name" value="${userprofile.semiuser.s_name }">
		<input type="hidden" name="gender" value="${userprofile.semiuser.gender }">
		<div class="joinwrapper">
			<div class="joinimg">
				<table>
					<tr>
						<td><img src="" id="pic" width="100" height="120"></td>
						<td><img src="" id="pic" width="100" height="120"></td>
						<td><img src="" id="pic" width="100" height="120"></td>
					</tr>
					<tr>
						<td></td>
						<td align="right">
							<!-- <a href="javascript:win_open()"> 
							<font size="3">사진등록하기</font></a> --> 
							<input type="file" name="m_picture1"> 
							<input type="file" name="m_picture2">
							<input type="file" name="m_picture3">
						</td>
					</tr>
				</table>
			</div>
			<table class="join02">
				<tr>
					<th>닉네임</th>
					<td><form:input path="m_nickname" /></td>
				</tr>
				<tr>
					<th>학교</th>
					<td><form:input path="m_school" /></td>
				</tr>
				<tr>
					<th>전공</th>
					<td><form:input path="m_major" /></td>
				</tr>
				<tr>
					<th>직업</th>
					<td><form:input path="m_job" /></td>
				</tr>
				<tr>
					<th>지역</th>
					<td><form:input path="m_area" /></td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td><form:input path="m_birthday" /></td>
				</tr>
				<tr>
					<th>키</th>
					<td><form:input path="m_height" /></td>
				</tr>
				<tr>
					<th>혈액형</th>
					<td><form:select path="m_bloodtype">
							<form:option value="0">A</form:option>
							<form:option value="1">B</form:option>
							<form:option value="2">AB</form:option>
							<form:option value="3">O</form:option>
						</form:select></td>
				</tr>
				<tr>
					<th>종교</th>
					<td><form:select path="m_religion">
							<form:option value="0">종교없음</form:option>
							<form:option value="1">기독교</form:option>
							<form:option value="2">불교</form:option>
							<form:option value="3">천주교</form:option>
							<form:option value="4">원불교</form:option>
							<form:option value="5">이슬람교</form:option>
							<form:option value="6">유교</form:option>
						</form:select></td>
				</tr>
				<tr>
					<th>흡연</th>
					<td><form:radiobutton path="m_smoking" value="0" label="비흡연" />
						<form:radiobutton path="m_smoking" value="1" label="흡연" /></td>
				</tr>
				<tr>
					<th>음주</th>
					<td><form:select path="m_drinking">
							<form:option value="0">마시지 않음</form:option>
							<form:option value="1">가끔 마심</form:option>
							<form:option value="2">어느정도 즐기는편</form:option>
							<form:option value="3">술자리를 즐김</form:option>
						</form:select></td>
				</tr>
				<tr>
					<th>체형</th>
					<td><form:select path="m_bodytype">
							<form:option value="0">마름</form:option>
							<form:option value="1">슬림탄탄</form:option>
							<form:option value="2">보통</form:option>
							<form:option value="3">통통한</form:option>
							<form:option value="4">살짝볼륨</form:option>
							<form:option value="5">글레머</form:option>
						</form:select></td>
				</tr>
				<tr>
					<th>성격</th>
					<td><form:checkbox path="m_character" value="0" label="지적인" />
						<form:checkbox path="m_character" value="1" label="차분한" /> <form:checkbox
							path="m_character" value="2" label="유머있는" /> <form:checkbox
							path="m_character" value="3" label="낙천적인" /> <form:checkbox
							path="m_character" value="4" label="내향적인" /> <form:checkbox
							path="m_character" value="5" label="외향적인" /> <form:checkbox
							path="m_character" value="6" label="감성적인" /> <form:checkbox
							path="m_character" value="7" label="상냥한" /> <form:checkbox
							path="m_character" value="8" label="귀여운" /> <form:checkbox
							path="m_character" value="9" label="열정적인" /> <form:checkbox
							path="m_character" value="10" label="듬직한" /> <form:checkbox
							path="m_character" value="11" label="개성있는" /></td>
				</tr>
			</table>
			<br />
			<div class="joinbutton">
				<input type="reset" class="jb" value="리셋"> 
				<input type="submit" class="jb" value="회원가입">
			</div>
		</div>
	</form:form>
</body>
</html>
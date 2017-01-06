<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript">
function win_open() {
    var op = "width=300, height=50, scrollbars=yes,"+
    "resizeable=yes,left=50,top=150";
    window.open("memberimg.do","picture",op);
 }
</script>
<link rel="stylesheet" href="../decorator/css/style.css">
<title>회원가입</title>
</head>
<body>
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
         <td align="right"><a href="javascript:win_open()">
         	<font size="3">사진등록하기</font></a></td>
         </tr>
</table>
</div>	
	<table class="join02">
	<tr><th>닉네임</th>
		<td><input type="text" id="nickname"/>
			</td>
	</tr>
	<tr><th>학교</th>
		<td><input type="text" id="school"/>
			</td>
	</tr>
	<tr><th>전공</th>
		<td><input type="text" id="major"/>
			</td>
	</tr>
	<tr><th>직업</th>
		<td><input type="text" id="job"/>
			</td>
	</tr>
	<tr><th>지역</th>
		<td><input type="text" id="area"/>
			</td>
	</tr>
	<tr><th>생년월일</th>
		<td><input type="text" id="birthday"/>
			</td>
	</tr>
	<tr><th>키</th>
		<td><input type="text" id="height"/>
			</td>
	</tr>
	<tr><th>혈액형</th>
		<td><select>
				<option selected="selected">A</option>
				<option>B</option>
				<option>AB</option>
				<option>O</option>
			</select>
		</td>
	</tr>
	<tr><th>종교</th>
		<td><select>
				<option selected="selected">기독교</option>
				<option>불교</option>
			</select>
			</td>
	</tr>
	<tr><th>흡연</th>
		<td><input type="text" id="smoking"/>
			</td>
	</tr>
	<tr><th>음주</th>
		<td><input type="text" id="drinking"/>
			</td>
	</tr>
	<tr><th>체형</th>
		<td><input type="text" id=bodytype/>
			</td>
	</tr>
	<tr><th>성격</th>
		<td><input type="text" id="character"/>
			</td>
	</tr>
</table>
<br/>
<div class="joinbutton">
<input type="reset" class="jb" value="리셋">
<input type="button" class="jb" value="회원가입">
</div>
</div>
</body>
</html>
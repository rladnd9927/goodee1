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
<title>ȸ������</title>
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
         	<font size="3">��������ϱ�</font></a></td>
         </tr>
</table>
</div>	
	<table class="join02">
	<tr><th>�г���</th>
		<td><input type="text" id="nickname"/>
			</td>
	</tr>
	<tr><th>�б�</th>
		<td><input type="text" id="school"/>
			</td>
	</tr>
	<tr><th>����</th>
		<td><input type="text" id="major"/>
			</td>
	</tr>
	<tr><th>����</th>
		<td><input type="text" id="job"/>
			</td>
	</tr>
	<tr><th>����</th>
		<td><input type="text" id="area"/>
			</td>
	</tr>
	<tr><th>�������</th>
		<td><input type="text" id="birthday"/>
			</td>
	</tr>
	<tr><th>Ű</th>
		<td><input type="text" id="height"/>
			</td>
	</tr>
	<tr><th>������</th>
		<td><select>
				<option selected="selected">A</option>
				<option>B</option>
				<option>AB</option>
				<option>O</option>
			</select>
		</td>
	</tr>
	<tr><th>����</th>
		<td><select>
				<option selected="selected">�⵶��</option>
				<option>�ұ�</option>
			</select>
			</td>
	</tr>
	<tr><th>��</th>
		<td><input type="text" id="smoking"/>
			</td>
	</tr>
	<tr><th>����</th>
		<td><input type="text" id="drinking"/>
			</td>
	</tr>
	<tr><th>ü��</th>
		<td><input type="text" id=bodytype/>
			</td>
	</tr>
	<tr><th>����</th>
		<td><input type="text" id="character"/>
			</td>
	</tr>
</table>
<br/>
<div class="joinbutton">
<input type="reset" class="jb" value="����">
<input type="button" class="jb" value="ȸ������">
</div>
</div>
</body>
</html>
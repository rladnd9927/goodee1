<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>답글달기</title>
</head>
<body>
<form action = "reply.shop" method = "post" name="boardform">
	<input type ="hidden" name="num" value="${board.num }"> <%--hidden속성의 input은 원글에대한 정보들을 담기위해 작성 --%>
	<input type ="hidden" name="ref" value="${board.ref }">
	<input type ="hidden" name="refLevel" value="${board.refLevel }">
	<input type ="hidden" name="refStep" value="${board.refStep }">
	
	<table border="1" cellspacing="0" cellpadding="0">
		<tr align="center">
			<td colspan="2">
				게시판
			</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="pass"></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" name="subject"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td>
				<textarea name="content" rows="15" cols="67">
				</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<a href = "javascript:document.boardform.submit()">[답글 등록]</a>
				<a href = "list.shop">[목록]</a>
			</td>
		</tr>
	</table>
</form>
</body>
</html>
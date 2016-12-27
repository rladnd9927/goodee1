<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@include file = "/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>사용자 등록 화면</title>
</head>
<body>

<%--문제--
	../shop-3/user/userEntryForm.shop으로 요청시(URL), 이 페이지가 출력 되도록 Controller와 메소드들을 작성하기.
 --%>

<h2>사용자 등록</h2>

	<%--ㅡmodelAttribute 속성 : 뷰 실행시 전달되는 객체를 지정한다.
		이 뷰파일이 실행되면 "user"라는 객체를 넘겨받길 기다리고 있는데, UserEntryFormController클래스의 @RequestMapping부분을 보면 user 객체를
		넘겨주지 않는다. 이때, 객체가 없으므로 다음으로 @ModelAttribute가 있는 메소드에서 user객체를 넘겨주게 된다.
	 --%>
<form:form modelAttribute="user" method="post" action="userEntry.shop"> <%--전송 버튼을 누르면 이 페이지를 호출할때와 같이 userEntry.shop으로 요청을 보내는데, method방식이 post이다. UserEntryController에서 POST방식일때 필요한 @RequestMapping을 만들어줘야한다. --%>
	<spring:hasBindErrors name="user">	<%--shop-2에선 validator클래스에서 reject메소드를 이용했지만, 어노테이션을 이용해서 처리 가능함. --%>
		<font color="red">
			<c:forEach items= "${errors.globalErrors}" var="error"><%--erros.globalErrors는 UserEntryValidator.java 클래스의 reject("error.input.users")에 해당한다. (reject()는 messages.properties에 error.input.users 에서 확인가능)  --%>
				<spring:message code ="${error.code}"/>
			</c:forEach>	
		</font>
	</spring:hasBindErrors>
	<table>
		<tr>
			<td>아이디</td>
			<td><form:input path="userId"/>
				<font color="red">
				<form:errors path="userId"/></font><%--form:errors는 UserEntryValidator.java 클래스의 rejectValue("userId","error.required")에 해당 --%>
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><form:input path="password"/>
				<font color="red">
				<form:errors path="password"/></font>
			</td>
		</tr>
		<tr>
			<td>이름</td>
			<td><form:input path="userName"/>
				<font color="red">
				<form:errors path="userName"/></font>
			</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><form:input path="phoneNo"/>
				<font color="red">
				<form:errors path="phoneNo"/></font>
			</td>
		</tr>
		<tr>
			<td>우편번호</td>
			<td><form:input path="postCode"/>
				<font color="red">
				<form:errors path="postCode"/></font>
			</td>
		</tr>
		<tr>
			<td>주소</td>
			<td><form:input path="address"/>
				<font color="red">
				<form:errors path="address"/></font>
			</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><form:input path="email"/>
				<font color="red">
				<form:errors path="email"/></font>
			</td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td><form:input path="birthDay"/>
				<font color="red">
				<form:errors path="birthDay"/></font>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type= "submit" value="등록"/>
				<input type= "reset" value="초기화"/>
			</td>
		</tr>
	</table>
</form:form>
</body>
</html>
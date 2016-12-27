<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ include file = "/WEB-INF/jsp/jspHeader.jsp" %>
    
    <%--BoardController list()에서 따로 뷰네임 설정하는부분 (serViewName)이 없기때문에 requestmapping때 넘어온 경로에 의해 바로 list.jsp로 설정 --%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시판</title>
</head>
<body>

<table border="1" cellspacing="0" cellpadding="0" width="100%">
	<c:if test="${listcount>0 }">
		<tr>
			<td colspan="4" align="center">상품의견 게시판</td>
			<td>글 갯수: ${listcount }</td>
		</tr>
		<tr align="center" valign="middle" bordercolor="#212121">
			<td width="8%">
				번호
			</td>
			<td width="50%">
				제목
			</td>
			<td width="14%">
				작성자
			</td>
			<td width="17%">
				날짜
			</td>
			<td width="11%">
				조회수
			</td>
		</tr>
		<c:set var="boardnum" value="${boardnum }"/>
		<c:forEach items="${boardlist }" var = "board">
			<tr align="center" valign="middle" bordercolor="#333333" onmouseover="this.style.backgroundColor='#5CD1E5'" onmouseout="this.style.backgroundColor=''">
				<td>${boardnum}</td>
				<c:set var="boardnum" value="${boardnum-1 }"/>
				<td align="left">
					<c:if test="${not empty board.fileUrl }">
						<a href="../fileupload/${board.fileUrl}">@</a>
					</c:if>
					<c:if test="${empty board.fileUrl }">
						&nbsp;&nbsp;&nbsp;
					</c:if>
					<c:forEach begin="1" end="${board.refLevel }">
						&nbsp;&nbsp;&nbsp;
					</c:forEach>
					<c:if test="${board.refLevel>0 }">
						▶
					</c:if>
					
					<a href="detail.shop?num=${board.num }">${board.subject}</a>
				</td>
				<td align="left">
					${board.name }
				</td>
				<td align="center">
					<c:if test="${board.dateFormat == today }">
						<f:formatDate value="${board.regDate}" pattern="HH : mm : ss"/>
					</c:if>
					<c:if test="${board.dateFormat != today }">
						<f:formatDate value="${board.regDate}" pattern="yyyy-MM-dd HH : mm"/>
					</c:if>
				</td>
				<td align="center">
					${board.readCnt }
				</td>
			</tr>
		</c:forEach>
		<tr align="center">
			<td colspan="5">
				<c:if test="${pageNum >1 }">
					<a href = "list.shop?pageNum=${pageNum-1 }">[이전]</a>
				</c:if>
				<c:if test="${pageNum <=1 }">
					[이전]
				</c:if>
				<c:forEach var="a" begin="${startpage }" end="${endpage}">
					<c:if test="${pageNum==a }">[${a}]</c:if>
					<c:if test="${pageNum!=a }"><a href ="list.shop?pageNum=${a}">[${a}]</a></c:if>
				</c:forEach>
				<c:if test="${pageNum<maxpage}">
					<a href = "list.shop?pageNum=${pageNum+1}">[다음]</a>
				</c:if>
				<c:if test="${pageNum>=maxpage}">
					[다음]
				</c:if>
			</td>
		</tr>
	</c:if>
	<c:if test="${listcount==0 }">
		<tr>
			<td colspan="5">
				등록된 게시물이 없습니다.
			</td>
		</tr>
	</c:if>
	<tr>
		<td align="right" colspan="5">
			<a href="add.shop">[글쓰기]</a>
		</td>
	</tr>
</table>

</body>
</html>
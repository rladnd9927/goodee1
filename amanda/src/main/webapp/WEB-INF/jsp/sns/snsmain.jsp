<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="../decorator/css/style.css">
<title>님의 SNS</title>
</head>
<body>
<div class="mainWrapper"> <%--가장 바깥 wrapper --%>
  <div class="wrapper"><%-- 한 게시물 wrapper --%>
    <div class="header"><%--본 게시물의 헤더 (프로필, 프사), 등록시간 --%>
    	<div id = "profilePhoto"> <%--프사부분 --%>
    		<a href=""><img src=""/></a>
    	</div>
    	<div id = "userId"> <%--사용자 아이디 노출 부분 --%>
    		<a href="">사용자아이디</a>
    	</div>
    	<div id="uploadTime"> <%--게시물 업로드 시간 표시 --%>
    	</div>
    </div>
    <div class="body"> <%--본 게시물  --%>
    a
    </div>
    <div class="reply"><%--본 게시물의 댓글부분--%>
    
    <!-- 이 부분은 댓글을 표시하는 부분임. 이부분은 게시물 댓글이 하나도 없는경우 div 표시하지 않고, 댓글이 달린경우에 한해서 표시하도록 할것. (if 문을 이용해 hidden속성을 이용)
    
    	<div id = "reply"> 
    		<div id = "replyCount"> <%--댓글 갯수 표시하는 부분 --%>
    		</div>
    		<ul id = "replyList">
    			댓글 갯수가 5개를 넘어갈 경우, 아코디언 스타일로 구현 
    			<li> <%--실제 댓글 1줄 -> 이 안에 댓글 단사람 아이디와, 댓글이 표시될 것 --%>
    				<a href="">댓글 단 사람 아이디</a>
    				<span>댓글 내용</span>
    			</li>
    		</ul>
    	</div>
     -->	
    	
    	<div id = "writeReply"> <%--댓글 다는 댓글창 부분  input 텍스트창으로 할 것. placeholder속성에 댓글입력하라고 표시해 줄것--%>
    	a
    	</div>
    </div>
  </div>
<br><br>

</div>

</body>
</html>
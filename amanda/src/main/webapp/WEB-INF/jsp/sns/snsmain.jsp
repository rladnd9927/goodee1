<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="../decorator/css/style.css">
<title>���� SNS</title>
</head>
<body>
<div class="mainWrapper"> <%--���� �ٱ� wrapper --%>
  <div class="wrapper"><%-- �� �Խù� wrapper --%>
    <div class="header"><%--�� �Խù��� ��� (������, ����), ��Ͻð� --%>
    	<div id = "profilePhoto"> <%--����κ� --%>
    		<a href=""><img src=""/></a>
    	</div>
    	<div id = "userId"> <%--����� ���̵� ���� �κ� --%>
    		<a href="">����ھ��̵�</a>
    	</div>
    	<div id="uploadTime"> <%--�Խù� ���ε� �ð� ǥ�� --%>
    	</div>
    </div>
    <div class="body"> <%--�� �Խù�  --%>
    a
    </div>
    <div class="reply"><%--�� �Խù��� ��ۺκ�--%>
    
    <!-- �� �κ��� ����� ǥ���ϴ� �κ���. �̺κ��� �Խù� ����� �ϳ��� ���°�� div ǥ������ �ʰ�, ����� �޸���쿡 ���ؼ� ǥ���ϵ��� �Ұ�. (if ���� �̿��� hidden�Ӽ��� �̿�)
    
    	<div id = "reply"> 
    		<div id = "replyCount"> <%--��� ���� ǥ���ϴ� �κ� --%>
    		</div>
    		<ul id = "replyList">
    			��� ������ 5���� �Ѿ ���, ���ڵ�� ��Ÿ�Ϸ� ���� 
    			<li> <%--���� ��� 1�� -> �� �ȿ� ��� �ܻ�� ���̵��, ����� ǥ�õ� �� --%>
    				<a href="">��� �� ��� ���̵�</a>
    				<span>��� ����</span>
    			</li>
    		</ul>
    	</div>
     -->	
    	
    	<div id = "writeReply"> <%--��� �ٴ� ���â �κ�  input �ؽ�Ʈâ���� �� ��. placeholder�Ӽ��� ����Է��϶�� ǥ���� �ٰ�--%>
    	a
    	</div>
    </div>
  </div>
<br><br>

</div>

</body>
</html>
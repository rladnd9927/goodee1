<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ include file="/WEB-INF/jsp/jspHeader.jsp"%>
<c:set var = "contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css" rel="stylesheet" type="text/css">
  </head><body data-spy="scroll">
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <ul class="lead nav nav-justified nav-pills">
              <li class="active">
                <a href="snsmain.do">나의 SNS</a>
              </li>
              <li>
                <a href="snsreg.do">글쓰기</a>
              </li>
              <li>
                <a href="othersns.do">내가 좋아요한 회원</a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    <div class="section"><div class="container"><div class="row"><div class="col-md-12"><hr></div></div></div></div>
    
    <div class="section"> <%--게시물 섹션 시작 (컨테이너) --%>
    <c:forEach items="${snsList}" var="sns">
      <div class="section"> <%--게시물섹션 반복구간 시작 --%>
        <div class="container">
          <div class="row">
            <div class="col-md-4">
              <img src="${sns.fileUrl}" class="img-circle img-responsive">
            </div>
            <div class="col-md-8">
              <h1 class="text-primary">${sns.sns_subject}</h1>
              
              <p>${sns.sns_content}</p>
              <a href="snsreply.do" class="reply"><i class="fa fa-3x fa-comments-o fa-fw text-success"></i></a>
              <a href="snsmodifyForm.do"><i class="fa fa-3x fa-fw fa-undo s-o text-warning"></i></a>
              <a href="snsdelete.do"><i class="fa fa-3x fa-fw text-muted fa-minus"></i></a>
            </div>
          </div>
        </div>
      </div>
      <div class="container"> <%--문단구분선 --%>
	      <div class="row">
	     	 <div class="col-md-12"><hr></div>
	      </div>
	 </div>
	 </c:forEach>
	 </div>
  

</body></html>
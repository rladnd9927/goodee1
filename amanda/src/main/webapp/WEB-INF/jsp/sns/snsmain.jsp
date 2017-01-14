<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ include file="/WEB-INF/jsp/jspHeader.jsp"%>
<c:set var = "contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>SNS 메인 페이지</title>
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css" rel="stylesheet" type="text/css">
    <style type="text/css">
	    #clickforajax:hover{
	    	cursor:pointer;
	    }
    </style>
    <script type="text/javascript">
		$(document).ready(function() {
			$("#clickforajax").click(function() {
				var sns_no =$("#snsno").val();
				var m_number =$("#mnumber").val();
				$.ajax({url:"snsdetail.do",
						datatype:"json",
						data:"sns_no=sns_no&m_number=m_number",
						success : function(data) {
						var json = eval("("+data+")");
						for(var i =0;i<json.length;i++){
							$("body").append(
								"<h1>"+json[i].name+":"+json[i].gender + ":" + json[i].part + "</h1>"
							);
						}
						}
					});
			});
		});
</script>
  </head><body data-spy="scroll">
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <ul class="lead nav nav-justified nav-pills">
              <li>
                <a href="snsmain.do">나의 SNS</a>
              </li>
              <li class="active">
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
    <c:if test="${empty snsList}">
    	<div id="fullcarousel-example" data-interval="false" class="carousel slide"
    data-ride="carousel">
      <div class="carousel-inner">
        <div class="item">
          <img src="https://unsplash.imgix.net/photo-1423347834838-5162bb452ca7?w=1024&amp;q=50&amp;fm=jpg&amp;s=c255e589621f06513c1d123c7323fe9c">
          <div class="carousel-caption">
            <h1>등록된 게시물이 없습니다.</h1>
            <p><a href="snsreg.do" style="color:red;">지금 게시물을 등록해 보세요!</a></p>
          </div>
        </div>
        <div class="item active">
          <img src="https://unsplash.imgix.net/photo-1421986527537-888d998adb74?w=1024&amp;q=50&amp;fm=jpg&amp;s=e633562a1da53293c4dc391fd41ce41d">
          <div class="carousel-caption">
            <h1>등록된 게시물이 없습니다.</h1>
            <p><a href="snsreg.do" style="color:red;">지금 게시물을 등록해 보세요!</a></p>
          </div>
        </div>
        <div class="item">
          <img src="https://ununsplash.imgix.net/reserve/RONyPwknRQOO3ag4xf3R_Kinsey.jpg?w=1024&amp;q=50&amp;fm=jpg&amp;s=c8e85e7825f6c74ff13321833a9bc28d">
          <div class="carousel-caption">
            <h1>등록된 게시물이 없습니다.</h1>
            <p><a href="snsreg.do" style="color:red;">지금 게시물을 등록해 보세요!</a></p>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="#fullcarousel-example" data-slide="prev"><i class="icon-prev fa fa-angle-left"></i></a>
      <a class="right carousel-control" href="#fullcarousel-example" data-slide="next"><i class="icon-next fa fa-angle-right"></i></a>
    </div>
    </c:if>
    <c:if test="${not empty snsList}">
    <c:forEach items="${snsList}" var="sns">
      <div class="section"> <%--게시물섹션 반복구간 시작 --%>
        <div class="container">
          <div class="row">
	            <input type = "hidden" id="snsno" value="${sns.sns_no }"/>
	   		 	<input type = "hidden" id="mnumber" value="${sns.m_number }"/>	
            <c:if test="${sns.fileUrl ne 'nothing'}">
	            <div class="col-md-4">
	              <img id = "clickforajax" src="../fileupload/${sns.fileUrl}" class="img-circle img-responsive">
	            </div>
            </c:if>
            <div class="col-md-8">
              <h1 id = "clickforajax" class="text-primary">${sns.sns_subject}</h1>
              
              <p>${sns.sns_content}</p>
              <a href="#" id = "clickforajax" class="reply"><i class="fa fa-3x fa-comments-o fa-fw text-success"></i></a>
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
	 </c:if>
	 </div>
  

</body></html>
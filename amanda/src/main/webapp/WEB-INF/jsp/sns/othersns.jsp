<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var = "contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css" rel="stylesheet" type="text/css">
  </head><body>
    
    <div class="section"><div class="container"><div class="row"><div class="col-md-12"><ul class="lead nav nav-justified nav-pills"><li><a href="snsmain.do">나의 SNS</a>
              </li>
              <li class="active">
                <a href="snsreg.do">글쓰기</a>
              </li>
              <li>
                <a href="othersns.do">내가 좋아요한 회원</a></li></ul></div></div></div></div><div class="section"><div class="container"><div class="row"><div class="col-md-12"><div class="section"><div class="container"><div class="row"><div class="col-md-4"><img src="https://unsplash.imgix.net/photo-1422728221357-57980993ea99?w=1024&amp;q=50&amp;fm=jpg&amp;s=b4a34018d745e33048bcfc326cb9907b" class="img-circle img-responsive"></div><div class="col-md-8"><ol><li>One</li><li>Two</li><li>Three</li></ol></div></div></div></div></div></div></div></div><div class="section"><div class="container"><div class="row"><div class="col-md-12"><hr></div></div></div></div><div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h1 class="text-center">Gallery</h1>
          </div>
        </div>
        
        <div class="row"> <%--사진 3개당 1줄 차지 --%>
          <div class="col-md-4">
            <a><img src="https://unsplash.imgix.net/photo-1423347834838-5162bb452ca7?w=1024&amp;q=50&amp;fm=jpg&amp;s=c255e589621f06513c1d123c7323fe9c" class="img-responsive img-rounded"></a>
            <h2 class="text-center">A title</h2>
          </div>
          <div class="col-md-4">
            <a><img src="https://unsplash.imgix.net/photo-1423683249427-8ca22bd873e0?w=1024&amp;q=50&amp;fm=jpg&amp;s=5e57c661d0f772ce269188a6f5325708" class="img-responsive img-rounded"></a>
            <h2 class="text-center">A title</h2>
          </div>
          <div class="col-md-4">
            <a><img src="https://unsplash.imgix.net/reserve/MTuhqSiPQbeVnaIYU16X_P1160798_adj.jpg?w=1024&amp;q=50&amp;fm=jpg&amp;s=ede6dca4fff55fa0cc6ec27bcd3480d9" class="img-responsive img-rounded"></a>
            <h2 class="text-center">A ttile</h2>
          </div>
        </div>
        
      </div>
    </div><div class="section"><div class="container"><div class="row"><div class="col-md-12"><hr></div></div></div></div>
    <div class="section" align="center">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <a href="#"><i class="fa fa-5x fa-fw fa-plus-circle text-primary"></i></a>
          </div>
        </div>
      </div>
    </div>
  

</body></html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="./css/snsdetail.css">
<script type="text/javascript" src="./js/snsdetail.js"></script>
<title>${loginUser.M_nickname}님의 SNS</title>
</head>
<body>


<div class="modal img-modal">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-body">
        <div class="row">
          <div class="col-md-8 modal-image">
            <img class="img-responsive " src="http://www.made-in-italy.com/files/imagecache/lg/pictures/travel-to-italy/news/2013/02/george-clooney-omega-testimonial-1.jpg">
            <img class="img-responsive hidden" src="http://upload.wikimedia.org/wikipedia/commons/1/1a/Bachalpseeflowers.jpg" />
            <img class="img-responsive hidden" src="http://www.netflights.com/media/216535/hong%20kong_03_681x298.jpg" />

            <a href="" class="img-modal-btn left"><i class="glyphicon glyphicon-chevron-left"></i></a>
            <a href="" class="img-modal-btn right"><i class="glyphicon glyphicon-chevron-right"></i></a>
          </div>
          <div class="col-md-4 modal-meta">
            <div class="modal-meta-top">
              <button type="button" class="close"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
              <div class="img-poster clearfix">
                <a href=""><img class="img-circle" src="https://s-media-cache-ak0.pinimg.com/736x/3b/7d/6f/3b7d6f60e2d450b899c322266fc6edfd.jpg"/></a>
                <strong><a href="">John Doe</a></strong>
                <span>12 minutes ago</span>
              </div>

              <ul class="img-comment-list">
                <li>
                  <div class="comment-img">
                    <img src="http://lorempixel.com/50/50/people/6">
                  </div>
                  <div class="comment-text">
                    <strong><a href="">Jane Doe</a></strong>
                    <p>Hello this is a test comment.</p> <span class="date sub-text">on December 5th, 2016</span>
                  </div>
                </li>
                <li>
                  <div class="comment-img">
                    <img src="http://lorempixel.com/50/50/people/7">
                  </div>
                  <div class="comment-text">
                    <strong><a href="">Jane Doe</a></strong>
                    <p>Hello this is a test comment and this comment is particularly very long and it goes on and on and on.</p> <span>on December 5th, 2016</span>
                  </div>
                </li>
                <li>
                  <div class="comment-img">
                    <img src="http://lorempixel.com/50/50/people/9">
                  </div>
                  <div class="comment-text">
                    <strong><a href="">Jane Doe</a></strong>
                    <p class="">Hello this is a test comment.</p> <span class="date sub-text">on December 5th, 2016</span>
                  </div>
                </li>
              </ul>
            </div>
            <div class="modal-meta-bottom">
              <input type="text" class="form-control" placeholder="Leave a commment.."/>
            </div>
          </div>
        </div>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div>

<p class="text-center text-muted">Updated Dec. 5th 2016 with basic responsive styles</p>


</body>
</html>
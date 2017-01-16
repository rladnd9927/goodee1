<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>

<!DOCTYPE html>
<html><head>
        <meta charset="utf-8">
        <!-- This file has been downloaded from Bootsnipp.com. Enjoy! -->
        <title>Social-network style lightbox - Bootsnipp.com</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="./css/detail.css" />
        <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    </head><body>
        <div class="modal img-modal">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-md-8 modal-image">
                                <img class="img-responsive " src="https://ununsplash.imgix.net/photo-1423753623104-718aaace6772?w=1024&amp;q=50&amp;fm=jpg&amp;s=1ffa61419561b5c796bca3158e7c704c">
                                <img class="img-responsive hidden" src="http://upload.wikimedia.org/wikipedia/commons/1/1a/Bachalpseeflowers.jpg">
                                <img class="img-responsive hidden" src="http://www.netflights.com/media/216535/hong%20kong_03_681x298.jpg">
                                <a href="" class="img-modal-btn left"><i class="glyphicon glyphicon-chevron-left"></i></a>
                                <a href="" class="img-modal-btn right"><i class="glyphicon glyphicon-chevron-right"></i></a>
                            </div>
                            <div class="col-md-4 modal-meta">
                                <div class="modal-meta-top">
                                    <button type="button" class="close">
                                        <span aria-hidden="true">¡¿</span>
                                        <span class="sr-only">Close</span>
                                    </button>
                                    <div class="img-poster clearfix">
                                        <a href=""><img class="img-circle" src="https://s-media-cache-ak0.pinimg.com/736x/3b/7d/6f/3b7d6f60e2d450b899c322266fc6edfd.jpg"></a>
                                        <strong>
                                            <a href="">John Doe</a>
                                        </strong>
                                        <span>12 minutes ago</span>
                                    </div>
                                    <ul class="img-comment-list">
                                        <li>
                                            <div class="comment-img">
                                                <img src="http://lorempixel.com/50/50/people/6">
                                            </div>
                                            <div class="comment-text">
                                                <strong>
                                                    <a href="">Jane Doe</a>
                                                </strong>
                                                <p>Hello this is a test comment.</p>
                                                <span class="date sub-text">on December 5th, 2016</span>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="comment-img">
                                                <img src="http://lorempixel.com/50/50/people/7">
                                            </div>
                                            <div class="comment-text">
                                                <strong>
                                                    <a href="">Jane Doe</a>
                                                </strong>
                                                <p>Hello this is a test comment and this comment is particularly very long
                                                    and it goes on and on and on.</p>
                                                <span>on December 5th, 2016</span>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="comment-img">
                                                <img src="http://lorempixel.com/50/50/people/9">
                                            </div>
                                            <div class="comment-text">
                                                <strong>
                                                    <a href="">Jane Doe</a>
                                                </strong>
                                                <p class="">Hello this is a test comment.</p>
                                                <span class="date sub-text">on December 5th, 2016</span>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                                <div class="modal-meta-bottom">
                                    <input type="text" class="form-control" placeholder="Leave a commment..">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.modal-content -->
            </div>
            <!-- /.modal-dialog -->
        </div>
        <div class ="bg"></div>
        <p class="text-center text-muted">Updated Dec. 5th 2016 with basic responsive styles</p>
        <script type="text/javascript">
            $(function(){
                // This code is not even almost production ready. It's 2am here, and it's a cheap proof-of-concept if anything.
                $(".img-modal-btn.right").on('click', function(e){
                    e.preventDefault();
                    cur = $(this).parent().find('img:visible()');
                    next = cur.next('img');
                    par = cur.parent();
                    if (!next.length) { next = $(cur.parent().find("img").get(0)) }
                    cur.addClass('hidden');
                    next.removeClass('hidden');
                    
                    return false;
                })
                
                $(".img-modal-btn.left").on('click', function(e){
                    e.preventDefault();
                    cur = $(this).parent().find('img:visible()');
                    next = cur.prev('img');
                    par = cur.parent();
                    children = cur.parent().find("img");
                    if (!next.length) { next = $(children.get(children.length-1)) }
                    cur.addClass('hidden');
                    next.removeClass('hidden');
                    
                    return false;
                })
            
            });
        </script>
    

</body></html>
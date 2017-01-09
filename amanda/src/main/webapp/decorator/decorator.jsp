<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var = "contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><decorator:title/></title>

    <!-- Bootstrap -->
    <link href="${contextPath}/decorator/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="${contextPath}/decorator/css/font-awesome.min.css">
	<link rel="stylesheet" href="${contextPath}/decorator/css/jquery.bxslider.css">
	<link rel="stylesheet" type="text/css" href="${contextPath}/decorator/css/isotope.css" media="screen" />	
	<link rel="stylesheet" href="${contextPath}/decorator/css/animate.css">
	<link rel="stylesheet" href="${contextPath}/decorator/js/fancybox/jquery.fancybox.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${contextPath}/decorator/css/style.css">	
  </head>
  <body>
	<header>
		<nav div class="navbar navbar-default navbar-static-top" role="navigation">
			<div class="navbar-brand">
							<a href="index.html"><h1><span>A</span>manda</h1></a>
						</div>
			<div class="container">
			</div>
		</nav>
		
		<nav class="navbar navbar-default navbar-static-top" role="navigation">
			<div class="navigation">
				<div class="container">					
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse.collapse">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
					</div>
					
					<div class="navbar-collapse collapse">							
						<div class="menu">
							<ul class="nav nav-tabs" role="tablist">
								<li role="presentation"><a href="index.html" class="active">HOME</a></li>
								<li role="presentation"><a href="services.html">List</a></li>
								<li role="presentation"><a href="blog.html">Sogaeting</a></li>
								<li role="presentation"><a href="portfolio.html">SNS</a></li>
								<li role="presentation"><a href="contact.html">MyPage</a></li>		
								<li role="presentation"><a href="contact.html">Chat</a></li>						
							</ul>
						</div>
					</div>						
				</div>
			</div>	
		</nav>		
	</header>
	
	<decorator:body/>
	<footer>
		<div class="last-div">
			<div class="container">
				<div class="row">
					<div class="copyright">
						<b>&copy;</b> <b>Amanda</b>
					</div>
					<div class="team-name">
						<b>Team3 Amanda</b>
					</div>
					<div class="clear"></div>
				</div>
			</div>
			<a href="" class="scrollup"><i class="fa fa-chevron-up"></i></a>	
		</div>		
	</footer>
   
	
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->	
    <script src="${contextPath}/decorator/js/jquery-2.1.1.min.js"></script>	
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${contextPath}/decorator/js/bootstrap.min.js"></script>
	<script src="${contextPath}/decorator/js/wow.min.js"></script>
	<script src="${contextPath}/decorator/js/fancybox/jquery.fancybox.pack.js"></script>
	<script src="${contextPath}/decorator/js/jquery.easing.1.3.js"></script>
	<script src="${contextPath}/decorator/js/jquery.bxslider.min.js"></script>
	<script src="${contextPath}/decorator/js/functions.js"></script>
	<script>wow = new WOW({}).init();</script>
    
</body>
</html>
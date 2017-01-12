<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="../decorator/css/style.css">
<script src="http://code.jquery.com/jquery-1.12.0.min.js"></script>
<script>
$(document).ready(function(){
$('.left_btn').on('click',function(){
$('.in_table').toggle();
});
});
</script>
</head>
<body>
<div class="left_btn">sssssssss</div>
<table border='1px' cellspacing='0' width='100%'>
	<tbody class="left_btn">
   <tr><th colspan='2' bgcolor='lightblue'>Left Document</th>
   </tbody>
   <tr bgcolor='lightblue'><th width='25%'>Attribute</th><th>Value</th>
   <table border='1px' cellspacing='0' width='100%' class="in_table">
      
    <tr align='center'><th bgcolor='lightblue'>emptyFlag</th><td id="L21"></td>
   </table>
   </table>
</body>
</html>

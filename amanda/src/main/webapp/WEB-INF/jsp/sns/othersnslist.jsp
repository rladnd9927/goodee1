<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>���ƿ� �� ȸ������ �Խù�</title>
<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script type="text/javascript"
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="../decorator/css/style.css">
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css"
	rel="stylesheet" type="text/css">
	<style type="text/css">
#bgc{
	background-color :  #ffffff;
}
#fixedSize{
	width : 200px;
	height : 200px;
}
#close {
	cursor: pointer;
}

#ajaxprepend {
	display: none;
	position : absolute;
	left : 10px;
	top : 100px;
	vertical-align: top;
	width: 100%;
	height: 100%;
	z-index: 1000;
}
#prev{
	cursor : pointer;
}
#next{
	cursor : pointer;
}
</style>

<script type="text/javascript"
	src="${contextPath}/decorator/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
		$(document).ready(function() {
			$("a#clickAtag").bind("click", function(event){
				event.preventDefault();
				var sns_no = $(this).parents().parents().children("#snsno").val();
				var m_number = $(this).parents().parents().children("#mnumber").val();
				ajax(sns_no, m_number);
			});
			$("a#prev").bind("click", function(event){
				event.preventDefault();
				var sns_no = parseInt($("#currsnsnum").val()) - 1;
				var m_number = parseInt($("#currmembernum").val()) - 1;
				console.log(sns_no);
				console.log(m_number);
				ajax(sns_no, m_number);
			});
			$("a#next").bind("click", function(event){
				event.preventDefault();
				var sns_no = parseInt($("#currsnsnum").val()) + 1;
				var m_number = parseInt($("#currmembernum").val()) + 1;
				ajax(sns_no, m_number);
			});
			
			function ajax(sns_no, m_number) {
				$.ajax({url:"snsdetail.do",
					data:"sns_no="+sns_no+"&m_number="+m_number, //����, �����͸� ������ ������ �ͱ����� ��..
					success : function(data) {
						makePopup(data); //�ش� ��Ŀ�±� ������ �˾��������� ���� 
					},
					 error : function(xhr, status, error){
			                alert(" ������ �ҷ����µ� ���� �߽��ϴ�. : "+xhr.status + "\n status :" + status + "\n error : "+error);
		            }
				});
			}
			
			function makePopup(json){ // json�̶�� ��Ʈ�� �迭�� �޴´�.
				
				var data1 = eval("("+json[0]+")"); //json���� ({,,,})�� ���°��� ��Һ��� ������ �Ľ����ִ� ������ eval()�� �Ѵ�.
				var data2 = eval("("+json[1]+")"); //data1 = SNS�Խñ��� ����, data2 = �Խñۿ� ���� ����� ����
				//data1 (�Խù�)�� ������ �Ʒ� picturesrc������ �ҷ����� ������� �θ���, data2(���)������ �迭�� ���·� �����Ƿ�, for���� �̿��Ͽ� data2[i].~~~�� ���·� �̾Ƴ���.
				var loginUserNum = $("#loginuser").val();
				var picturesrc = "../fileupload/"+data1.fileUrl; //�Խù� �����ּ�
				var replyCnt = data2.length; //����� ����
				var html = "";
				html += "<div class=\"section\" id=\"ajaxprepend\">                                                                                                                                     ";
			    html += "  <div class=\"container\">                                                                                                                                 ";
			    html += "    <div class=\"row\" id=\"bgc\">                                                                                                                                     ";
			    html += "      <div class=\"col-md-8\">                                                                                                                              ";
			    html += "        <div data-interval=\"false\" id=\"fullcarousel-example\" class=\"carousel slide\" data-ride=\"carousel\">" ;
			    html += "          <div class=\"carousel-inner\">                                                                                                                    ";
			    html += "            <div class=\"item active\">                                                                                                                     ";
			    html += "              <img src=\"https://unsplash.imgix.net/photo-1423347834838-5162bb452ca7?w=1024&amp;q=50&amp;fm=jpg&amp;s=c255e589621f06513c1d123c7323fe9c\">   ";
			    html += "            </div>                                                                                                                                        ";
			    html += "          </div>                                                                                                                                          ";
			    html += "          <a href=\"javascript:void(0);\" class=\"left carousel-control\"  id=\"prev\"><i class=\"icon-prev fa fa-angle-left\"></i></a>          ";
			    html += "          <a href=\"javascript:void(0);\" class=\"right carousel-control\"  id=\"next\"><i class=\"icon-next fa fa-angle-right\"></i></a>         ";
			    html += "        </div>                                                                                                                                            ";
			    html += "      </div>                                                                                                                                              ";
			    html += "      <div class=\"col-md-4\">                                                                                                                              ";
			   	html += " 		<i id = \"close\" class=\"fa fa-2x fa-fw fa-times-circle pull-right text-muted\"></i>";
			    html += "        <div class=\"row\">                                                                                                                                 ";
			    html += "          <h3 class=\"text-primary\">"
			    html += "�� �Խù��� ���� "+replyCnt+"�� �� ���</h3>"
			    html += "        </div>"
			    html += "        <hr>                                                                                                                                              ";
			    html += "        <div class=\"replyWrapper\">                                                                                                                        ";
			    for(var i = 0; i < replyCnt; i++){
			    html += "          <div class=\"replyDetail\">                                                                                                                       ";
			    html += "            <ul>                                                                                                                                          ";
			    html += "              <li id=\"replyTitle\">                                                                                                                        ";
			    html += "                <h4 class=\"text-primary\">"+data2[i].m_nickname+"���� ���</h4>";
			    html += "              </li>                                                                                                                                       ";
			    html += "              <h5>"+data2[i].r_content+"</h5>                                                                                                                                 ";
			    console.log(data2[i].m_number);
			    console.log(loginUserNum);
			    if(data2[i].m_number == loginUserNum){
		    	html += "            	<a href=\"javascript:if(confirm('����ðڽ��ϱ�?')) document.location.href='replydelete.do?sns_no="+data1.sns_no+"&m_number="+data1.m_number+"&r_num="+data2[i].r_num+"'\">[��� ����]</a>";
			    }
			    html += "            </ul>                                                                                                                                         ";
			    html += "          </div>                                                                                                                                          ";
			    }
			    html += "        </div>                                                     ";
			    html += " 		<hr>                                                              ";
	            html += " 		<div class=\"custom-search-form input-group input-group-sm\">       ";
	            html += "   			<input type=\"text\" class=\"form-control\" placeholder=\"Type the comment\" id = \"comment\">";
	            html += "   			<input type=\"hidden\" id = \"currsnsnum\" value =\""+data1.sns_no+"\">";
	            html += "   			<input type=\"hidden\" id = \"currmembernum\" value =\""+data1.m_number+"\">";
	            html += "   			<span class=\"input-group-btn\"> ";
	            html += "     		<button class=\"btn btn-default\" type=\"button\" onclick=\"replyReg()\">";
	            html += "       <i class=\"fa fa-comment-o\"></i>                                ";
	            html += "     </button>                                                     ";
	            html += "   </span>                                                         ";
	            html += " </div>                                                            ";
	            html += " </div>                                                            ";
	            html += " </div>                                                            ";
	            html += " </div>                                                            ";
	            html += " </div>                                                             ";
	            
                
	            $("#makePopup").append(html);
				$("#ajaxprepend").fadeIn(); //.ajaxprepend : ���� �ٱ� div�� Ŭ������. css���� ���־�� ��.
				$("#close").off("click");
				$("#close").on("click", function () {
					$("#ajaxprepend").fadeOut(function () {
						$("#ajaxprepend").remove();
							
					});
					
				});
			}
		});
		
		function replyReg(){
			var r_content = $("#comment").val();
			var sns_no = $("#currsnsnum").val();
			console.log(r_content);
			console.log(sns_no);
			$.ajax({
				url : "replyreg.do",
				data : "sns_no="+sns_no+"&r_content="+r_content,
				success : function(data){
					makePopup(data);
				},
				error : function(xhr, status, error){
	                alert(" ������ �ҷ����µ� ���� �߽��ϴ�. : "+xhr.status + "\n status :" + status + "\n error : "+error);
            	}
			});
		}
</script>
</head>


<body data-spy="scroll">
	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<ul class="lead nav nav-justified nav-pills">
						<li><a href="snsmain.do">���� SNS</a></li>
						<li class="active"><a href="snsreg.do">�۾���</a></li>
						<li><a href="othersnslist.do">���� ���ƿ��� ȸ���� �ҽ�</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<hr>
				</div>
			</div>
		</div>
	</div>
	
     <div id = "makePopup">
     
	<div class="section">
		<%--�Խù� ���� ���� (�����̳�) --%>
		<c:if test="${empty snsList}">
			<div id="fullcarousel-example" data-interval="false"
				class="carousel slide" data-ride="carousel">
				<div class="carousel-inner">
					<div class="item">
						<img
							src="https://unsplash.imgix.net/photo-1423347834838-5162bb452ca7?w=1024&amp;q=50&amp;fm=jpg&amp;s=c255e589621f06513c1d123c7323fe9c">
						<div class="carousel-caption">
							<h1>��ϵ� �Խù��� �����ϴ�.</h1>
						</div>
					</div>
					<div class="item active">
						<img
							src="https://unsplash.imgix.net/photo-1421986527537-888d998adb74?w=1024&amp;q=50&amp;fm=jpg&amp;s=e633562a1da53293c4dc391fd41ce41d">
						<div class="carousel-caption">
							<h1>��ϵ� �Խù��� �����ϴ�.</h1>
						</div>
					</div>
					<div class="item">
						<img
							src="https://ununsplash.imgix.net/reserve/RONyPwknRQOO3ag4xf3R_Kinsey.jpg?w=1024&amp;q=50&amp;fm=jpg&amp;s=c8e85e7825f6c74ff13321833a9bc28d">
						<div class="carousel-caption">
							<h1>��ϵ� �Խù��� �����ϴ�.</h1>
						</div>
					</div>
				</div>
				<a class="left carousel-control" href="#fullcarousel-example"
					data-slide="prev"><i class="icon-prev fa fa-angle-left"></i></a> <a
					class="right carousel-control" href="#fullcarousel-example"
					data-slide="next"><i class="icon-next fa fa-angle-right"></i></a>
			</div>
		</c:if>
		<c:if test="${not empty snsList}">
			<c:forEach items="${snsList}" var="sns">
				<div class="section">
					<%--�Խù����� �ݺ����� ���� --%>
					<div class="container">
						<div class="row">
							<input type="hidden" id="snsno" value="${sns.sns_no }" /> <input
								type="hidden" id="mnumber" value="${sns.m_number }" />
							<input type="hidden" id="loginuser" value="${loginUser.m_number}" /> 
							<c:if test="${sns.fileUrl ne 'nothing'}">
								<div class="col-md-4">
									<img src="../fileupload/${sns.fileUrl}"
										class="img-circle img-responsive" id="fixedSize">
								</div>
							</c:if>
							<div class="col-md-8">
								<h5 class="text-muted text-right">
									<c:if test="${sns.datetoString == today}">
										<%--SNS��ü�� property�� datetoString�� �̿��� ���� ��¥���� �� --%>
          			${sns.userProfile.m_nickname}���� ���� <f:formatDate value="${sns.sns_date}" pattern="a hh:mm" />&nbsp;�� ���
       			</c:if>
									<c:if test="${sns.datetoString != today}">
										${sns.userProfile.m_nickname}���� <f:formatDate value="${sns.sns_date}"
											pattern="yyyy-MM-dd a hh:mm" />&nbsp;�� ���
       			</c:if>
								</h5>
								<h1 class="text-primary">
									<a href="javascript:void(0)" id="clickAtag">${sns.sns_subject}</a>
								</h1>

								<p>${sns.sns_content}</p>
								<div class="col-md-12 text-right">
									<a href="javascript:void(0);" id="clickAtag"><i class="fa fa-3x fa-comments-o fa-fw text-success"></i></a> 
									
            					</div>
							</div>
						</div>
					</div>
				</div>
				<div class="container">
					<%--���ܱ��м� --%>
					<div class="row">
						<div class="col-md-12">
							<hr>
						</div>
					</div>
				</div>



			</c:forEach>
		</c:if>
	</div>

</div>

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

</body>
</html>
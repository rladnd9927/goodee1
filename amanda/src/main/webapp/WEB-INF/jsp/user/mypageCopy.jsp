<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="../decorator/css/style.css">
<title>����������</title>
</head>
<body>
	<table border="1" cellpadding="0" cellspacing="0" width="100%">
		<tr>
			<td rowspan="2" width="30%">
				<table width="100%"> 
					<tr>
						<td width="50%" align="left">���� ����</td>
						<td width="50%" align="right"><a href="" class="more">���� ����</a></td>
					</tr>
				</table>
				<table border="1" cellpadding="0" cellspacing="0">
					<tr>
						<td>�̸��� / ID</td>
						<td>Test</td>
					</tr>
					<tr>
						<td>�г���</td>
						<td>Test</td>
					</tr>
					<tr>
						<td>�̸�</td>
						<td>Test</td>
					</tr>
					<tr>
						<td>�б�</td>
						<td>Test</td>
					</tr>
					<tr>
						<td>����</td>
						<td>Test</td>
					</tr>
					<tr>
						<td>����</td>
						<td>Test</td>
					</tr>
					<tr>
						<td>�������</td>
						<td>Test</td>
					</tr>
					<tr>
						<td>������</td>
						<td>Test</td>
					</tr>
					<tr>
						<td>��</td>
						<td>Test</td>
					</tr>
					<tr>
						<td>����</td>
						<td>Test</td>
					</tr>
					<tr>
						<td>ü��</td>
						<td>Test</td>
					</tr>
					<tr>
						<td>����</td>
						<td>Test</td>
					</tr>
				</table>
			</td>
			<td>
				<table width="100%">
					<tr>
						<td width="50%" align="left">Test�Բ���"���ƿ�" �� ȸ��</td>
						<td width="50%" align="right"><a href="" class="more">������</a></td>
					</tr>
				</table>
				<div class="userwrapper">
					<div class="user">
						<div class="usericon" ><img src="" alt="usericon" width="150" height="150"></div>
						<div class="userprofile"><font color="black">mem.id</font></div>
					</div>
				</div>
			</td>
		</tr>
		<tr>
			<td>
				<table width="100%">
					<tr>
						<td width="50%" align="left">Test�Բ���"���ƿ�" �� ȸ��</td>
						<td width="50%" align="right"><a href="" class="more">������</a></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

	<%-- <table border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td colspan="2">�ֹ����</td>
		</tr>
		<tr>
			<td>�ֹ���ȣ</td>
			<td>�ֹ�����</td>
		</tr>
		<c:forEach items="${salelist}" var="sale" varStatus="stat">
			<tr>
				<td align="center"><a href="javascript:list_disp('saleLine${stat.index}')">${sale.saleId}</a></td>
				<td><f:formatDate value="${sale.updateTime}" pattern="yyyy-MM-dd" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<div id="saleLine${stat.index}" style="display: none;">
						<table border="1" cellpadding="0" cellspacing="0" width="100%">
							<tr>
								<th width="25%">��ǰ��</th>
								<th width="25%">��ǰ����</th>
								<th width="25%">�ֹ�����</th>
								<th width="25%">�հ�</th>
							</tr>
							<c:forEach items="${sale.saleItemList}" var="saleItem">
								<tr>
									<td>${saleItem.item.name}</td>
									<td>${saleItem.item.price}</td>
									<td>${saleItem.quantity}</td>
									<td>${saleItem.quantity * saleItem.item.price}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</td>
			</tr>
		</c:forEach>
	</table> --%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>下载文件显示页</title>
</head>
<body>
	<table align="center" style="width: 450px" cellpadding="0"
		cellspacing="0" border="1">
		<tr>
			<th style="text-align: center;">文件名</th>
			<th style="text-align: center;">操作</th>
		</tr>
		<!-- 遍历Map集合 -->
		<c:forEach var="filemap" items="${fileNameMap}">
			<tr>
				<c:url value="download.do?actionName=downloadImageAction" var="downurl">
					<td><c:param name="filename" value="${filemap.key}"></c:param></td>
				</c:url>
				<td>${filemap.value}</td>
				<td><a href="${downurl}">下载</a></td>
			</tr>
			<br />
		</c:forEach>
	</table>
	
	<table align="center" >
		<tr>
			<td colspan="3"><a
				href="pageSplitAction.do?actionName=pageSplitAction">返回</a></td>
		</tr>
	</table>
</body>
</html>
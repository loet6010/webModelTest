<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户详细列表</title>
</head>
<body>

	<script type="text/javascript">
		function gotoSelectedPage() {
			var x = document.getElementById("navigatorForm");
			//alert("Original action: " + x.action)
			x.submit();
		}

		if (document.getElementById("checkboxall").checked) {
			alert("checkbox is checked");
		}

		function chickAll() {
			// 全选方法
			var chickBoxs = document.getElementsByName("userIds");
			for (var i = 0; i < chickBoxs.length; i++) {

				chickBoxs[i].checked = "checked";
			}
		}

		function Nochick() {
			// 全选方法
			var chickBoxs = document.getElementsByName("userIds");
			for (var i = 0; i < chickBoxs.length; i++) {

				chickBoxs[i].checked = !chickBoxs[i].checked;
			}
		}
		
		function searchCheck() {
			var searchName = searchForm.searchName.value;
			if (searchName == "") {
				alert("检索内容不能为空");
			} else {
				searchForm.submit();
			}
		}
		
		document.getElementsByName("radioName")[1].checked="checked";
		
	</script>

	<c:if test="${not empty userList}">
		<form
			action="deleteAll.do?actionName=deleteUsersAction&pageNumber=${pageNumber}"
			method="post">
			<table align="center" style="width: 600px; text-align: center;"
				cellpadding="0" cellspacing="0" border="1">
				<tr>
					<th></th>
					<th>用户ID</th>
					<th>用户名</th>
					<th>年龄</th>
					<th>民族</th>
					<th>地址</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${userList}" var="user">
					<tr>
						<td><input type="checkbox" name="userIds"
							value="${user.userId}"></td>
						<td>${user.userId }</td>
						<td>${user.userName }</td>
						<td>${user.age }</td>
						<td>${user.birthday }</td>
						<td>${user.address }</td>
						<td><a
							href="modify.do?actionName=userModifyAction&userId=${user.userId}&pageNumber=${pageNumber}">修改</a>
							<a
							href="delete.do?actionName=userDeleteAction&userId=${user.userId}&pageNumber=${pageNumber}">删除</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<table align="center">
				<tr>
					<td><input type="button" value="全选" name="checkall"
						id="checkall" onclick="chickAll()" /></td>
					<td><input type="button" value="反选" name="nocheck"
						id="nocheck" onclick="Nochick()" /></td>
					<td><input type="submit" value="批量删除" /></td>
				</tr>
			</table>
		</form>


		<form action="pageSplitAction.do?actionName=pageSplitAction"
			method="post" id="navigatorForm">
			<table align="center">
				<tr>
					<td><a
						href="pageSplitAction.do?actionName=pageSplitAction&pageNumber=1">首页</a>
					</td>
					<td><c:if test="${pageNumber>1}">
							<a
								href="pageSplitAction.do?actionName=pageSplitAction&pageNumber=${pageNumber-1}">上一页</a>
						</c:if></td>
					<td><c:if test="${pageNumber<totalPages}">
							<a
								href="pageSplitAction.do?actionName=pageSplitAction&pageNumber=${pageNumber+1}">下一页</a>
						</c:if></td>
					<td>跳转到第 <select name="pageNumber"
						onchange="gotoSelectedPage();">
							<c:forEach begin="1" end="${totalPages}" step="1" var="pageIndex">
								<c:choose>
									<c:when test="${pageIndex eq pageNumber}">
										<option value="${pageIndex}" selected="selected">${pageIndex}</option>
									</c:when>
									<c:otherwise>
										<option value="${pageIndex}">${pageIndex}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select>页
					</td>
					<td><a
						href="pageSplitAction.do?actionName=pageSplitAction&pageNumber=${totalPages}">末页</a>
					</td>
				</tr>
			</table>
		</form>
		<br />
		<table align="center">
			<tr>
				<td><a href="addUser.jsp">增加用户</a></td>
				<td>&nbsp;&nbsp;<a
					href="recoverUser.do?actionName=recoverUserAction">恢复用户</a></td>
			</tr>
		</table>

		<br />
		<form action="searchUsers.do?actionName=usersSearchAction"
			method="post" name="searchForm">
			<table align="center">
				<tr>
					<td>部分匹配<input type="radio" name="matchName" value="partMatch"
						checked="checked" /></td>
					<td>&nbsp;完全匹配<input type="radio" name="matchName"
						value="wholeMatch" /></td>
					<td>&nbsp;匹配字段<select name="customers">
							<option value="username">用户名</option>
							<option value="userid">用户ID</option>
							<option value="age">年龄</option>
							<option value="birthday">民族</option>
							<option value="address">地址</option>
					</select></td>
					<td><input type="text" name="searchName" /></td>
					<td><input type="button" value="检索" onclick="searchCheck()" /></td>
				</tr>
			</table>
		</form>
		
		<br/>

		<form action="upload.do?actionName=uploadImageAction" method="post"
			enctype="multipart/form-data">
			<table align="center">
				<tr>
					<td><img src="./upload/123.jpg" width="200" height="200"></td>
				</tr>
				<tr>
					<td>请选择上传的图片或文件:<input type="file" name="fileName" /></td>
					<td><input type="submit" value="上传" /></td>
				</tr>
			</table>
		</form>		
		<br />
		<form action="download.do?actionName=downloadJumpAction" method="post">
			<table align="center">
				<tr>
					<td><input type="submit" value="进入下载页" /></td>
				</tr>
				<tr>
					<td><a href="exit.jsp">退出登陆</a></td>
				</tr>
			</table>
		</form>

	</c:if>

	<c:if test="${empty userList}">
		<h2 align="center">
			暂时还没有任何数据，点击<a href="addUser.jsp">添加</a>或者<a
				href="recoverUser.do?actionName=recoverUserAction">恢复</a>进行增添数据
		</h2>
	</c:if>

</body>
</html>